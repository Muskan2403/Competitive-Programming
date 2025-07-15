class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int from = pair[0];
            int to = pair[1];
            adj.get(to).add(from);
        }

        int[] degree = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int v : adj.get(i)){
                degree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<numCourses;i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }

        int[] topo = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int u = q.poll();
            topo[idx++] = u;

            for(int v : adj.get(u)){
                degree[v]--;
                if(degree[v] == 0){
                    q.add(v);
                }
            }
        }

        if(idx != numCourses){
            return new int[0];
        }

        return topo;
    }
}