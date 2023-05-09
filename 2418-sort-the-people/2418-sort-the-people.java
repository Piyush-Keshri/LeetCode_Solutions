class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<heights.length;i++){
            map.put(heights[i],i);
        }
        
        Arrays.sort(heights);
        String[] ans = new String[names.length];
        int k =0;
        for(int i= heights.length-1;i>=0;i--){
            
           ans[k] = names[map.get(heights[i])];
            k++;
        }
        return ans;
        
    }
}