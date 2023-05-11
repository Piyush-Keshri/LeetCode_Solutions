class Solution {
    public int percentageLetter(String s, char letter) {
        
        int cnt = 0;
        
        for(char x: s.toCharArray()){
            if(letter == x){
                cnt++;
            }
        }
        
        int ans = (cnt*100)/s.length();
        return ans;
    }
}