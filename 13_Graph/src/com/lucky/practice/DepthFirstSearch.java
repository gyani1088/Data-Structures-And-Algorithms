package com.lucky.practice;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static void main(String[] args) {
        int vertices = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdge(adj,0,1);
        AdjacencyListImpl.addEdge(adj,0,2);
        AdjacencyListImpl.addEdge(adj,1,2);
        AdjacencyListImpl.addEdge(adj,2,4);
        AdjacencyListImpl.addEdge(adj,3,4);
        AdjacencyListImpl.addEdge(adj,4,6);
        AdjacencyListImpl.addEdge(adj,5,6);
        AdjacencyListImpl.addEdge(adj,6,7);
        AdjacencyListImpl.addEdge(adj,7,8);
        DFS(adj,0);

        vertices = 9;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj2.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdge(adj2,0,1);
        AdjacencyListImpl.addEdge(adj2,0,2);
        AdjacencyListImpl.addEdge(adj2,1,2);
        AdjacencyListImpl.addEdge(adj2,2,4);
        AdjacencyListImpl.addEdge(adj2,3,4);
        AdjacencyListImpl.addEdge(adj2,5,6);
        AdjacencyListImpl.addEdge(adj2,5,7);
        AdjacencyListImpl.addEdge(adj2,6,7);
        AdjacencyListImpl.addEdge(adj2,7,8);
        System.out.println("\nDisjoint graph");
        DFSAll(adj2);
    }
    public static void DFS(ArrayList<ArrayList<Integer>> adj,int source){
        boolean[] visited = new boolean[adj.size()];
        dfsRecursive(adj,source,visited);
    }

    //DFS is recursive in nature
    public static void dfsRecursive(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source+" ");
        for(int vertex: adj.get(source)){
            if(visited[vertex]==false) dfsRecursive(adj,vertex,visited);
        }
    }

    //For disjoint graphs and no source vertex
    public static void DFSAll(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false) dfsRecursive(adj,i,visited);
        }

    }
}
