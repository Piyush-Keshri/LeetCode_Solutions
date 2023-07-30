//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


class Pair{
    int ele;
    int indx;

    public Pair(int ele,int indx){
        this.ele = ele;
        this.indx = indx;
    }
}
/*Complete the function given below*/
class Solution {
    
    public int[] nsl(int[] nums,int n){
        
        Stack<Pair> st = new Stack<>();
        int[] ans = new int[n];
        
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
        
        Stack<Pair> st = new Stack<>();
        int[] ans = new int[n];
        
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
    
    public int mha(int[] nums,int n){
    
    int[] nums1 = nsl(nums,n);
    int[] nums2 = nsr(nums,n);
    int ans = 0;
    for(int i=0;i<n;i++){
        
        int area = nums[i] * (nums1[i]+nums2[i] -1);
        ans = Math.max(ans,area);
    }
    return ans;
    }
    
    public int maxArea(int M[][], int n, int m) {
        
        int[][] mat = new int[n][m];
        
        for(int i=0;i<m;i++){
            mat[0][i] = M[0][i];
        }
        
        for(int i=1;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(M[i][j] != 0){
                    
                    mat[i][j] = M[i][j] + mat[i-1][j];
                    
                }
                else{
                    mat[i][j] = 0;
                }
                // System.out.print(mat[i][j] + " ");
            }
            // System.out.println();
        }
        int ans = 0;
        for(int[] row : mat){
            
            int area = mha(row,row.length);
            ans = Math.max(area,ans);
        }
        
        return ans;
    }
    
  
    
}