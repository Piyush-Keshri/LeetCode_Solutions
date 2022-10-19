class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Hande null data and edge cases
        if (words == null | words.length == 0) return new ArrayList<>();
        
        // Use a map to keep track of counts
        Map<String, Integer> map = new HashMap<>();
        // Use a list to keep track of words, to then sort them
        List<String> list = new ArrayList<>();
        
        for (String word : words) {
            // Count the # of times a words appears
            map.put(word, map.getOrDefault(word, 0) + 1);
            // Load only unique words to list
            if (!list.contains(word)) list.add(word);
        }
        
        Collections.sort(list, (String a, String b) -> {
                int aCount = map.get(a);
                int bCount = map.get(b);
            
                // If the counts are equal, then use String.compareTo to lexigraphically compare the strings
                if (aCount == bCount) {
                    return a.compareTo(b);
                } else {  // Else sort by greatest count
                    return bCount - aCount;
                }
            });
        
        // Return a list with only up to k elements
        return list.subList(0, k);
    }
}