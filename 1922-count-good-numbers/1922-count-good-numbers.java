class Solution {
    int mod = 1_000_000_007;
    public long calculateXPowerY(long a,long b){
        if(b==0){
            return 1;
        }
        if(b==1){
            return a;
        }
        long temp = calculateXPowerY(a,b/2)%mod;
        if(b%2==0){
            temp = temp * temp;
        } else{
            temp = (( a) * (temp * temp) );
        }
        return temp;
    }
    public int countGoodNumbers(long n) {
        
        long oddCount =  n / 2 ;
        long evenCount = n - oddCount;
        
        long evenPos = calculateXPowerY(5,evenCount)%mod;
        long oddPos = calculateXPowerY(4,oddCount)%mod;
        
        int ans = (int)( (evenPos * oddPos)%mod);
        return ans;
        
    }
}