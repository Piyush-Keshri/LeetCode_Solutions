//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        
        ArrayList<int[]> res = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            res.add(new int[]{start[i],end[i]});
        }
        
        Collections.sort(res,(a,b)->(a[1]-b[1]));
        
        int ans =1,prev =0;
        
        for(int i=1;i<n;i++){
            
            if(res.get(i)[0] > res.get(prev)[1]){
                
                prev = i;
                ans++;
                
            }
            
        }
        return ans;
        
    }
}
