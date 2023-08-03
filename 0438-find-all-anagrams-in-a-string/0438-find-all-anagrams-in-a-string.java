class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> m = new HashMap<>();
        
        //put all elements of pttrn p in map
        for(int i=0;i<p.length();i++){
            if(m.containsKey(p.charAt(i)))
                m.put(p.charAt(i),m.get(p.charAt(i))+1);
            else
                m.put(p.charAt(i),1);
        }
        int count = m.size();
        int i=0,j=0;
        while(j<s.length()){
            //calculations
            if(m.containsKey(s.charAt(j))){
                m.put(s.charAt(j),m.get(s.charAt(j))-1);
                if(m.get(s.charAt(j))==0){
                    count--;
                }
            }
            //window size less than k
            if(j-i+1<p.length())
                j++;
            
            else if(j-i+1==p.length()){
                //ans calculate
                if(count==0){
                    ans.add(i);
                    //remove ans of i before sliding
                }
                if(m.containsKey(s.charAt(i))){
                    m.put(s.charAt(i),m.get(s.charAt(i))+1);
                    if(m.get(s.charAt(i))==1)
                        count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}