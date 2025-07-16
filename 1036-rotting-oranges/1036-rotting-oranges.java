class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0;j<grid[0].length; j++) {
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        if(fresh == 0) return 0;
        int minutes = 0;
        while(!q.isEmpty()) {

            int size = q.size();

            for(int i=0; i<size; i++) {
                int[] point = q.poll();
                int x = point[0];
                int y = point[1];
                if(x + 1 < grid.length && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    q.offer(new int[]{x+1, y});
                    fresh--;
                }

                if(x - 1 >= 0 && grid[x-1][y] == 1) {
                    grid[x - 1][y] = 2;
                    q.offer(new int[]{x-1, y});
                    fresh--;
                }

                if(y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    q.offer(new int[]{x, y+1});
                    fresh--;
                }

                if(y - 1 >= 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    q.offer(new int[]{x, y-1});
                    fresh--;
                }
            }
            minutes++;
        }

        return fresh > 0 ? -1 : minutes - 1;
    }

}