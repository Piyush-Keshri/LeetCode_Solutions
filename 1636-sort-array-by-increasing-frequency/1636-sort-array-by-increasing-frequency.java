class Pair{
    
    int key;
    int freq;
    
    public Pair(int key,int freq){
        this.key = key;
        this.freq = freq;
    }
    
}

class Solution {
    public int[] frequencySort(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            
           if(map.get(a.key) == map.get(b.key)){
               return b.key-a.key;
           }
            return map.get(a.key)-map.get(b.key);
            
        });
        
        
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            
            pq.add(new Pair(it.getKey(),it.getValue()));
            
        }
        
        int[] ans = new int[nums.length];
        int indx = 0;
        while(pq.size() > 0){
            Pair p = pq.poll();
            int key = p.key;
            int freq = p.freq;
            
            while(freq-->0){
                ans[indx] = key;
                indx++;
            }
        }
        return ans;
        
    }
}