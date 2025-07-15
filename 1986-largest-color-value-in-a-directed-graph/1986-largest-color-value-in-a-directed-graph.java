class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            degree[e[1]]++;
        }

        int[][] dp = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) q.add(i);
        }

        int visited = 0;
        int maxVal = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;

            int colorIdx = colors.charAt(u) - 'a';
            dp[u][colorIdx]++;
            maxVal = Math.max(maxVal, dp[u][colorIdx]);

            for (int v : adj.get(u)) {
                for (int i = 0; i < 26; i++) {
                    dp[v][i] = Math.max(dp[v][i], dp[u][i]);
                }

                degree[v]--;
                if (degree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return visited == n ? maxVal : -1;
    }
}
