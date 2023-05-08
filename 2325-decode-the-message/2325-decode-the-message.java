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
        
        StringBuilder decode = new StringBuilder();
        
        for(char x:message.toCharArray()){
            if(x == ' '){
                decode.append(" ");
            }
            else if(subTable.containsKey(x)){
                decode.append(subTable.get(x));
            }
            else{
                decode.append(x);
            }
        }
        return decode.toString();
    }
}