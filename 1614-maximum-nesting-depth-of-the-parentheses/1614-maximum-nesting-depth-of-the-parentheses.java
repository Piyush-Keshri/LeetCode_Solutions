class Solution {
    public int maxDepth(String s) {
        
        int maxcnt = 0;
        int cnt = 0;        
        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                cnt++;
            }
            else if(s.charAt(i) == ')'){
                cnt--;
            }
            
                maxcnt = Math.max(cnt,maxcnt);
        }
        
        return maxcnt;
    }
}