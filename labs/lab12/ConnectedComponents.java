import java.util.*;
import java.io.*;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
    	int count = 0;
    	boolean[] marked = new boolean[adj.length];
    	for (int i = 0; i < adj.length; i++) {
    		if (!marked[i]) {
    			count++;
    			dfs(adj, i, marked);
    		}
    	}
        return count; // return the number of components in the graph
    }

    private static void dfs(ArrayList<Integer>[] adj, int v, boolean[] marked) {
    	marked[v] = true;
    	for (Integer vertex : adj[v]) {
    		if (!marked[vertex])	dfs(adj, vertex, marked);
    	}
    }

    public static void main(String[] args) {
        In in = new In("G2-3.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}