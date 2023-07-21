package Algorithms;

import java.util.*;

public class PrimAlgorithm {
    public static void primsAlgo(ArrayList<ArrayList<Node>> adj, int n) {
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mstSet = new boolean[n];
        for (int i = 0; i < n; i++) {
            key[i] = 1000000;
            mstSet[i] = false;
            parent[i] = -1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        key[0]=0;
        pq.add(new Node(0,key[0]));
        for (int i = 0; i < n - 1; i++) {
            int u = pq.poll().getV();
            mstSet[u]=true;

            for(Node it : adj.get(u)){
                if((!mstSet[it.getV()]) && (it.getWeight()<key[it.getV()])){
                    parent[it.getV()]=u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(parent[i]+" -> "+i);
        }
    }
}
