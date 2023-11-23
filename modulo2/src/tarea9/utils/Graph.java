package tarea9.utils;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

/**
 * Represents a weighted directed graph.
 *
 * @param <T> The type of data stored in the graph nodes.
 */
public class Graph<T> {
    private Set<GraphNode<T>> nodes;

    /**
     * Initializes an empty graph.
     */
    public Graph() {
        nodes = new HashSet<>();
    }

    /**
     * Adds a node to the graph if it doesn't already exist.
     *
     * @param newNode The node to be added.
     */
    public void addNode(GraphNode<T> newNode) {
        if (newNode != null && !nodes.contains(newNode)) {
            nodes.add(newNode);
        }
    }

    /**
     * Adds an edge between two nodes with an associated weight.
     *
     * @param from   The source node.
     * @param to     The target node.
     * @param weight The weight of the edge.
     */
    public void addEdge(GraphNode<T> from, GraphNode<T> to, int weight) {
        if (from != null && to != null) {
            from = getNode(from.getData());
            from.addEdge(to, weight);
            addNode(from);
            addNode(to);
        }
    }

    //Search methods.

    /**
     * Perform a depth-first search (DFS) to determine if there is a path from the source node to the destination node.
     *
     * @param source      The source node.
     * @param destination The destination node.
     * @return True if there is a path, false otherwise.
     */
    public boolean isPathExistsDFS(GraphNode<T> source, GraphNode<T> destination) {
        System.out.println("Depht First Search");

        if (source == null || destination == null) {
            return false;
        }

        Set<GraphNode<T>> visited = new HashSet<>();
        Stack<GraphNode<T>> stack = new Stack<>();

        stack.push(source);
        visited.add(source);

        while (!stack.isEmpty()) {
            GraphNode<T> currentNode = stack.pop().get();
            System.out.println("Current node: \n" + currentNode);

            if (currentNode.equals(destination)) {
                return true;
            }

            for (GraphNode<T> neighbor : currentNode.getEdges().keySet()) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }

    /**
     * Perform a breadth-first search (BFS) to determine if there is a path from the source node to the destination node.
     *
     * @param source      The source node.
     * @param destination The destination node.
     * @return True if there is a path, false otherwise.
     */
    public boolean isPathExistsBFS(GraphNode<T> source, GraphNode<T> destination) {
        System.out.println("Breadth-First Search");

        if (source == null || destination == null) {
            return false;
        }

        Set<GraphNode<T>> visited = new HashSet<>();
        Queue<GraphNode<T>> queue = new Queue<>();

        queue.push(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.peek().get();
            System.out.println("Current node:\n" + currentNode);

            if (currentNode.equals(destination)) {
                return true;
            }

            for (GraphNode<T> neighbor : currentNode.getEdges().keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.push(neighbor);
                    visited.add(neighbor);
                }
            }

            queue.pop();
        }

        return false;
    }

    //Class' getters.

    /**
     * Retrieves a node by its data value.
     *
     * @param data The data value of the desired node.
     * @return The node with the specified data value, or null if not found.
     */
    public GraphNode<T> getNode(T data) {
        Optional<GraphNode<T>> foundNode = nodes.stream()
                .filter(node -> data.equals(node.getData()))
                .findFirst();
        return foundNode.orElse(null);
    }

    /**
     * Gets the set of nodes in the graph.
     *
     * @return The set of nodes.
     */
    public Set<GraphNode<T>> getNodes() {
        return nodes;
    }



}
