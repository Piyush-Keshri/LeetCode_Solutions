class Pair{
    String first;
    int second;
    
    public Pair(String first,int second){
        this.first = first;
        this.second = second;
    }
    
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(beginWord,1));
        
        Set<String> st = new HashSet<String>();
        for(int i =0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        
        while(!q.isEmpty()){
            
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            
            if(word.contains(endWord) == true) return steps;
            
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    
                    char[] replacedChar = word.toCharArray();
                    replacedChar[i] = ch;
                    String replacedWord = new String(replacedChar);
                    
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