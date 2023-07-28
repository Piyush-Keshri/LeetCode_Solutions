class Pair{
    
    int diff;
    int ele;
    
    public Pair(int diff,int ele){
        this.diff = diff;
        this.ele = ele;
    }
    
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ls = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
        new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                // if both the keys are same then compare on the bases of their values
                if((b.diff - a.diff) == 0)
                    return b.ele - a.ele;
                return b.diff - a.diff;
            }
    });
        
        for(int i:arr){
            
            int diff = Math.abs(i-x);
            int ele = i;
            
            pq.add(new Pair(diff,ele));
            
            if(pq.size() > k){
                pq.remove();
            }
            
        }
        
        while(pq.size() > 0){
            Pair pa = pq.poll();
            ls.add(pa.ele);
        }
        Collections.sort(ls);
        return ls;
    }
}