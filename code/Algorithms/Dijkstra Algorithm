package Algorithms;

import org.jetbrains.annotations.NotNull;

import java.util.*;
public class DijkstraAlgorithm {
    public static void shortestPath(int source, ArrayList<ArrayList<Node>> adj, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = 1000000;
        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(source,0));
        while(pq.size()>0){
            Node node = pq.poll();
            for(Node it : adj.get(node.getV())){
                if(dist[node.getV()]+it.getWeight()<dist[it.getV()]){
                    dist[it.getV()] = dist[node.getV()]+it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dist[i]+"->");
        }
    }
}
