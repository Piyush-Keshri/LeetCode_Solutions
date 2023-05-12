class Pair{
    int val;
    int cnt;
    
    public Pair(int val,int cnt){
        this.val = val;
        this.cnt = cnt;
    }
    
}

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int x : nums){
            
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.cnt == b.cnt?b.val-a.val:a.cnt-b.cnt));
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            
           Pair node = new Pair(entry.getKey(),entry.getValue());
            pq.add(node);
        }
        
        
        int[] ans = new int[nums.length];
        int k=0;
        while(!pq.isEmpty()){
            
            Pair node = pq.remove();
            int val = node.val;
            int cnt = node.cnt;
            
            while(cnt-- > 0){
                ans[k] = val;
                k++;
            }
            
        }
        return ans;
    }
}