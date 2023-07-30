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

    public int mah(int[] arr){
        
        int n = arr.length; 
        
        int[] arr1 = nsl(arr,n);
        int[] arr2 = nsr(arr,n);
        int ans = 0;
        for(int i=0;i<n;i++){
            
            int area = arr[i] * (arr1[i] + arr2[i] -1);
            ans = Math.max(ans,area);
        }
        return ans;
    }
    
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] mat = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = matrix[i][j] - '0';
                // System.out.print(mat[i][j] + " ");
            }
            // System.out.println();
        }
        
         for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
               if(mat[i][j] != 0){
                    mat[i][j] = mat[i][j] + mat[i-1][j];
               }
                // System.out.print(mat[i][j] + " ");
            }
            // System.out.println();
        }
        
        int ans = 0;
        
        for(int[] row:mat){
            
            ans = Math.max(ans,mah(row));
            
        }
        return ans;
    }
}