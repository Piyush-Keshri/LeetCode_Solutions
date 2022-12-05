class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans= new ArrayList<String>();
        helper(ans,"",n,n);
        return ans;
    }
    
    public void helper(List<String>ans,String s,int left,int right){
        
        if(left>right){
            return;
        }
        
        if(left==0 && right==0){
            ans.add(s);
            return;
        }
        
        if(left>0){
            helper(ans,s+"(",left-1,right);
        }
        if(right>0){
            helper(ans,s+")",left,right-1);
        }
        
    }
    
}