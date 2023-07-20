package Algorithms;

import java.util.ArrayList;

public class BellmanFord {
    public static void BellmanFord(ArrayList<Node> edges, int n, int src){
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = 10000000;

        dist[src]=0;
        for (int i = 0; i < n-1; i++) {
            for(Node node : edges){
                if(dist[node.getU()]+node.getWeight()<dist[node.getV()])
                    dist[node.getV()] = dist[node.getU()]+node.getWeight();
            }
        }
        int fl = 0;
        for(Node node : edges){
            if(dist[node.getU()]+node.getWeight()<dist[node.getV()]){
                fl=1;
                System.out.println("Negative cycle");
                break;
            }
        }
        if(fl==0){
            for (int i = 0; i < n; i++) {
                System.out.println(i+" "+dist[i]);
            }
        }
    }
}
