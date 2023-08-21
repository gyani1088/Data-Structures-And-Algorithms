package com.lucky.practice;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraph {
    public static void main(String[] args) {
        int vertices = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdge(adj,0,1);
        AdjacencyListImpl.addEdge(adj,0,2);
      //  AdjacencyListImpl.addEdge(adj,1,2);
//        AdjacencyListImpl.addEdge(adj,2,4);
//        AdjacencyListImpl.addEdge(adj,3,4);
//        AdjacencyListImpl.addEdge(adj,4,6);
//        AdjacencyListImpl.addEdge(adj,5,6);
//        AdjacencyListImpl.addEdge(adj,6,7);
//        AdjacencyListImpl.addEdge(adj,7,8);
        System.out.print(DFS_detectCycle(adj));
    }
    public static boolean DFS_detectCycle(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited  = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false)
                if (DFSRec(adj,i,visited,-1)) return true;
        }
        return false;
    }

    private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited, int parent) {
        visited[source]=true;
        for(int adjacent:adj.get(source)) {
            if (visited[adjacent] == false) {
                //source becomes parent and adjacent becomes source for the next recursive call
                if (DFSRec(adj, adjacent, visited, source) == true) return true;
            }
            else if (adjacent != parent) return true;
        }
        return false;
    }
}
