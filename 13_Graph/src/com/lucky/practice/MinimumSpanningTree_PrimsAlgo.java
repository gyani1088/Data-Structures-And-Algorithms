package com.lucky.practice;

import java.util.Arrays;

public class MinimumSpanningTree_PrimsAlgo {
    public static void main(String[] args) {
        int vertices = 4;
        int[][] graph = new int[vertices][vertices];
        AdjacencyMatrixImpl.addEdgeForWeightedGraph(graph,0,1,5);
        AdjacencyMatrixImpl.addEdgeForWeightedGraph(graph,0,2,8);
        AdjacencyMatrixImpl.addEdgeForWeightedGraph(graph,1,2,10);
        AdjacencyMatrixImpl.addEdgeForWeightedGraph(graph,1,3,15);
        AdjacencyMatrixImpl.addEdgeForWeightedGraph(graph,2,3,20);
        System.out.println(minimumSpanningTree_Spanning(graph));

    }
    public static int minimumSpanningTree_Spanning(int[][] graph){
        //key holds the value for the smallest weighted edge to reach each vertex(index)
        int key[] = new int[graph.length];
        int min = 0;
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        //mSet -> will hold the set of all the vertices that are already spanned and are remaining to be spanned
        boolean[] mSet = new boolean[graph.length];
        for(int count=0;count<graph.length;count++){
            int src=-1;
            //to find the smallest weight and choose the next source to update key array if there are
            // any new minimum weights from the newly added source
            for(int i=0;i<graph.length;i++){
                if(!mSet[i] && (src==-1 || key[i]<key[src]))
                    src=i;
            }
            mSet[src]=true;
            min+=key[src];
            //to find the smallest weight of the edges from the fixed source to the remaining destinations
            for(int dest=0;dest<graph.length;dest++){
                if(!mSet[dest] && graph[src][dest]!=0 && key[dest]>graph[src][dest])
                    key[dest]=graph[src][dest];
            }
        }
        return min;
    }
}
