class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[k];
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);            
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            
            pq.add(entry.getKey());
            if(pq.size() >k){
                pq.poll();
            }
            
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}