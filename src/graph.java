class graph {
    int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {2, 3}
    };
    int numVertices = 4;
    int[][] adjMatrix = new int[numVertices][numVertices]; // 인접 행렬 초기화

    // 생성자에서 인접 행렬을 설정
    public graph() {
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            adjMatrix[source][destination] = 1;
            adjMatrix[destination][source] = 1;
        }
    }

    // 인접 행렬 출력 메서드 (테스트용)
    public void printAdjMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        graph graph = new graph(); // 그래프 생성
        graph.printAdjMatrix(); // 인접 행렬 출력
    }
}
