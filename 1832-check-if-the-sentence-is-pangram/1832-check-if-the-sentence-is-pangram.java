class Solution {
    public boolean checkIfPangram(String sentence) {
        
       for(char lt= 'a';lt<='z';lt++){
           
          int n = sentence.indexOf(lt);
           if(n == -1)
               return false;
           
       }
        return true;
    }
}