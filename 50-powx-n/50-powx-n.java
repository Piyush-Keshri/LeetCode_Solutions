class Solution {
    public double myPow(double x, int n) {
        
        double ans = 1.0;
        long n1 = n;
        
        if(n1<0){
            
            n1 = -1 * n1 ;
        }
        
        while(n1>0){
            
            if(n1%2 == 1){
                
                ans = ans * x;
                n1 = n1-1;
            }
            else{
                x = x*x;
                n1 = n1/2;
            }
        }
        
        if(n<0) ans = (double)(1.0)/(double)(ans);
        return ans;
        
    }
}