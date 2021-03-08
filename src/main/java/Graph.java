import java.util.*;

public class Graph {

    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    public Graph() {

    }

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

    public ArrayList<ArrayList<Integer>> getAdj() { return this.adj;}

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);

        g.DFS(0);

    }
}

class TopologicalSort {
       // mark v as visited
        // iterate through all of adjacent vertices
        // after iterating, push v onto stack
     List<List<Integer>> adj;
     int V;


    TopologicalSort(int V) {
        this.V = V;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(Integer v, int w){
        adj.get(v).add(w);
    }

    public void topologicalSortUtil(boolean[] visited, int v, Stack<Integer> stack){
            visited[v] = true;

            for(int x : adj.get(v)) {
                if(!visited[x]) topologicalSortUtil(visited, x, stack);
            }

            stack.push(v);
      }

      public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[V];

          for (int i = 0; i < V; i++) {
              if(!visited[i]) topologicalSortUtil(visited, i, stack);
          }

          while(!stack.isEmpty()) System.out.print((char) ('a' + stack.pop()) + " ");
      }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }
}


class AlienDictionary {
    public void findOrderOfChars(String[] words, int alpha) {
        // alpha is number of chars from a allowed in that alien language
        // for any 2 words in arr, compare them char by char
        // as soon as a mismatch happens, add edge from w1 to w2
        // do topo sort at the end

        TopologicalSort topologicalSort = new TopologicalSort(alpha);

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    topologicalSort.addEdge(w1.charAt(j) - 'a', w2.charAt(j) - 'a');
                    break;
                }
            }
        }

        topologicalSort.topologicalSort();
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] str = {"caa", "aaa", "aab" };
        alienDictionary.findOrderOfChars(str, 3);
    }
}
