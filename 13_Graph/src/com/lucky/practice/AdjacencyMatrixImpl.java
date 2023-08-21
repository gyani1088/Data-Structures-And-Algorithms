package com.lucky.practice;

public class AdjacencyMatrixImpl {
    public static void addEdgeForWeightedDirectedGraph(int[][] graph,int src,int dest,int weight){
        graph[src][dest]=weight;
    }
    public static void addEdgeForWeightedGraph(int[][] graph,int src,int dest,int weight){
        graph[src][dest]=weight;
        graph[dest][src]=weight;
    }
}
