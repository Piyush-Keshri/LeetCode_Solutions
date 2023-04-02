class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
    
//         Enter the value of each alphabet from 1 to 26.
       int[] arr = new int[26];
        for(int i=0;i<26;i++){
            arr[i] = i+1;
        }
        
//      Update the value of alphabets as per the question from vals array.   
        for(int i = 0;i<chars.length();i++){
            int curr = chars.charAt(i)-'a';
            arr[curr] = vals[i]; 
        }
        
//      Create a array of values of the given 's' String.  
        int[] subarr = new int[s.length()];
        
        for(int i =0;i<s.length();i++){
            int curr = s.charAt(i) -'a';
            subarr[i] = arr[curr];
        }
        
//      Applying Kadanes Algorithm to find maximum subarray sum.
        
        int total = 0;
       int maxi = subarr[0];
        
        for(int i=0;i<subarr.length;i++){
            total+=subarr[i];
            
            if(total>maxi){
                maxi = total;
            }
            if(total<0){
                total = 0;
            }
        }
        
//      if maxi <0 return 0 .   
        return maxi<0?0:maxi;
    }
}