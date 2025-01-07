class Solution {

    private Map<Key, Integer> memo = new HashMap<>();

    public int waysToReachStair(int k) {
        return dp(1, k, 0, 0);
    }

    // direction = 1 (move to the back)
    // direction = 2 (move to the front)
    private int dp(int position, int k, int direction, int jump) {
        // if out of bounds return 0
        if (position < 0 || position > k + 1) {
            return 0;
        }

        Key key = new Key(position, direction, jump);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // check the result if we are at K its 1 one otherwise 0
        int ways = position == k ? 1 : 0;

        // if we can move to the back we add to the result the number of solutions we
        // get by moving to the back
        if (position > 0 && direction != 1) {
            ways += dp(position - 1, k, 1, jump);
        }
        // calculate the front jump
        int frontJump = (int) (position + Math.pow(2, jump));

        // add to the result the number of solutions we get by jumping to the front
        ways += dp(frontJump, k, 0, jump + 1);

        // memo the result
        memo.put(key, ways);
        return ways;
    }

    private class Key {
        private int position;
        private int prev;
        private int jump;

        public Key(int position, int prev, int jump) {
            this.position = position;
            this.prev = prev;
            this.jump = jump;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Key key = (Key) o;
            return position == key.position && prev == key.prev && jump == key.jump;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, prev, jump);
        }
    }
}