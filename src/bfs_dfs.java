import java.util.*;

public class bfs_dfs {

    private Map<String, Set<String>> adjList = new HashMap<>();

    public List<String> bfs(String start){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> bfsTraversal = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()){
            String vertex = queue.poll();
            bfsTraversal.add(vertex);
            for (String neighbor : adjList.getOrDefault(vertex, new HashSet<>())){
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return bfsTraversal;
    }

    private void dfsRecursive(String vertex, Set<String> visited, List<String> dfsTraversal){
        visited.add(vertex);
        dfsTraversal.add(vertex);

        for(String neighbor : adjList.getOrDefault(vertex, new HashSet<>())){
            if(!visited.contains(neighbor)){
                dfsRecursive(neighbor,visited,dfsTraversal);
            }
        }
    }

    public List<String> dfs(String startVertex){
        Set<String> visited = new HashSet<>();
        List<String> dfsTraversal = new ArrayList<>();

        dfsRecursive(startVertex, visited, dfsTraversal);

        return dfsTraversal;

    }
}
