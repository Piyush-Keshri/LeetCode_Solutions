class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls= new ArrayList<>();
        generateSubs(0,nums,ls,res);
        return res;
    }
    
    public void generateSubs(int indx,int[] nums,List<Integer>ls,List<List<Integer>> res){
        
        if(indx == nums.length){
            res.add(new ArrayList<Integer>(ls));
            return;
        }
        
        ls.add(nums[indx]);
        generateSubs(indx+1,nums,ls,res);
        ls.remove(ls.size()-1);
        generateSubs(indx+1,nums,ls,res);
    }
    
}