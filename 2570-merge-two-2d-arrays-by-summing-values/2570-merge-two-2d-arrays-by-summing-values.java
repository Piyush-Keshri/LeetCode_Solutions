class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i][0],nums1[i][1]);
        }
        
        for(int i=0;i<nums2.length;i++){
          
            if(!map.containsKey(nums2[i][0])){
                map.put(nums2[i][0],nums2[i][1]); 
            }
            else{
                map.put(nums2[i][0],(map.get(nums2[i][0]) + nums2[i][1]));
            }
            
        }
        int n = map.size();
        int[][] ans = new int[n][2];
        int k = 0;
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            
            ans[k][0] = entry.getKey();
            ans[k][1] = entry.getValue();
            k++;
        }
        Arrays.sort(ans, (a,b) -> a[0]-b[0]);
        return ans;
    }
}