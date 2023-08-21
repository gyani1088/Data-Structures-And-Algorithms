package com.lucky.practice;

import javax.xml.stream.util.EventReaderDelegate;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortestPathInWeightedDAG {
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Weight>> adj = new ArrayList<ArrayList<Weight>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Weight>());
        }
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,0,1,2);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,1,2,3);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,2,3,6);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,0,4,1);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,4,5,4);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,4,2,2);
        AdjacencyListImpl.addEdgeWeightedDirectedGraph(adj,5,3,1);
        Arrays.stream(shortestPath(adj,0)).forEach(i->System.out.print(i+" "));
        System.out.println();

    }
    public static int[] shortestPath(ArrayList<ArrayList<Weight>> adj, int source){
        int[] distance = new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source]=0;
        //Topological sorting
        ArrayList<ArrayList<Integer>> unweightedAdj =
                (ArrayList<ArrayList<Integer>>) adj.stream()
                        .map(array->{
            ArrayList<Integer> list = (ArrayList<Integer>) array.stream().map(weight->weight.dest).collect(Collectors.toList());
            return list;
        })
                        .collect(Collectors.toList());
        //unweightedAdj.forEach(System.out::println);
        List<Integer> sortedList = TopologicalSorting.sorting_KahnsBFSAlgo(unweightedAdj);
        for(int vertex:sortedList){
            for(int i=0;i<unweightedAdj.get(vertex).size();i++){
                if(distance[unweightedAdj.get(vertex).get(i)]>distance[vertex]+adj.get(vertex).get(i).weight){
                    distance[unweightedAdj.get(vertex).get(i)]=distance[vertex]+adj.get(vertex).get(i).weight;}
            }
        }
        return distance;
    }
}
