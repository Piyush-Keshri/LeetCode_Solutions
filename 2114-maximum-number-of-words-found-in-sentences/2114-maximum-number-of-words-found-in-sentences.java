class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxcnt = -1;
        for(int i=0;i<sentences.length;i++){
            
            String[] str = sentences[i].split(" ");
            if(str.length>maxcnt){
                maxcnt = str.length;
            }
            
        }
        return maxcnt;
    }
}