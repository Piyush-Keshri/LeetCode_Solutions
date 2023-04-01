class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        double ans = 0.00000;
        int[] merged = new int[n+m];
        
        int i = 0,j=0,k=0;
        
        while(i<n && j<m){
            
            if(nums1[i]<=nums2[j]){
                merged[k] = nums1[i];
                k++;
                i++;
            }
            else if(nums2[j]<nums1[i]){
                merged[k] = nums2[j];
                k++;
                j++;
            }
        }
        
        while(i<n){
           merged[k] = nums1[i];
            i++;
            k++;
        }
        while(j<m){
            merged[k] = nums2[j];
            k++;
            j++;
        }
        
        int l = n+m;
        
        if(l%2 == 1){
            return ans = merged[l/2]; 
        }
        else{
            return ans = (float)(merged[l/2] + merged[(l/2)-1])/2;
        }
    }
}