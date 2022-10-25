class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            
      StringBuilder sb1 = new StringBuilder();
      StringBuilder sb2 = new StringBuilder();  
        
        for(String st : word1){
            sb1.append(st);
        }
        for(String st : word2){
            sb2.append(st);
        }
        
       return sb1.toString().equals(sb2.toString());
        
    }
}