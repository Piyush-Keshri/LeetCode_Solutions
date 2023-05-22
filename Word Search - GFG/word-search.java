//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] == word.charAt(0) && solve(0,i,j,word,board)){
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public boolean solve(int start,int r,int c,String word,char[][] board){
        
        if(word.length() <= start){
            return true;
        }
        
        // Check validity
        
        if(r<0 || c<0 || r>board.length-1 || c>board[0].length-1 || board[r][c] == '0' || word.charAt(start)!=board[r][c]){
            return false;
        }
        
        char temp = board[r][c];
        
        board[r][c] = '0';
        
        if(solve(start+1,r,c+1,word,board)
        ||solve(start+1,r,c-1,word,board)
        ||solve(start+1,r+1,c,word,board)
        ||solve(start+1,r-1,c,word,board)){
            return true;
        }
        
        board[r][c] = temp;
        
        return false;
        
    }
    
}