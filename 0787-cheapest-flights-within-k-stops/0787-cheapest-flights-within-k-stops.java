// Djikstra's Algorithms
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int m=flights.length;
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        int[] dist=new int[n];
        Arrays.fill(dist,(int)1e9);
        
        Queue<Tuple> q=new LinkedList<>();
        dist[src]=0;
        
        q.add(new Tuple(0,src,0));
        
        while(!q.isEmpty())
        {
            Tuple it=q.remove();
            int stop=it.first;
            int node=it.second;
            int cost=it.third;
            
            if(stop>k)
            {
                continue;
            }
            
            for(Pair iter:adj.get(node))
            {
                int adjnode=iter.first;
                int edw=iter.second;
                
                if(cost+edw<dist[adjnode])
                {
                    dist[adjnode]=cost+edw;
                    q.add(new Tuple(stop+1,adjnode,cost+edw));
                }
            }
            
        }
        
        if(dist[dst]==(int)1e9)
        {
            return -1;
        }
        return dist[dst];
    }
}

class Pair
{
    int first;
    int second;
    
    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}

class Tuple
{
    int first;
    int second;
    int third;
    
    public Tuple(int first, int second, int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}