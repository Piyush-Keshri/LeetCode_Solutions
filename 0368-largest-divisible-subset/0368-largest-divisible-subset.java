class Solution {
    static List<Integer> res;
    static int dp[];
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        dp=new int[nums.length+1];
        List<Integer> ans=new ArrayList<>();
        res=new ArrayList<>();
        Arrays.fill(dp,-1);
        solve(nums,0,1,ans);
        return res;
    }
    //we have two condtions for every element weather to tkae the eleemnt or not,
    //takini=g or adding into my list will happen only if the no. is divisible
    
    static void solve(int nums[], int i, int prev,List<Integer> ans){
        
        if(i>=nums.length) {
            if(ans.size()>res.size()){
                res.clear();
                res.addAll(ans);
            }
            return;
        }
        // taking condition.....
        
        if(ans.size()>dp[i] && (nums[i]%prev==0 || prev%nums[i]==0)){
            dp[i]=ans.size();
            ans.add(nums[i]);
            solve(nums,i+1,nums[i],ans);
            ans.remove(ans.size()-1);
        }
        //not taking condition.....
        
        solve(nums,i+1,prev,ans);  
    }
}