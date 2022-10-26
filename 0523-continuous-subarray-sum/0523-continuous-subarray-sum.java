class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 0);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(!hm.containsKey(sum % k)){   // if map does not contains that remainder then it means including this index we haven't found any subarray which can give remainder 0 so, we put that remainder on that index
                hm.put(sum % k, i + 1);
            }else if(hm.get(sum % k) < i){    // if we found same remainder before this index then it means we get 0 remainder and then we will check  (sum % k) index should not come out just before it because subarray size must be atleast 2.
                return true;
            }
        }
        return false;
        
    }
}