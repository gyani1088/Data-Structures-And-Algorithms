package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Solved it using discoverytime and lowest discovery time reachable concept
public class BridgeInAGraph {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdge(adj,0,1);
        AdjacencyListImpl.addEdge(adj,0,2);
        AdjacencyListImpl.addEdge(adj,1,2);
        AdjacencyListImpl.addEdge(adj,1,3);
        AdjacencyListImpl.addEdge(adj,3,4);
        System.out.println(bridge(adj,0));
    }
    //we need disc, low and parent arrays separately to copy the feature
    public static void bridgeUtil(ArrayList<ArrayList<Integer>> adj,int source,boolean[] visited,int[] parent, int[] disc, int[] low, int time, ArrayList<String> output){
        visited[source]=true;
        disc[source]=low[source]=++time;
        for(int adjacent:adj.get(source)){
            if(!visited[adjacent]){
                parent[adjacent]=source;
                //recursive call
                bridgeUtil(adj,adjacent,visited,parent,disc,low,time,output);
                low[source]=Math.min(low[source],low[adjacent]);
                if(low[adjacent]>disc[source]) output.add(source+"-"+adjacent);
            }
            else if (adjacent!=parent[source]){
                low[source]=Math.min(low[source],disc[adjacent]);
            }
        }
    }

    public static List<String> bridge(ArrayList<ArrayList<Integer>> adj,int time){
        int V = adj.size();
        ArrayList<String> output = new ArrayList<>();
        boolean visited[] = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        //For DFS tree
        int[] parent = new int[V];
        Arrays.fill(parent,-1);
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                bridgeUtil(adj,i,visited,parent,disc,low,time,output);
            }
        }
        return output;
    }
}
