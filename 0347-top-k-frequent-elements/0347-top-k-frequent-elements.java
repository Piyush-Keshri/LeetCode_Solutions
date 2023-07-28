class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            
            pq.add(it.getKey());
            
            if(pq.size() > k){
                pq.remove();
            }
            
        }
        int[] ans = new int[k];
        
        for(int i=0;i<k;i++){
            
            ans[i] = pq.poll();
            
        }
        
        return ans;
    }
}