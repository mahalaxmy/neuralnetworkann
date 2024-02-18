import java.util.*;

class Node {
    private String label;
    private List<Edge> edges;

    public Node(String label) {
        this.label = label;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Node destination, double weight) {
        edges.add(new Edge(destination, weight));
    }

    public double getEdgeWeight(Node destination) {
        for (Edge edge : edges) {
            if (edge.getDestination() == destination) {
                return edge.getWeight();
            }
        }
        return Double.POSITIVE_INFINITY; // Edge not found
    }
}

class Edge {
    private Node destination;
    private double weight;

    public Edge(Node destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}

public class WeightedGraphExample {
    public static void main(String[] args) {
        Node vertex1 = new Node("vertex1");
        Node vertex2 = new Node("vertex2");
        Node vertex3 = new Node("vertex3");

        vertex1.addEdge(vertex2, 5.0);
        vertex2.addEdge(vertex3, 3.0);

        // Query edge weight
        double weightFromVertex1ToVertex2 = vertex1.getEdgeWeight(vertex2);
        System.out.println("Weight from vertex1 to vertex2: " + weightFromVertex1ToVertex2);

        double weightFromVertex2ToVertex3 = vertex2.getEdgeWeight(vertex3);
        System.out.println("Weight from vertex2 to vertex3: " + weightFromVertex2ToVertex3);
    }
}
