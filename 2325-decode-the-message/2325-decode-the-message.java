class Solution {
    public String decodeMessage(String key, String message) {
        
        HashMap<Character,Character> subTable = new HashMap<>();
        
        char alpha = 'a';
        
        for(int i=0;i<key.length();i++){
            
            char charKey = key.charAt(i);
            if(charKey == ' '){
                continue;
            }
            if(!subTable.containsKey(charKey)){
                subTable.put(charKey,alpha++);
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(char x: message.toCharArray()){
            
            if(x == ' '){
                sb.append(' ');
            }
            
            else if(subTable.containsKey(x)){
                sb.append(subTable.get(x));
            }
            else{
                sb.append(x);
            }
            
        }
        return sb.toString();
        
    }
}