package lesson7;

import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean [] marked;
    private int [] edgeTo;
    private int source;

    public DepthFirstPaths(Graph g, int source) {
        if (source < 0) {
            throw new IllegalArgumentException("не может быть отрицательной вершины");
        }
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        dfs(g, source);
    }

    private void dfs (Graph g, int v) {
        marked[v] = true;
        for (int w:
             g.adjLists(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(g, w);
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
}
