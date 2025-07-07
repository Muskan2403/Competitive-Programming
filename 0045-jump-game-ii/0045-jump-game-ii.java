class Solution {
    public int jump(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        return helper(arr, n, dp, 0);
    }

    // private static int helper(int[] arr,int idx){
    //     int n = arr.length;
    //     if(idx>=n || idx == n-1) return 0;

    //     for(int i = 1;i<=arr[idx];i++){
    //         n = Math.min(n, 1+helper(arr,idx+i));
    //     }
    //     return n;
    // }
    private static int helper(int[] arr, int n, int[] dp, int i){
        if(i==n-1) return 0;
        if(i >=n) return Integer.MAX_VALUE;
        if(dp[i] != 0){
            return dp[i];
        }
        int mini = Integer.MAX_VALUE;
        int jump = arr[i];

        for(int j = 1;j<=jump;j++){
            int step = i+j;
            int ans = helper(arr,n,dp,step);
        
            if(ans!= Integer.MAX_VALUE){
                mini = Math.min(mini, 1+ ans);
            }
        }
        return dp[i] = mini;

    }
}
