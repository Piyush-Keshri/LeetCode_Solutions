class Solution {
    public String frequencySort(String s) {
       
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char x : s.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>((e1,e2) -> e2.getValue()-e1.getValue());
        
        pq.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        
        while(!pq.isEmpty()){
            
            Map.Entry<Character,Integer> ele = pq.poll();
            
            int i = ele.getValue();
            while(i>0){
                res.append(ele.getKey());
                i--;
            }
             
        }
        return res.toString();
    }
}