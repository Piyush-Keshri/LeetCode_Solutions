class Solution {
    public int prefixCount(String[] words, String pref) {
        
        int len = pref.length();
        int cnt = 0;
        
        for(int i=0;i<words.length;i++){
            String str ="";
            if(words[i].length()>=len){
               str = words[i].substring(0,len);
            }
            
            if(str.equals(pref)){
                cnt++;
            }
        }
        
        return cnt;
    }
}