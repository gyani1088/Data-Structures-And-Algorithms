package com.lucky.practice;

import java.util.ArrayList;

public class AdjacencyListImpl {

    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v){
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public static void addEdgeDirectedGraph(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v){
        adjacencyList.get(u).add(v);
    }

    public static void addEdgeWeightedDirectedGraph(ArrayList<ArrayList<Weight>> adjacencyList, int u, int v,int weight){
        adjacencyList.get(u).add(new Weight(u,v,weight));

    }

    public static void addEdgeWeightedGraph(ArrayList<ArrayList<Weight>> adjacencyList, int u, int v,int weight){
        adjacencyList.get(u).add(new Weight(u,v,weight));
        adjacencyList.get(v).add(new Weight(v,u,weight));
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        printGraph(adj);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList){
        for(int i=0;i< adjacencyList.size();i++){
            System.out.print(i+"->(");
            for(int j=0;j<adjacencyList.get(i).size();j++){
                System.out.print(adjacencyList.get(i).get(j)+" ");
            }
            System.out.println(")");
        }
    }
}

class Weight{
    int source;
    int dest;
    int weight;

    public Weight(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

}