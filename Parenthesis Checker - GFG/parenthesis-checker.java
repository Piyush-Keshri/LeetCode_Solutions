//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        
        Stack<Character> st = new Stack<>();
        
        for(char s: x.toCharArray()){
            
            if(s == '('){
                st.push(')');
            }
            else if(s == '['){
                st.push(']');
            }
            else if(s == '{'){
                st.push('}');
            }
            else if(st.isEmpty() || st.pop() != s){
                return false;
            }
        }
        return st.isEmpty();
    }
}
