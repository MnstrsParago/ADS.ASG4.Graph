public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        // Create weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Add edges
        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 2);
        graph.addEdge(b, c, 5);
        graph.addEdge(b, d, 10);
        graph.addEdge(c, e, 3);
        graph.addEdge(e, d, 4);

        // Breadth First Search
        System.out.println("Breadth First Search starting from A:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, a);
        for (Vertex<String> vertex : bfs.getPath(d)) {
            System.out.print(vertex + " ");
        }

        System.out.println("\n\nDijkstra Search starting from A:");
        Search<String> dijkstra = new DijkstraSearch<>(graph, a);
        for (Vertex<String> vertex : dijkstra.getPath(d)) {
            System.out.print(vertex + " ");
        }
    }
}
