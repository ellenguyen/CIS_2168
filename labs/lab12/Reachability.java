import java.util.*;
import java.io.*;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
    	boolean[] marked = new boolean[adj.length];
    	dfs(adj, x, marked);
    	if (marked[y]) 	return 1;		// return 1 if find a path
    	else			return 0;		// return 0 if there is no path
    }

    private static void dfs(ArrayList<Integer>[] adj, int v, boolean[] marked) {
    	marked[v] = true;
    	for (Integer vertex : adj[v]) {
    		if (!marked[vertex])	dfs(adj, vertex, marked);
    	}
    }
    
    public static void main(String[] args) {
        In in = new In("G1-1.txt");
        int n = in.readInt();  // number of vertices
        int m = in.readInt();  // number of edges

        // for each vertex, allocate space for its adjacency list
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // read the next m lines of input and build an
        // adjacency list representation of the graph
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(Arrays.toString(adj) + "\n");

        // read the last line of the input file.
        // x = the start vertex; y = the end vertex
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        // is y reachable from x
        System.out.println(reach(adj, x, y));
    }
}