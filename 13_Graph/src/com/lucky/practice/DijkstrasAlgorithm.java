package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<ArrayList<Weight>> adj = new ArrayList<ArrayList<Weight>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Weight>());
        }
        //0:(1,5),(2,10)
        //1:(0,5),(2,3),(3,20)
        //2:(0,10),(1,3),(3,2)
        //3:(1,20),(2,2)
        AdjacencyListImpl.addEdgeWeightedGraph(adj,0,1,5);
        AdjacencyListImpl.addEdgeWeightedGraph(adj,0,2,10);
        AdjacencyListImpl.addEdgeWeightedGraph(adj,1,2,3);
        AdjacencyListImpl.addEdgeWeightedGraph(adj,1,3,20);
        AdjacencyListImpl.addEdgeWeightedGraph(adj,2,3,2);
//        System.out.println(Arrays.stream(shortestPathToVertices(adj,0))
//                .mapToObj(i->Integer.toString(i))
//                .collect(Collectors.joining(" ")));
//-------------------------------------+2+---------------------------------------------//
        vertices = 9;
        ArrayList<ArrayList<Weight>> adj2 = new ArrayList<ArrayList<Weight>>(vertices);
        for(int i=0;i<vertices;i++){
            adj2.add(new ArrayList<Weight>());
        }

        AdjacencyListImpl.addEdgeWeightedGraph(adj2,0,1,4);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,0,2,8);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,1,2,11);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,1,3,8);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,2,4,7);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,2,5,1);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,3,4,2);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,3,6,7);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,3,7,4);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,4,5,6);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,5,7,2);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,6,7,14);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,6,8,9);
        AdjacencyListImpl.addEdgeWeightedGraph(adj2,7,8,10);
        System.out.println(Arrays.stream(shortestPathToVertices(adj2,0))
                .mapToObj(i->Integer.toString(i))
                .collect(Collectors.joining(" ")));
    }
    public static int[] shortestPathToVertices(ArrayList<ArrayList<Weight>> adj,int source){
        PriorityQueue<Weight> pq = new PriorityQueue<>((p1,p2)-> p1.weight-p2.weight);
        int[] dist = new int[adj.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        boolean[] fin = new boolean[adj.size()];
        pq.add(new Weight(source,0,0));
        while(!pq.isEmpty()){
            Weight curr = pq.poll();
            //Relaxation
            fin[curr.source] = true;
            for(Weight adjacent : adj.get(curr.source)) {
                if (!fin[adjacent.dest] && dist[adjacent.dest] > dist[curr.source] + adjacent.weight){
                    dist[adjacent.dest] = dist[curr.source] + adjacent.weight;
                    pq.add(new Weight(adjacent.dest,curr.source,dist[adjacent.dest]));
                }
            }
        }
        return dist;
    }
}

//0:(1,5),(2,10)
//1:(0,5),(2,3),(3,20)
//2:(0,10),(1,3),(3,2)
//3:(1,20),(2,2)