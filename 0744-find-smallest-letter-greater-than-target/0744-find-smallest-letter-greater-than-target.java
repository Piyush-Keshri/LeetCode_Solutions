class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int tar = target - 'a';
        
        for(int i=0;i<letters.length;i++){
            
            int curr = letters[i] -'a';
            if(curr>tar){
                return letters[i];
            }
        }
        return letters[0];
    }
}