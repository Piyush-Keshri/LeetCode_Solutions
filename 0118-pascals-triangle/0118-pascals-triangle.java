class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            res.add(getRow(i));
        }
        return res;
    }
    
    public List<Integer> getRow(int n) {
        
    List<Integer> res = new ArrayList<>();
        
     long ans = 1  ;
        
        for(int i=0;i<=n;i++){
            res.add((int)ans);
            ans = ans*(n-i)/(i+1);   
        }
        return res;
    }
    
}