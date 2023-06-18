class Solution {
    public int distanceTraveled(int mt, int at) {

    int ans = 0;
        
        while(mt>0){
            
            if(mt >= 5){
                ans+=5;
                mt-=5;

                if(at >= 1){
                    at--;
                    mt++;
                }
                
            }
            else{
                ans+=mt;
                mt = 0;
            }
            
        }
    return ans *10;
        
    }
}