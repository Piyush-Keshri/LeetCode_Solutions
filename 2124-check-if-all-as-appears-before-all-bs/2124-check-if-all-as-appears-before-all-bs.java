class Solution {
    public boolean checkString(String s) {

        if(s.length() == 1){
            return true;
        }
        
        int f = s.indexOf("b");
        int l = s.lastIndexOf("a");

       for(int i =l;i>=0;i--){
           if(s.charAt(i) =='b'){
               return false;
           }
       }
        return true;
    }
}