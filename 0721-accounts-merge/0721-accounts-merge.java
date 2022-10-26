class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        
        for(int i = 0;i<n;i++){
            
            parent.add(i);
            size.add(1);
            
        }
        
    }
    
    public int findUParent(int node){
        
        if(node == parent.get(node)){
            return node;
        }
        int up = findUParent(parent.get(node));
        parent.set(node,up);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
        
        int ultp_u = findUParent(u);
        int ultp_v = findUParent(v);
        
        if(ultp_u == ultp_v){
            return;
        }
        
        if(size.get(ultp_u) < size.get(ultp_v)){
            
            parent.set(ultp_u,ultp_v);
            size.set(ultp_v,size.get(ultp_u)+size.get(ultp_v));
        }
        else{
            parent.set(ultp_v,ultp_u);
            size.set(ultp_u,size.get(ultp_u)+size.get(ultp_v));
        }
        
    }
    
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> mapMailNode = new HashMap<String,Integer>(); 
        
        for(int i = 0;i<n;i++){
           for(int j=1;j<accounts.get(i).size();j++){
               
               String mail = accounts.get(i).get(j);
               if(mapMailNode.containsKey(mail) == false){
                   mapMailNode.put(mail,i);
               }
               else{
                   ds.unionBySize(i,mapMailNode.get(mail));
               }  
           } 
        }
        
        ArrayList<String>[] mergeMail = new ArrayList[n];
        
        for(int i =0;i<n;i++){
        mergeMail[i] = new ArrayList<String>();        
        }
        
        for(Map.Entry<String,Integer> et : mapMailNode.entrySet()){
            
            String mail = et.getKey();
            int node = ds.findUParent(et.getValue());
            mergeMail[node].add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
        
    }
}