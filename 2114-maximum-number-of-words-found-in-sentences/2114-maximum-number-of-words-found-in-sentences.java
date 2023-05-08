class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxcnt = 0;
        for(int i=0;i<sentences.length;i++){
            
            String str = sentences[i];
            int cnt = 0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == ' '){
                    cnt++;
                }
            }
            
            maxcnt = Math.max(maxcnt,cnt+1);
        }
        return maxcnt;
    }
}