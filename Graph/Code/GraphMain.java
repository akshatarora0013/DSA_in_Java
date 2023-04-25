package Graph.Code;

import java.util.HashMap;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVerteces("A");
        graph.addVerteces("B");
        graph.addVerteces("C");
        graph.addVerteces("D");
        graph.addVerteces("E");
        graph.addVerteces("F");
        graph.addVerteces("G");

        graph.addEdge("A", "B",2);
        graph.addEdge("A", "D",6);
        graph.addEdge("B", "C",3);
        graph.addEdge("C", "D",1);
        graph.addEdge("D", "E",8);
        graph.addEdge("E", "F",5);
        graph.addEdge("E", "G",7);
        graph.addEdge("F","G", 9);

        graph.display();

//        System.out.println(graph.numberOfEdges());
//        System.out.println(graph.numberOfVerteces());
//        System.out.println(graph.containsEdge("A", "C"));
//        System.out.println(graph.containsEdge("E", "F"));
//
//        graph.removeEdge("D","E");
//        graph.display();
//
//        graph.removeVertex("F");
//        graph.display();
//
//        graph.addVerteces("F");
//
//        graph.addEdge("A", "F", 10);
//        graph.display();

//        System.out.println(graph.hasPath("A", "F", new HashMap<>()));
//        System.out.println(graph.bfs("A","F"));
//        graph.bft();

//        System.out.println(graph.dfs("A", "F"));
//        graph.dft();

//        System.out.println(graph.isCyclic());

//        System.out.println(graph.isConnected());

//        System.out.println(graph.isTree());

//        System.out.println(graph.connectedComponents());

//        graph.prismsAlgo().display();
//        System.out.println(graph.dijkstraAlgo("A"));

//        System.out.println(graph.bellmanFord("A"));
    }
}
