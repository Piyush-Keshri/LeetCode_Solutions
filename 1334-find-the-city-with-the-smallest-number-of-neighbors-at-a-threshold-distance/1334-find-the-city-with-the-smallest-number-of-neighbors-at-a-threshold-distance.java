class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int [][] dist = new int[n][n];
        
        for(int i = 0;i<n;i++){            
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int m = edges.length;
        for(int i =0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
//         Distance to self Nodes are 0.
        for(int i = 0;i<n;i++){
            dist[i][i] = 0;
        }
        
        
//         Floyd-Warshalls Algorithm
        
        for(int k=0;k<n;k++){
            for(int i =0 ;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
                
            }
            
        }
        
//         Find the no. of citites that a node can travel within threshold distance;
        
        int cntCity = n;
        int cityNo = -1;
        
        for(int city = 0 ; city<n ;city++){
            
            int cnt = 0;
            for(int adjCity = 0; adjCity<n ;adjCity++){
                
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
                
            }
            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
            
        }
        return cityNo;
        
    }
}