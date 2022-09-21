class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int evenSum = 0;
        
        for(int num : nums){
            
            if(num%2 == 0)
            evenSum+=num;
        }
        
        
        int ansIndx = 0;
        for(int[] arr : queries){
            int val = arr[0];
            int indx = arr[1];
            int numVal = nums[indx];
            
            if(numVal%2 == 0)
                evenSum-=numVal;
            
            numVal+=val;
            nums[indx] = numVal;
            
            if(numVal%2 == 0)
                evenSum+=numVal;  
            
            ans[ansIndx++] = evenSum;
        }
        return ans;
        
    }
}