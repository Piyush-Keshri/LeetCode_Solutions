class Pair{
    
    char ch;
    int val;
    
    public Pair(char ch,int val){
        this.ch = ch;
        this.val = val;
    }
    
}

class Solution {
    public String frequencySort(String s) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        HashMap<Character,Integer> map = new HashMap<>();
        
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            int cnt = map.getOrDefault(arr[i],0);
            map.put(arr[i],cnt+1);
        }
        
//         HashMap to PriorityQueue
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            
           Pair node = new Pair(entry.getKey(),entry.getValue());
            pq.add(node);
        }
        
//         PriorityQueue to StringBuilder
        
        StringBuilder sb = new StringBuilder();
            
        while(!pq.isEmpty()){
            
            Pair node = pq.remove();
            char ch = node.ch;
            int cnt = node.val;
            
            while(cnt -- >0){
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
    }
}








