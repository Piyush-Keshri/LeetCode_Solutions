class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int travel = 0;
        while(mainTank > 0){
            travel++;
            mainTank--;
            if(travel != 0 && travel % 5 == 0 && additionalTank-- > 0)  mainTank++;
        }
        return travel * 10;
    }
}