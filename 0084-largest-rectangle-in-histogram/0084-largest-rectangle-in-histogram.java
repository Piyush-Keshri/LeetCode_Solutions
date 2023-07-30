class Pair{
    
    int ele;
    int indx;
    public Pair(int ele,int indx){
        this.ele = ele;
        this.indx = indx;
    }
    
}

class Solution {
    public int[] nsl(int[] nums,int n){
        
        int[] ans = new int[n];
        Stack<Pair> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            
            if(st.isEmpty()){
                ans[i] = -1;
            }
            
            while(!st.isEmpty() && st.peek().ele >= nums[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i] = -1;
            }
            
            else if(st.peek().ele < nums[i]){
                ans[i] = st.peek().indx;
            }
            st.push(new Pair(nums[i],i));
        }
        
        for(int i=0;i<n;i++){
            ans[i] = i-ans[i];
        }
        return ans;
    }
    
    public int[] nsr(int[] nums,int n){
        
        int[] ans = new int[n];
        Stack<Pair> st = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            
            if(st.isEmpty()){
                ans[i] = n;
            }
            
            while(!st.isEmpty() && st.peek().ele >= nums[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i] = n;
            }
            
            else if(st.peek().ele < nums[i]){
                ans[i] = st.peek().indx;
            }
            st.push(new Pair(nums[i],i));
        }
        
        for(int i=0;i<n;i++){
            ans[i] = ans[i]-i;
        }
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] arr1 = nsl(heights,n);
        int[] arr2 = nsr(heights,n);
        int ans = 0;
        for(int i=0;i<n;i++){
            int area = heights[i] * (arr2[i]+arr1[i]-1);
            ans = Math.max(ans,area);
        }
        return ans;
    }
}