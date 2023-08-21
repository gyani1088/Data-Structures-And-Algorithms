package com.lucky.practice;

import java.util.*;

public class BreadthFirstSearch {
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
        System.out.println(breadthFirstSearch(adj,3));

        vertices = 6;

        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj2.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdge(adj2,0,1);
        AdjacencyListImpl.addEdge(adj2,0,2);
        AdjacencyListImpl.addEdge(adj2,0,5);
        AdjacencyListImpl.addEdge(adj2,1,3);
        AdjacencyListImpl.addEdge(adj2,2,4);
        AdjacencyListImpl.addEdge(adj2,3,5);
        AdjacencyListImpl.addEdge(adj2,4,5);
        System.out.println(breadthFirstSearch(adj2,0));
        breadthFirstSearch2(adj2,0);

    }

    public static LinkedHashSet<Integer> breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int src){
        Queue<Integer> queue = new LinkedList<>();
        LinkedHashSet<Integer> vertices = new LinkedHashSet<>();
        queue.add(src);
        vertices.add(src);
        while(!queue.isEmpty()){
            src=queue.poll();
            for(int i=0;i<adj.get(src).size();i++){
                int curr = adj.get(src).get(i);
                if(vertices.add(curr)==true){
                    queue.add(curr);
                }

            }
        }
        return vertices;
    }

    public static void breadthFirstSearch2(ArrayList<ArrayList<Integer>> adj, int src){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        queue.add(src);
        visited[src]=true;
        while(!queue.isEmpty()){
            src=queue.poll();
            System.out.print(src+" ");
            for(int i=0;i<adj.get(src).size();i++){
                int curr = adj.get(src).get(i);
                if(visited[curr]==false){
                    visited[curr]=true;
                    queue.add(curr);
                }

            }
        }
    }

    public static void breadthFirstSearch2(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src]=true;
        while(!queue.isEmpty()){
            src=queue.poll();
            System.out.print(src+" ");
            for(int i=0;i<adj.get(src).size();i++){
                int curr = adj.get(src).get(i);
                if(visited[curr]==false){
                    visited[curr]=true;
                    queue.add(curr);
                }

            }
        }
    }
    //for disjoint graphs
    void BFSDis(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false)
                //write a function similar to the above method accepting visited from other func
                breadthFirstSearch2(adj,i,visited);
        }
    }

}
