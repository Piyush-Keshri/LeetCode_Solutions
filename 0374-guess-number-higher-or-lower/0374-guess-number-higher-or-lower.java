public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
      int i = 1;
      int j = n;  
        while(i<j){
            
            int mid = i+(j-i)/2;
            
            if(guess(mid) == n){
                return mid;
            }
           else if(guess(mid) == 1){
                i = mid+1;
            }
            else
                j = mid;
            
        }
        return i;
    }
}