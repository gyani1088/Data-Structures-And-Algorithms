package com.lucky.practice;

import java.util.ArrayList;

import static com.lucky.practice.BreadthFirstSearch.breadthFirstSearch2;
import static com.lucky.practice.DepthFirstSearch.dfsRecursive;

public class CountConnectedComponents {
    public static void main(String[] args) {

        int vertices = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdge(adj,0,1);
        AdjacencyListImpl.addEdge(adj,0,2);
        AdjacencyListImpl.addEdge(adj,5,6);
        AdjacencyListImpl.addEdge(adj,1,2);
        AdjacencyListImpl.addEdge(adj,3,4);
        AdjacencyListImpl.addEdge(adj,6,7);
        AdjacencyListImpl.addEdge(adj,7,8);
        System.out.println("\nCount: "+ countConnectedComponentsBFS(adj));
        System.out.println("\nCount: "+ countConnectedComponentsDFS(adj));
    }

    public static int countConnectedComponentsBFS(ArrayList<ArrayList<Integer>> adj){
        int count = 0;
        boolean[] visited = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false) {
                //write a function similar to the above method accepting visited from other func
                count++;
                breadthFirstSearch2(adj, i, visited);
            }
        }
        return count;
    }

    public static int countConnectedComponentsDFS(ArrayList<ArrayList<Integer>> adj){
        int count = 0;
        boolean[] visited = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false) {
                //write a function similar to the above method accepting visited from other func
                count++;
                dfsRecursive(adj, i, visited);
            }
        }
        return count;
    }
}
