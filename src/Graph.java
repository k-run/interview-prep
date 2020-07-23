import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(Integer v, int w){
        adj.get(v).add(w);
    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println("v = " + v);

        for (int next : adj.get(v)) {


            if (!visited[next]) {
                DFSUtil(next, visited);
            }
        }
    }


    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        System.out.println("adj = " + adj);

        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);

        g.DFS(0);

    }
}
