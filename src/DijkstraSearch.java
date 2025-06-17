import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private final Map<V, Double> distances;
    private final Map<V, V> previous;
    private final Set<V> visited;
    private final PriorityQueue<VertexDistance<V>> priorityQueue;
    private final V start;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        this.start = start;
        distances = new HashMap<>();
        previous = new HashMap<>();
        visited = new HashSet<>();
        priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));

        for (V vertex : graph.getAllVertexData()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        priorityQueue.add(new VertexDistance<>(start, 0.0));

        while (!priorityQueue.isEmpty()) {
            V current = priorityQueue.poll().getVertex();
            if (!visited.add(current)) continue;

            Vertex<V> currentVertex = graph.getVertex(current);
            for (Map.Entry<Vertex<V>, Double> neighborEntry : currentVertex.getAdjacentVertices().entrySet()) {
                V neighbor = neighborEntry.getKey().getData();
                double weight = neighborEntry.getValue();
                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    priorityQueue.add(new VertexDistance<>(neighbor, newDist));
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return distances.containsKey(destination) && distances.get(destination) < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<V> getPath(V destination) {
        if (!hasPathTo(destination)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V at = destination; at != null && !at.equals(start); at = previous.get(at)) {
            path.addFirst(at);
        }
        path.addFirst(start);
        return path;
    }

    private static class VertexDistance<V> {
        private final V vertex;
        private final double distance;

        public VertexDistance(V vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public V getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}
