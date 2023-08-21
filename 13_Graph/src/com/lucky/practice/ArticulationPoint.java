package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//A vertex in the graph, removal of which creates 2 or more connected components
public class ArticulationPoint {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdge(adj,0,1);
        AdjacencyListImpl.addEdge(adj,0,3);
        AdjacencyListImpl.addEdge(adj,1,2);
        AdjacencyListImpl.addEdge(adj,1,4);
        AdjacencyListImpl.addEdge(adj,2,3);
        AdjacencyListImpl.addEdge(adj,4,5);
        AdjacencyListImpl.addEdge(adj,4,6);
        AdjacencyListImpl.addEdge(adj,5,6);
        System.out.println(AP(adj,0));
    }
    public static List<Integer> AP(ArrayList<ArrayList<Integer>> adj,int time){
        int V = adj.size();
        boolean visited[] = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        //For DFS tree
        int[] parent = new int[V];
        Arrays.fill(parent,-1);
        boolean[] ap = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                APUtil(adj,i,visited,disc,low,parent,ap,time);
            }
        }
        return IntStream.range(0,V).filter(i->ap[i]==true).boxed().collect(Collectors.toList());
    }
    private static void APUtil(ArrayList<ArrayList<Integer>> adj,int source, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap, int time){
        int children = 0;
        visited[source] = true;
        disc[source] = low[source] = ++time;
        for(int adjacent : adj.get(source)){
            if(!visited[adjacent]){
                children++;
                //DFS tree
                parent[adjacent] = source;
                //updating the parent array and the visited array
                APUtil(adj,adjacent,visited,disc,low,parent,ap,time);
                low[source]=Math.min(low[source],low[adjacent]);
                // when root has 2 or more children
                if(parent[source]==-1 && children>1){
                    ap[source]=true;
                }
                //when a non-root node has at least one child with low[child] >= disc[parent]
                if(parent[source]!=-1 && low[adjacent]>=disc[source]){
                    ap[source]=true;
                }
            }
            //adjacent which is not parent of the current element will update by low value of current element
            else if (adjacent!=parent[source]){
                low[source] = Math.min(low[source],disc[adjacent]);
            }
        }
    }
}
