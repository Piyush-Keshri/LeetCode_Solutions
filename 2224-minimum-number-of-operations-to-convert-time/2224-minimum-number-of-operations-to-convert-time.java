class Solution {
    public int convertTime(String current, String correct) {
        
    int currmins = Integer.parseInt(current.substring(0,2))*60+Integer.parseInt(current.substring(3));
    
    int cormins = Integer.parseInt(correct.substring(0,2))*60+Integer.parseInt(correct.substring(3));    
    
        int cnt = 0;
        
        
        while(currmins+60 <=cormins){
            cnt++;
            currmins+=60;
        }
        
          while(currmins+15 <=cormins){
            cnt++;
            currmins+=15;
        }
          while(currmins+5 <=cormins){
            cnt++;
            currmins+=5;
        }
          while(currmins+1 <=cormins){
            cnt++;
            currmins+=1;
        }
        
        return cnt;
    }
}