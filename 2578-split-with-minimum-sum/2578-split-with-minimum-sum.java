class Solution {
    public int splitNum(int num) {
        
        String st = num + "";
        char[] ans = st.toCharArray();
    
        Arrays.sort(ans);
        
        String x1 = "";
        String x2 = "";
        
        for(int i=0;i<ans.length;i++){
            
            if(i%2 == 0){
                x1+=ans[i];
            }
            else{
                x2+=ans[i];
            }
        }
        return Integer.parseInt(x1)+Integer.parseInt(x2);
    }
}