class Solution {
    public int maxVowels(String s, int k) {
      Set<Character> st = Set.of('a','e','i','o','u');
        
        int cnt = 0;
        for(int i=0;i<k;i++){
            if(st.contains(s.charAt(i)))
            cnt++;
        }
        
        int ans = cnt;
               
        for(int i=k;i<s.length();i++){
            
            cnt+=st.contains(s.charAt(i))?1:0;
            cnt-=st.contains(s.charAt(i-k))?1:0;
            ans = Math.max(ans,cnt);
        }
               return ans;
    }
}