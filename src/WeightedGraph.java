import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(destination);
        if (sourceVertex == null || destVertex == null) {
            throw new IllegalArgumentException("Vertex not found");
        }
        sourceVertex.addAdjacentVertex(destVertex, weight);
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Set<V> getAllVertexData() {
        return vertices.keySet();
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
