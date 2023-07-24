class Solution {
    public boolean judgeSquareSum(int c) {
         
        long st = 0;
        long end = (long)Math.sqrt(c);
        
        while(st<=end){
            
            long x = st*st;
            long y = end*end;
            
            if(x+y == c){
                return true;
            }
            else if(x+y < c){
                st++;
            }
            else{
                end--;
            }
            
        }
        return false;
    }
}