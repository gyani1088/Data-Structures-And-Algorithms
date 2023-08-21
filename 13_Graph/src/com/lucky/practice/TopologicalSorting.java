package com.lucky.practice;

import java.beans.Visibility;
import java.util.*;
import java.util.stream.IntStream;

//Kahn's BFS based algorithm
public class TopologicalSorting {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdgeDirectedGraph(adj,0,1);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,2,4);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,2,3);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,1,3);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,3,4);
        System.out.println(sorting_KahnsBFSAlgo(adj));
        sorting_DFS(adj);

    }
    public static List<Integer> sorting_KahnsBFSAlgo(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[adj.size()];
//        for(int i=0;i<adj.size();i++){
//            for(int j=0;j<adj.get(i).size();j++){
//                indegrees[adj.get(i).get(j)]++;
//            }
//        }
        IntStream.range(0,adj.size()).forEach(i->{
            IntStream.range(0,adj.get(i).size()).forEach(j->indegrees[adj.get(i).get(j)]++);
        });
        IntStream.range(0,adj.size()).filter(index->indegrees[index]==0)
                .forEach((index)->queue.add(index));
        List<Integer> sortedList = new ArrayList<>();
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            sortedList.add(vertex);
            for(int adjacent:adj.get(vertex)){
                indegrees[adjacent]--;
                if(indegrees[adjacent]==0) queue.add(adjacent);
            }
        }
        return sortedList;
    }

    public static void sorting_DFS(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        for(int source=0;source<adj.size();source++){
            if(visited[source]==false)
                DFS(adj, source,stack,visited);
        }
        while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
        System.out.println();
    }
    private static void DFS(ArrayList<ArrayList<Integer>> adj, int source, Stack<Integer> stack,boolean[] visited) {
        visited[source]=true;
        for(int adjacent: adj.get(source)){
            if(!visited[adjacent]) DFS(adj,adjacent,stack,visited);
        }
        stack.push(source);
    }
}
