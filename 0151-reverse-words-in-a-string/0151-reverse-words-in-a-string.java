class Solution {
    public String reverseWords(String s) {
        String ans = "";
        String[] arr = s.split(" ");
        
        for(String str : arr){
            
            if(str.trim().isEmpty()) continue;
            ans = str + " " + ans;
            
        }
        return ans.trim();
    }
}