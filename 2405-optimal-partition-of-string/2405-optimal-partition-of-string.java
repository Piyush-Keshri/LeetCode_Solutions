class Solution {
    public int partitionString(String s) {
        
        int[] vis = new int[26];
        
        Arrays.fill(vis,-1);
        
        int cnt =1;
        
        int substringStart = 0;
        
        for(int i = 0;i<s.length();i++){
            if(vis[s.charAt(i)-'a']>=substringStart){
                cnt++;
                substringStart = i;
            }
            vis[s.charAt(i) -'a'] = i;
        }
        return cnt;
    }
}