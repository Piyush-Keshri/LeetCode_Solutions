class Solution {

    int result = 0;
    int[] digits;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        digits = new int[10];
        
        dfs(root);
        return result;
        
    }
    
    public void dfs(TreeNode root){
        
        if(root == null){
            
            return;
        }
        
        digits[root.val]++;
        
        if(root.left == null && root.right == null){
            
            if(isPalindrome()){
                
                result++;
            }
        }
            
        else{
            dfs(root.left);
            dfs(root.right);
            }
        digits[root.val]--;
    }
    
    public boolean isPalindrome(){
        
        int odd = 0;
        
        for(int i=1 ;i<10;i++){
            
            if(digits[i]%2 != 0){
                odd++;
            }
            
        }
        if(odd > 1){
            return false;
        }
        return true;
    }
    
}