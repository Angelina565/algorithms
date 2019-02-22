package lesson7;

import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean [] marked;
    private int [] distTo;
    private int source;
    private int [] edgeTo;
    private static final int INF = Integer.MAX_VALUE;

    public BreadthFirstPaths(Graph g, int source) {
        if (source < 0) {
            throw new IllegalArgumentException("Вершина не может иметь отрицательное значение");
        }
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        distTo = new int[g.getVertexCount()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INF;
        }
        bfs(g, source);
    }

    private void bfs (Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w:
                 g.adjLists(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] + 1;
                    queue.addLast(w);
                }

            }
        }

    }

    public boolean hasPathto (int destination) {
        return marked[destination];
    }

    public LinkedList<Integer> pathTo (int destination) {
        if (!hasPathto(destination)) {
            return null;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = destination;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    public int distTo (int destination) {
        return distTo[destination];
    }
}
