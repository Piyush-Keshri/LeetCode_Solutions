class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int len = searchWord.length();
        
        for(int i=0;i<words.length;i++){
            String str ="";
            if(words[i].length()>=len){
               str = words[i].substring(0,len);
            }
            
            if(str.equals(searchWord)){
                return i+1;
            }
        }
        return -1;
        
    }
}