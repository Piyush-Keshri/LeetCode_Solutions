class Solution {
    public int reverse(int x) {
        int result =0;
        
        while(x!=0)
        {
            int rem = x%10;
            x =x/10;
            int temp = result*10+rem;
            if(result!=(temp)/10){
                return 0;
            }
            result = temp;
        }
        return result;
    }
}