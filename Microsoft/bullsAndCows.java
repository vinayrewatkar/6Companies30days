class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int bullCounts = 0;
        boolean[] visited = new boolean[secret.length()];

        // First pass to calculate bulls and update the map
        for (int i = 0; i < secret.length(); i++) {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);

            if (secretChar == guessChar) {
                bullCounts++;
                visited[i] = true; // Mark this position as a bull
            } else {
                // Add characters from the secret to the map
                map.put(secretChar, map.getOrDefault(secretChar, 0) + 1);
            }
        }

        int cowCounts = 0;

        // Second pass to calculate cows
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);

            // Skip if it's already a bull
            if (visited[i]) {
                continue;
            }

            // Check if the guess character exists in the map
            if (map.containsKey(guessChar) && map.get(guessChar) > 0) {
                cowCounts++;
                map.put(guessChar, map.get(guessChar) - 1); // Decrease the count in the map
            }
        }

        // Format the result as "xAyB"
        return bullCounts + "A" + cowCounts + "B";
    }
}
