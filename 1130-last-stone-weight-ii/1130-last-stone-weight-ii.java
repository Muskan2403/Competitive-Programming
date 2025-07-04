class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;
        int total = 0;
        for(int num : arr){
            total += num;
        }

        boolean[][] dp = new boolean[n+1][total+1];

        for(int i = 0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=total;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int minD = Integer.MAX_VALUE;
        for(int s1 = 0;s1<=total/2;s1++){
            if(dp[n][s1]){
                int s2 = total-s1;
                minD = Math.min(minD,Math.abs(s2-s1));
            }
        }

        return minD;
    }
}