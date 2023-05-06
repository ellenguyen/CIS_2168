import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
    	int[] distTo = new int[adj.length];
    	// set each vertex to infinity
    	Arrays.fill(distTo, Integer.MAX_VALUE);	
    	
    	// distance at the start vertex is 0
    	distTo[s] = 0;										
    	
    	// initiate a PQ to keep track of vertex with shortest path
    	PriorityQueue<Integer> queue = new PriorityQueue<>(adj.length);
    	queue.add(s);
    	
    	while (!queue.isEmpty()) {
    		int v = queue.remove();
    		int i = 0;
    		
    		// looking into each adjacent vertex
    		for (int w : adj[v]) {
    			// get new distance and compare with current distance
    			// update distance if new distance is smaller
    			int newDist = distTo[v] + cost[v].get(i);
    			if (distTo[w] > newDist || distTo[w] == Integer.MAX_VALUE) {
    				distTo[w] = newDist;
    				queue.add(w);
    			}
    			i++;
    		}
    	}
    	
    	// return smallest distance from start to end vertex
    	if (distTo[t] != Integer.MAX_VALUE)		return distTo[t];
    	else									return -1;
    }

    public static void main(String[] args) {
        In in = new In("G4-3.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = in.readInt();
            y = in.readInt();
            w = in.readInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}