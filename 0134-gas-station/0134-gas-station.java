class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totgas = 0;
        int totcost = 0;
            
        for(int i=0;i<gas.length;i++){
            
            totgas += gas[i];
            totcost += cost[i];
        }
        
        if(totgas<totcost){
            return -1;
        }
        
        int remgas = 0;
        int start = 0;
        
        for(int i=0;i<gas.length;i++){
            remgas += gas[i]-cost[i];
        
            if(remgas<0){
                start = i+1;
                remgas =0;
            }
        
        }
        return start;
    }
}