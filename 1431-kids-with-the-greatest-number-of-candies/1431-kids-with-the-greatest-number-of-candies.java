class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> ans = new ArrayList<>();
        
        int max =0 ;
        for(int x: candies){
            max = Math.max(max,x);
        }
        
        for(int x: candies){
            
            ans.add(x+extraCandies>=max);
            
        }
        return ans;
    }
}