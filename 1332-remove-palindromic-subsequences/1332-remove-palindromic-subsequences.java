class Solution {
    public int removePalindromeSub(String s) {
    if (s == null || s.length() == 0) {
        return 0; // This is the situation #1.
    }     
    int i = 0;
    int j = s.length() - 1;
    while (i < j) { // Checking the input string whether it is a Palindrome or not, by using the two pointers i and j.
        if (s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        } else {
            return 2; // The input string cannot pass the while-loop, so it is not a Palindrome. This is the situation #3.
        }
    }
    return 1; // The input string passes the while-loop, so it is a Palindrome, so we need 1 operation! This is the situation #2.

    }
}