package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BellmanFordShortestPathAlgo {
    public static void main(String[] args) throws Exception {
        int vertices = 6;
        ArrayList<ArrayList<Weight>> adj = new ArrayList<ArrayList<Weight>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Weight>());
        }
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,0,1,2);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,1,2,3);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,2,3,-3);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,0,4,1);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,4,5,4);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,4,2,2);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,5,3,1);
        System.out.println(Arrays.stream(findShortestPath(adj,0)).mapToObj(i->Integer.toString(i))
                .collect(Collectors.joining(" ")));

    }
    public static int[] findShortestPath(ArrayList<ArrayList<Weight>> adj, int source) throws Exception {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        List<Weight> weights = adj.stream().flatMap(arr->arr.stream())
                .collect(Collectors.toList());
        for(int i=0;i<adj.size()-1;i++){
            for(Weight wt: weights){
                if(dist[wt.dest]>dist[wt.source]+wt.weight)
                    dist[wt.dest]=dist[wt.source]+wt.weight;
            }
            System.out.println(Arrays.stream(dist).mapToObj(num->Integer.valueOf(num)).collect(Collectors.toList()));
        }
        for(Weight wt: weights){
            if(dist[wt.dest]>dist[wt.source]+wt.weight)
                throw new Exception("Negative weight cycle found");
        }
        return dist;
    }
}
