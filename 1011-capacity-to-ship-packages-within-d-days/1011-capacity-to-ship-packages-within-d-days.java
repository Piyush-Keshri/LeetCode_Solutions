class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int start =0;
        int end = 0;
        int ans = 0;
        for(int x:weights){
            start = Math.max(start,x);
            end += x;
        }
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(valid(weights,mid,days)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    
    public boolean valid(int[] weights,int mid,int days){
        
        int weight = 0;
        int day = 1;
        for(int x : weights){
            weight+=x;
            
            if(weight>mid){
                day++;
                weight = x;
            }
        }
        return (day<=days);
    }
    
}