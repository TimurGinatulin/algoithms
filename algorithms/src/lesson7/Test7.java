package lesson7;

public class Test7 {

    public static void main(String[] args) {
testGraph();
    }

    private static void testGraph() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "D", 3);
        graph.addEdge("D", "H", 6);
        graph.addEdge("B", "E", 4);
        graph.addEdge("E", "I", 9);
        graph.addEdge("C", "F", 5);
        graph.addEdge("F", "G", 8);
        graph.addEdge("G", "J", 10);
       // graph.addEdge("I", "J", 143);
        System.out.println("Size of graph is " + graph.getSize());

        System.out.println(graph.findShortPathViaBfs("A","J"));
        //  graph.display();
    }



}
