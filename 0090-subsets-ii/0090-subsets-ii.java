class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ls = new ArrayList<>(); 
        Arrays.sort(nums);
        generateSubs(0,nums,set,ls);
    
        return new ArrayList<>(set);
        
    }
        public void generateSubs(int indx,int[]nums,Set<List<Integer>> set,List<Integer>ls){
            
            if(indx == nums.length){
                set.add(new ArrayList<>(ls));
                return;
            }
            
            ls.add(nums[indx]);
            generateSubs(indx+1,nums,set,ls);
            ls.remove(ls.size()-1);
            generateSubs(indx+1,nums,set,ls);
            
        }
        
    }