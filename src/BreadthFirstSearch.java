import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<V, V> edgeTo;
    private Set<V> marked;
    private final V start;

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        this.start = start;
        edgeTo = new HashMap<>();
        marked = new HashSet<>();
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, V start) {
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        marked.add(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            Vertex<V> vertex = graph.getVertex(current);
            for (Vertex<V> neighbor : vertex.getAdjacentVertices().keySet()) {
                V neighborData = neighbor.getData();
                if (!marked.contains(neighborData)) {
                    marked.add(neighborData);
                    edgeTo.put(neighborData, current);
                    queue.add(neighborData);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return marked.contains(destination);
    }

    @Override
    public List<V> getPath(V destination) {
        if (!hasPathTo(destination)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V at = destination; !at.equals(start); at = edgeTo.get(at)) {
            path.addFirst(at);
        }
        path.addFirst(start);
        return path;
    }
}
