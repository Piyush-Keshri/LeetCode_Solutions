class Solution {
    public int equalPairs(int[][] grid) {
        
        Map<String,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
             String str ="";
            for(int j=0;j<grid.length;j++)
            {
                
                str+=grid[i][j];
                str+="-";
            }
                map.put(str,map.getOrDefault(str,0)+1);   
        }
        
        
        for(int j=0;j<grid.length;j++){
            String str = "";
            for(int i=0;i<grid.length;i++){
                str+=grid[i][j];   
                str+="-";
            }
           
            if(map.containsKey(str)){
                cnt+=map.get(str);
            }
            
        }
         return cnt;
    }
}