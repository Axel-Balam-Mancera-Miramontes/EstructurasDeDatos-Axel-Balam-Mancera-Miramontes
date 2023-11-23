package tarea9;

import tarea9.utils.Graph;
import tarea9.utils.GraphNode;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Creating graph.
        Graph<String> graph = new Graph();

        //Adding nodes to graph.
        GraphNode<String> nodeA = new GraphNode<>("AAA");
        GraphNode<String> nodeB = new GraphNode<>("BBB");
        GraphNode<String> nodeC = new GraphNode<>("CCC");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        //Connecting graphs nodes.
        graph.addEdge(nodeA, nodeB, 10);
        graph.addEdge(nodeA, nodeC, 20);

        graph.addEdge(nodeB, nodeA, 30);
        graph.addEdge(nodeB, new GraphNode<String>("EEE"), 30);
        graph.addEdge(nodeB, new GraphNode<String>("EEE"), 40);

        //Showing graph nodes.
        for (GraphNode<String> nodo : graph.getNodes()) {
            System.out.println(nodo);
        }

        //Perform DFS.
        System.out.println("Los nodos AAA y CCC " + ((graph.isPathExistsDFS(nodeA, nodeC))? "sí" : "no") + " están conectados");
        System.out.println("Los nodos CCC y AAA " + ((graph.isPathExistsDFS(nodeC, nodeA))? "sí" : "no") + " están conectados");

        //Perform BFS.
        System.out.println("Los nodos AAA y CCC " + ((graph.isPathExistsBFS(nodeA, nodeC))? "sí" : "no") + " están conectados");
        System.out.println("Los nodos CCC y AAA " + ((graph.isPathExistsBFS(nodeC, nodeA))? "sí" : "no") + " están conectados");
    }
}
