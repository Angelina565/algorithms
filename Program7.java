package lesson7;

public class Program7 {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,3);
        graph.addEdge(3,8);
        graph.addEdge(8,9);
        graph.addEdge(9,1);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);

        BreadthFirstPaths bfsp = new BreadthFirstPaths(graph, 0);

        System.out.println(bfsp.distTo(6));
        System.out.println(bfsp.pathTo(6));

        System.out.println(bfsp.distTo(7));
        System.out.println(bfsp.pathTo(7));

        System.out.println(bfsp.distTo(4));
        System.out.println(bfsp.pathTo(4));

        DepthFirstPaths dfsp = new DepthFirstPaths(graph, 0);

        System.out.println(" ");
        System.out.println(dfsp.pathTo(6));
        System.out.println(dfsp.pathTo(7));
        System.out.println(dfsp.hasPathto(8));

    }
}
