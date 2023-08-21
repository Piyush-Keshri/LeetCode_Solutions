//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int k = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.minDiff(root,k));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
*/

class Solution
{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff(Node  root, int K) 
    { 
        
        int f = floor(root,K);
        int c = ceil(root,K);
        
        // System.out.print(f + "  "+c);
        
        int diff = Math.min(Math.abs(K-f),Math.abs(c-K));
        
        return diff;
        
    } 
    
    public static int floor(Node root, int x) {
        
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        int floor1 = Integer.MAX_VALUE;
        
        while(root != null){
            
            if(root.data == x){
                floor1 = x;
                return floor1;
            }
            
            else if(root.data > x){
                root = root.left;
            }
            
            else{
                floor1 = root.data;
                root = root.right;
            }
            
        }
        
        return floor1;
    }
    
    public static int ceil(Node root, int key) {
        if (root == null) return Integer.MAX_VALUE;
        // Code here
        int ceil = Integer.MAX_VALUE;
        while(root != null){
            
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            
            else if(root.data < key){
                root = root.right;
            }
            
            else{
                
                ceil = root.data;
                root = root.left;
                
            }
        }
        
        return ceil;
    }
    
}

