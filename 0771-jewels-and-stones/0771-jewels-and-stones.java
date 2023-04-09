class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Integer,Character> map = new HashMap<>();
        
       for(int i=0;i<jewels.length();i++){
           map.put(i,jewels.charAt(i));
       }
        
        int cnt=0;
        
        for(int i=0;i<stones.length();i++){
            
            if(map.containsValue(stones.charAt(i))){
                cnt++;
            }
            
        }
        return cnt;
    }
}