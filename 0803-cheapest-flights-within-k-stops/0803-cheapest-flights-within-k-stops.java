import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];

            if (city == dst) return cost;

            if (stops > k) continue;

            for (int[] nei : graph.getOrDefault(city, new ArrayList<>())) {
                int next = nei[0], price = nei[1];
                if (cost + price < dist[next][stops + 1]) {
                    dist[next][stops + 1] = cost + price;
                    pq.offer(new int[]{cost + price, next, stops + 1});
                }
            }
        }

        return -1;
    }
}
