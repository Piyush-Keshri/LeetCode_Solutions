class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        if(n<3){
            return 0;
        }
        int leftMax = heights[0];
        int rightMax = heights[n-1];
        int l = 1;
        int r = n-2;
        
        int trappedWater = 0;
        while(l<=r){
            if(leftMax<rightMax){
                if(heights[l]>leftMax){
                    leftMax = heights[l];
                } else {
                    trappedWater+=(leftMax-heights[l]);
                }
                l++;
            } else {
                if(heights[r]>rightMax){
                    rightMax = heights[r];
                } else {
                    trappedWater+=(rightMax-heights[r]);
                }
                r--;
            }
        }
        
        return trappedWater;
    }
}