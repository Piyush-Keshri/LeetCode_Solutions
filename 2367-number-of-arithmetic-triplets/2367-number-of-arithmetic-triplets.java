class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            
            boolean nxt = binarySearch(nums,nums[i]+diff);
            boolean nxt1 = binarySearch(nums,nums[i]+diff+diff);
        
            if(nxt && nxt1){
                cnt++;
            }
            
        }
        return cnt;
    }
    
    public boolean binarySearch(int[] nums,int target){
        
        int st = 0;
        int end = nums.length-1;
        
        while(st<=end){
            
            int mid = st+(end-st)/2;
            
            if(target == nums[mid]){
                return true;
            }
            
            else if(target<nums[mid]){
                end = mid-1;
            } 
            else{
                st = mid+1;
            }
        }
        return false;
    }
    
}