class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for(int i=0;i<words.length;i++){
            
            String str = words[i];
            
            if(str.length()<=s.length()){
                
                String str1 = s.substring(0,str.length());
                
               if(str1.equals(str)){
                   cnt++;
               } 
            }
            
        }
        return cnt;
    }
}