class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for(int i=0;i<s.length()-1;i++){
            int a = getValue(s.charAt(i));
            int b = getValue(s.charAt(i+1));
            
            if(a<b){
                res-=a;
            }
            else{
                res+=a;
            }
        }
        return res+=getValue(s.charAt(s.length()-1));
    }
    
    public int getValue(char ch){
        
        if(ch == 'I') return 1;
        else if(ch == 'V') return 5;
        else if(ch == 'X') return 10;
        else if(ch == 'L') return 50;
        else if(ch == 'C') return 100;
        else if(ch == 'D') return 500;
        else return 1000;
        
    }
    
}