package com.lucky.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class CycleDetectionDirectedGraph {
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdgeDirectedGraph(adj,0,1);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,2,1);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,2,3);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,3,4);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,4,5);
//        AdjacencyListImpl.addEdgeDirectedGraph(adj,3,5); //false
        AdjacencyListImpl.addEdgeDirectedGraph(adj,5,3); //true
//        AdjacencyListImpl.addEdge(adj,5,6);
//        AdjacencyListImpl.addEdge(adj,6,7);
//        AdjacencyListImpl.addEdge(adj,7,8);
        System.out.println(DFS_detectCycle(adj));
        System.out.println(BFS_detectCycle_KahnsAlgo(adj));
    }
    public static boolean DFS_detectCycle(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited  = new boolean[adj.size()];
        boolean[] recStack = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false) {
                if (DFSRec(adj, i, visited, recStack)) return true;
            }
        }
        return false;
    }

    public static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited, boolean[] recStack) {
        visited[source]=true;
        recStack[source]=true;
        for(int adjacent:adj.get(source)){
            if(visited[adjacent]==false && DFSRec(adj,adjacent,visited,recStack)) return true;
            else if(recStack[adjacent]==true) return true;
        }
        recStack[source]=false;
        return false;
    }

    //Kahn's BFS algorithm to find cycles
    public static boolean BFS_detectCycle_KahnsAlgo(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[adj.size()];
        IntStream.range(0,adj.size()).forEach(i->{
            IntStream.range(0,adj.get(i).size()).forEach(j->indegrees[adj.get(i).get(j)]++);
        });
        IntStream.range(0,adj.size()).filter(index->indegrees[index]==0)
                .forEach((index)->queue.add(index));
        int count=0;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            count++;
            for(int adjacent:adj.get(vertex)){
                indegrees[adjacent]--;
                if(indegrees[adjacent]==0) queue.add(adjacent);
            }
        }
        return (count<adj.size());
    }
}
