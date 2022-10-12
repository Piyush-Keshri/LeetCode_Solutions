class Solution {
    public double largestTriangleArea(int[][] points) {
        
        double max = 0.0;
        
        for(int i = 0;i<points.length-2;i++){
            for(int j = 0;j<points.length-1;j++){
                for(int k = 0;k<points.length;k++){
                    
                    max = Math.max(max,areaCalc(points[i],points[j],points[k]));
                    
                }
            }
            
        }
        return max;
    }
    
    public double areaCalc(int[] a,int[] b,int[] c){
        
        return Math.abs(a[0]*(b[1] - c[1]) + b[0]*(c[1]-a[1]) + c[0]*(a[1]-b[1])) / 2.0;
        
    }
    
}