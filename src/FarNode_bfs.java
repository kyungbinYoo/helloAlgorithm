import java.util.*;

class FarNode_bfs {
    private Map<Integer, Set<Integer>> adjList = new HashMap<>();

    public int FarNode_bfs(int n, int[][] edge) {

        for (int i = 1; i <= n; i++) {
            adjList.put(i, new HashSet<>());
        }

        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }


        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distance = new HashMap<>();

        queue.add(1);
        visited.add(1);
        distance.put(1, 0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.getOrDefault(node, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    distance.put(neighbor, distance.get(node) + 1);
                }
            }
        }


        int maxDistance = Collections.max(distance.values());


        int answer = 0;
        for (int dist : distance.values()) {
            if (dist == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 6; // 노드 개수
        int[][] edge = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };

        // FarNode_bfs 클래스 객체 생성
        FarNode_bfs farNode = new FarNode_bfs();

        // 결과 출력
        int result = farNode.FarNode_bfs(n, edge);
            System.out.println("가장 먼 노드의 개수: " + result);
    }
}
