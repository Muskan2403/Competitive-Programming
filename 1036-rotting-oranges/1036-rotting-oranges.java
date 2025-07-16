class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }

        int []ax = {0, 0, 1, -1};
        int []ay = {1, -1, 0, 0};

        int ans =0;

        while(!q.isEmpty()){
            int size =q.size();
            int temp =0;
            while(size>0){
                Pair rv = q.poll();
                int x = rv.x;
                int y = rv.y;

                for(int i=0;i<4;i++){
                    int newx = x+ax[i];
                    int newy = y+ay[i];

                    if(newx>=0 && newx<n && newy>=0 && newy<m && 
                    grid[newx][newy]==1){
                        grid[newx][newy] =2;
                        q.add(new Pair(newx, newy));
                        temp =1;
                    }
                }
                size--;
            }
            ans+= temp;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return ans;
    }

    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}