package com.lucky.practice;

import java.util.*;

public class ShortestPathInUnweightedGraph {
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
        Arrays.stream(shortestPaths(adj,0)).forEach(i->System.out.print(i+" "));
    }

    //Use BFS and each time you visit a  new vertex add 1 for the distance to it
    //Time complexity : O(V+E)
    public static int[] shortestPaths(ArrayList<ArrayList<Integer>> adj, int source){
        boolean[] visited = new boolean[adj.size()];
        int[] dist = new int[adj.size()];
        Arrays.stream(dist).forEach(i->i=Integer.MAX_VALUE);
        //for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        dist[source]=0;
        visited[source]=true;
        while(!queue.isEmpty()){
            int currVertex = queue.poll();
            for(int adjacent : adj.get(currVertex)){
                if(visited[adjacent]==false){
                    dist[adjacent] = dist[currVertex]+1;
                    visited[adjacent]=true;
                    queue.add(adjacent);
                }
            }
        }
        return dist;
    }
}
