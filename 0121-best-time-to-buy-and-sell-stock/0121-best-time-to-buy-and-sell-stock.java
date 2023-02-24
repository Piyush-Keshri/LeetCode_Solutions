class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int pro = 0;
        
        for(int i=0;i<prices.length;i++){
            
            if(prices[i]<min){
                min = prices[i];
            }
            
            pro = Math.max(pro,prices[i]-min);
            
        }
        return pro;
    }
}