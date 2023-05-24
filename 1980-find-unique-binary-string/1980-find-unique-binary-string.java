class Solution {
    public String findDifferentBinaryString(String[] nums) {
    // Convert the input array into a set for faster lookup.
    Set<String> seen = new HashSet<>(Arrays.asList(nums));
    
    // Determine the length of the binary strings.
    int n = nums[0].length();
    
    // Generate all possible binary strings of length n, one bit at a time, using a recursive backtrack function.
    return backtrack("", n, seen);
}

// A recursive function to generate all possible binary strings of length n.
public String backtrack(String s, int n, Set<String> seen) {
    // If the current string has length n, check if it is unique.
    if (s.length() == n) {
        if (!seen.contains(s)) {
            return s; // Return the unique binary string.
        } else {
            return null; // This string is not unique, continue searching.
        }
    }
    
    // Append a "0" or a "1" to the current string and recursively call the backtrack function.
    String result = backtrack(s + "0", n, seen);
    if (result != null) {
        return result; // Return the unique binary string.
    }
    result = backtrack(s + "1", n, seen);
    if (result != null) {
        return result; // Return the unique binary string.
    }
    return null; // This branch does not lead to a unique binary string, continue searching.
}
}