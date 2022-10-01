class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int one = s.charAt(n - 1) != '0' ? 1 : 0;
        int two = -1;
        for(int i = n - 2; i >= 0; i--){
            int curr = 0;
            if(s.charAt(i) == '0') curr = 0;
            else{
                curr = one;
                if(Character.getNumericValue(s.charAt(i))*10 + Character.getNumericValue(s.charAt(i + 1)) <= 26){
                    if(i != n - 2) curr += two;
                    else curr += 1;      
                }
            }
            two = one;
            one = curr;
        }
        return one;
    }
}