class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        int len = changed.length;
        if(len%2 != 0){
            return new int[0];
        }
//         Sort the Array
        Arrays.sort(changed);
        
//         Store the Elements & Frequencies of Elements in Map
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer it : changed){
            
            map.put(it,map.getOrDefault(it,0)+1);
        }
        
        int[] res = new int[len/2]; 
        int indx = 0;
        
        for(int i = 0;i<len;i++){
            
            int ele = changed[i];
            
            if(map.containsKey(ele)){
                
                if(map.containsKey(ele*2)){
                    
                    res[indx++] = ele;
                
//                 Reduce frequency of ele and 2*ele
                map.put(ele,map.get(ele)-1);
                map.put(2*ele,map.get(ele*2)-1);
                
//                 if frequency of any key becomes <=0 remove it from map
                if(map.get(ele)<=0) map.remove(ele);
                if(map.containsKey(ele*2) && map.get(ele*2)<=0) map.remove(ele*2);
            }
                else return new int[0];
        }
            
        }
        return res;
    }
}