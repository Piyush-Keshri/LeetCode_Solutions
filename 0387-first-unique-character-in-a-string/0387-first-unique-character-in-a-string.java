class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char x:s.toCharArray()){
            
            if(map.containsKey(x)){
                int cnt = map.get(x);
                map.put(x,cnt+1);
            }
            else{
                map.put(x,1);
            }
        }
        
        for(int i=0;i<s.length();i++){
            
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
            
        }
        return -1;
    }
}