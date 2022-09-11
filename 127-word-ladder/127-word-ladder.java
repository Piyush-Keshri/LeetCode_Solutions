class Pair{
    
    String first;
    int second;
    
    public Pair(String first,int second){
        this.first = first;
        this.second = second;
    }
    
}

class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String> st = new HashSet<>();
        int length = wordList.size();
        for(int i=0;i<length;i++){
            st.add(wordList.get(i));
        }
        
        st.remove(startWord);
        
        while(!q.isEmpty()){
            
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            
            if(word.equals(targetWord) == true){
                return steps;
            }
            
            for(int i =0 ;i<word.length();i++){
                
                for(char ch= 'a';ch<= 'z';ch++){
                    
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                   String replacedWord = new String(replacedCharArray);
                    
//                     If replacedword exists in set
                    
                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                        
                    }
                    
                }
                
            }
            
        }
        
        return 0;
    }
}