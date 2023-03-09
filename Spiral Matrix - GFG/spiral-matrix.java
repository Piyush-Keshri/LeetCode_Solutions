//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    
	    List<Integer> ls = new ArrayList<>();
	    
	    int minrow = 0;
	    int mincol = 0;
	    int maxrow = n-1;
	    int maxcol = m-1;
	    
	    while(minrow<=maxrow && mincol<=maxcol){
	        
	       // Right Traversal 
	       
	       for(int i =mincol;i<=maxcol;i++){
	           ls.add(a[minrow][i]);
	       }
	       minrow++;
	       
	       //Down Traversal
	       
	       for(int i =minrow;i<=maxrow;i++){
	           ls.add(a[i][maxcol]);
	       }
	       maxcol--;
	       
	       //Left Traversal
	       for(int i =maxcol;i>=mincol;i--){
	           ls.add(a[maxrow][i]);
	       }
	       maxrow--;
	       //Up traversal
	       for(int i =maxrow;i>=minrow;i--){
	           ls.add(a[i][mincol]);
	       }
	       mincol++;
	        
	    }
	    
	    return ls.get(k-1);
	}
	
}