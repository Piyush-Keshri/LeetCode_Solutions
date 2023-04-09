class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int cnt=0;
        
        for(int i=0;i<jewels.length();i++){
            
            for(int j=0;j<stones.length();j++){
                
                if(jewels.charAt(i) == stones.charAt(j)){
                    cnt++;
                }
                
            }
            
        }
        return cnt;
    }
}