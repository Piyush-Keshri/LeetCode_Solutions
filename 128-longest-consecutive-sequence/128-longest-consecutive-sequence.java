public class Solution {
    public int longestConsecutive(int[] num) {
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i < num.length;i++){
            // if there is no duplicates, these two lines can be commented
            if(map.containsKey(num[i])) continue;
            map.put(num[i],1);
            
            int end = num[i];
            int begin = num[i];
            if(map.containsKey(num[i]+1))
                end = num[i] + map.get(num[i]+1);
            if(map.containsKey(num[i]-1))
                begin = num[i] - map.get(num[i]-1);
            longest = Math.max(longest, end-begin+1);
            map.put(end, end-begin+1);
            map.put(begin, end-begin+1);
        }
        return longest;
    }
}
