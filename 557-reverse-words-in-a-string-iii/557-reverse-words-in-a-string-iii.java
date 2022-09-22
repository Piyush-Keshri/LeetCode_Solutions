class Solution {
    public String reverseWords(String s) {
        
        int lastSpaceIndex = -1;
        char[] ch = s.toCharArray();
        
        int len = s.length();
        
        for(int i=0;i<=len;i++)
        {
            
            if(i == len || ch[i] == ' '){
                
                int startIndex = lastSpaceIndex+1;
                int endIndex = i-1;
                
                while(startIndex<=endIndex){
                    
                    char temp = ch[startIndex];
                    ch[startIndex] = ch[endIndex];
                    ch[endIndex] = temp;
                    
                    startIndex++;
                    endIndex--;
                    
                }
                
                lastSpaceIndex = i;
            }
            
        }
        
        return new String(ch);
    }
}