class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        
        solve(0,s,ls,res);
        
        return res;
        
    }
    
    public void solve(int indx,String s,List<String>ls,List<List<String>> res){
        
        if(indx == s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=indx;i<s.length();i++){
            
            if(isPalindrome(s,indx,i)){
                ls.add(s.substring(indx,i+1));
                solve(i+1,s,ls,res);
                ls.remove(ls.size()-1);
            }
            
        }
        
    }
    
    public boolean isPalindrome(String s,int st,int end){
        
        while(st<=end){
           if(s.charAt(st++)!= s.charAt(end--)){
               return false;
           }
        }
        return true;
    }
    
}