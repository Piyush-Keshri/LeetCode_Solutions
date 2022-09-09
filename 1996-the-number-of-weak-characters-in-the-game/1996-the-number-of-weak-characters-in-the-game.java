class Solution {
    public int numberOfWeakCharacters(int[][] pro) {
        int res = 0;
        // Sorting by above explained approach
        Arrays.sort(pro, (a,b) -> (a[0]!=b[0]) ? b[0]-a[0] : a[1]-b[1]);
        
		// Compare the defense of character with previous characters' defense 
		// and count weak characters accordingly 
        int max = Integer.MIN_VALUE;
        for(int[] e : pro){
            if(e[1] < max) res++;
            max = Math.max(max,e[1]);
        }
        
        return res;
    }
}