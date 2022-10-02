class Solution {

public int MOD = (int)Math.pow(10,9) + 7;

public int myFunc(int n, int k, int target, int[][] dp){

	if(target==0 && n==0) return 1;

	if(n==0) return 0;

	if(dp[n][target]!=-1) return dp[n][target];

	int ways=0;

	for(int i=1;i<=k;i++){
		if(target>=i) ways=(ways+myFunc(n-1,k,target-i,dp)) % MOD ;
	}

	return dp[n][target]=ways;
}

public int numRollsToTarget(int n, int k, int target) {

	int [][]dp=new int[n+1][target+1];

	for(int i=0;i<=n;i++){
		for(int j=0;j<=target;j++){
			dp[i][j]=-1;
		}
	}

	return myFunc(n,k,target,dp);

}
}