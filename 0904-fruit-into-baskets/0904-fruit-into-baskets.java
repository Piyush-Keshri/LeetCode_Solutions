class Solution {
    public int totalFruit(int[] fruits) {
        int ans=0;
        int i=0;
        int j=0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = fruits.length;
        while(j<n){
            
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            
            while(map.size() > 2){
                
                map.put(fruits[i],map.get(fruits[i])-1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
                
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}