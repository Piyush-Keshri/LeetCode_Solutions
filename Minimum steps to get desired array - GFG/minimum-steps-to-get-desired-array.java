//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().countMinOperations(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int countMinOperations(int[] arr, int n) {
        int result = 0;
      
        while (true)
        {
            int zero_count = 0;
      
            int i;
            for (i=0; i<n; i++)
            {
                if (arr[i] % 2 == 1)
                    break;
                else if (arr[i] == 0)
                    zero_count++;
            }

            if (zero_count == n)
              return result;
            if (i == n)
            {
                for (int j=0; j<n; j++)
                   arr[j] = arr[j]/2;
                result++;
            }
            for (int j=i; j<n; j++)
            {
               if (arr[j] %2 == 1)
               {
                  arr[j]--;
                  result++;
               }
            }
        }
    }
    
}