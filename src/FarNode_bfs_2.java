import java.util.*;

public class FarNode_bfs_2 {
    public int solution(int n, int[][] edge) {

        // 이런 유형의 문제 배우는 법
        // 1. 따라 쳐본다 -> 모르는 문법을 ChatGPT 한테 물어보면서
        // 2. 초기화하고 안보고 똑같이 쳐본다 (컴파일이 안되도됨.) -> 빠트린 부분 학습
        // 3. 이해할려고 하고 내 방식으로 리팩토링 하기


        // edge = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]

        // 인접리스트로 만듬
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for(int[] e : edge) {
            // e = [3,6]
            int source = e[0];
            int destination = e[1];
            adjList.putIfAbsent(source, new HashSet<>()); //[3, [6,1,2]]
            adjList.putIfAbsent(destination, new HashSet<>()); // [6, [3,1,2,4]]
            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }


        // bfs
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> distanceList = new ArrayList<>(Collections.nCopies(n+1, 0));
        //[0,{1번노드까지 가는데 거리=0},{2번노드까지 가는데 거리=1},{3=1},{4=2}, {5=2}, {6=2} ]

        int start = 1;
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll(); //1번 나옴, 2번나옴
            for(Integer neighbor: adjList.getOrDefault(vertex, new HashSet<>())) {
                int curDistance = distanceList.get(vertex); // 1
                if (!visited.contains(neighbor)) {
                    distanceList.set(neighbor, curDistance+1);
                    queue.add(neighbor);  // 2, 3
                    visited.add(neighbor); // [1,2,3,4,5]
                }
            }
        }

        distanceList.sort(Collections.reverseOrder());
        int answer = 0;
        int maxDistance = distanceList.get(0);
        for(int d :  distanceList) {
            if(maxDistance == d) {
                ++answer;
                continue;
            }
            break;
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
        FarNode_bfs_2 farNode2 = new FarNode_bfs_2();

        // 결과 출력
        int result = farNode2.solution(n, edge);
        System.out.println("가장 먼 노드의 개수: " + result);
    }


}