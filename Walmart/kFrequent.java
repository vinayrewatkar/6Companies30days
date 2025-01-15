import java.util.*;

class Pair {
    String word;
    int frequency;

    Pair(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a PriorityQueue to find the top k frequent words
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqCompare = map.get(a) - map.get(b); // Compare frequency
            if (freqCompare == 0) {
                return b.compareTo(a); // For ties, compare lexicographically (reverse order)
            }
            return freqCompare;
        });

        // Add words to the priority queue
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent/lexicographically largest word
            }
        }

        // Step 3: Collect results from the priority queue
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result); // Reverse to get the most frequent words first
        return result;
    }
}
