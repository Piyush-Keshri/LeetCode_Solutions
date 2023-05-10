class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int c=0;
        
        while(c<str1.length()){
            
            if(str1.charAt(c) == str2.charAt(c)){
                c++;
            }
            else{
                break;
            }
        }
        return str1.substring(0,c);
    }
}