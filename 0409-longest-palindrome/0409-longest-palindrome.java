class Solution {
    public int longestPalindrome(String s) {
        int palindromeLength = 0;
        char[] charMap = new char[128];
        
        for(char ch: s.toCharArray()){
            
            charMap[ch]++;
        }
        
        for(int count:charMap){
            if(count%2 == 0){
                palindromeLength+=count;
            }
            else if(count/2 >= 1){
                palindromeLength = palindromeLength + count -1;
            }
        }
        return palindromeLength+(s.length()>palindromeLength ? 1:0);
    }
}