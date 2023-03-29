class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
     
        if(bloomDay.length < m*k){
            return -1;
        }
        
        int ans = -1;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int x:bloomDay){
            start = Math.min(start,x);
            end = Math.max(end,x);
        }
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(valid(bloomDay,mid,m,k)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    
    public boolean valid(int[] bloomDay,int mid,int m,int k){
        
        int bouquets = 0;
        int flowersCollected =0;
        
        for(int value : bloomDay){
            
            if(value<=mid){
                flowersCollected++;
            }
            else{
                
                flowersCollected = 0;
            }
            if(flowersCollected == k){
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets>=m;
    }
    
}













