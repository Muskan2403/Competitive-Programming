class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.diff-b.diff);

        int E[][] = new int[n][m];
        for (int[] row : E) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int ax[] = {0,0,-1,1};
        int ay[] = {-1,1,0,0};

        q.add(new Pair(0,0,0));
        E[0][0] =0;

        while(!q.isEmpty()){
        Pair rv = q.poll();
        int x = rv.x;
        int y = rv.y;
        int diff = rv.diff;

            if (x == n - 1 && y == m - 1) return diff;

            for(int i=0;i<4;i++){
                int newx = x+ax[i];
                int newy = y+ay[i];

                if(newx>=0 && newx<n && newy>=0 && newy<m){
                int currentDiff=Math.abs(heights[x][y]-heights[newx][newy]);
                    int maxEffort = Math.max(diff, currentDiff);

                    if (maxEffort < E[newx][newy]) {
                        E[newx][newy] = maxEffort;
                        q.add(new Pair(maxEffort, newx, newy));
                    }
                }
            }
        }

        return 0;


    }

    class Pair{
        int x;
        int y;
        int diff;

        Pair(int diff, int x, int y){
            this.diff = diff;
            this.x = x;
            this.y =y;
        }
    }
}