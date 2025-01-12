class Solution {
    class Pair {
        boolean f;
        int x;

        Pair(boolean f, int x) {
            this.f = f;
            this.x = x;
        }
    }

    int max;

    public int amountOfTime(TreeNode root, int start) {
        max = 0;
        sol(root, start);
        return max;
    }

    public Pair sol(TreeNode root, int start) {
        if (root == null)
            return new Pair(false, 0);
        Pair left = sol(root.left, start);
        Pair right = sol(root.right, start);
        if (root.val == start) {
            max = Math.max(max, Math.max(left.x, right.x));
            return new Pair(true, 1);
        }
        if (left.f) {
            max = Math.max(max, left.x + right.x);
            left.x += 1;
            return left;
        } else if (right.f) {
            max = Math.max(max, left.x + right.x);
            right.x += 1;
            return right;
        }
        return new Pair(false, Math.max(left.x, right.x) + 1);
    }
}