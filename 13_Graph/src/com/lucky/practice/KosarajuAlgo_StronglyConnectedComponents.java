package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import static com.lucky.practice.DepthFirstSearch.dfsRecursive;

public class KosarajuAlgo_StronglyConnectedComponents {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdgeDirectedGraph(adj,0,1);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,1,2);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,1,3);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,2,0);
        AdjacencyListImpl.addEdgeDirectedGraph(adj,3,4);
        //System.out.println(adj);
        printStronglyConnectedComponents(adj);
        System.out.println("--------------------------------------------------------");

        vertices = 5;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i=0;i<vertices;i++){
            adj2.add(new ArrayList<Integer>());
        }
        AdjacencyListImpl.addEdgeDirectedGraph(adj2,0,1);
        AdjacencyListImpl.addEdgeDirectedGraph(adj2,1,0);
        AdjacencyListImpl.addEdgeDirectedGraph(adj2,3,4);
        AdjacencyListImpl.addEdgeDirectedGraph(adj2,4,3);
        AdjacencyListImpl.addEdgeDirectedGraph(adj2,0,2);
        AdjacencyListImpl.addEdgeDirectedGraph(adj2,3,2);
        printStronglyConnectedComponents(adj2);
    }
    public static void printStronglyConnectedComponents(ArrayList<ArrayList<Integer>> adj){
        //Step1: Creating the stack for the decreasing order of finish time from a given sources (topological sorting)
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(visited[i]==false)
                DFSRec(adj,i,visited,stack);
        }
        //Step2: Reverse all the edges
        ArrayList<ArrayList<Integer>> adjReverse = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            adjReverse.add(new ArrayList<Integer>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                adjReverse.get(adj.get(i).get(j)).add(i);
            }
        }
        //System.out.println(adjReverse);
        //step 3:
        Arrays.fill(visited,false);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(visited[curr]==false)
            {
                res.add(new ArrayList<>());
                res.get(res.size()-1).add(curr);
                collectVerticesDFSRec(adjReverse,curr,visited,res);
            }

        }
        //print the output:
        //System.out.println(res);
        System.out.println(res.stream().map(row ->
                        row.stream()
                                .map(i->i+"")
                                .collect(Collectors.joining(" ")))
                        .collect(Collectors.joining("\n")));
    }

    public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited, Stack<Integer> stack) {
        visited[source] = true;
        for(int adjacent:adj.get(source)){

            if(visited[adjacent]==false)
                DFSRec(adj,adjacent,visited,stack);
        }
        stack.push(source);
    }

    public static void collectVerticesDFSRec(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited,ArrayList<ArrayList<Integer>> res){
        visited[source]=true;
        for(int adjacent:adj.get(source)) {
            if (visited[adjacent] == false) {
                res.get(res.size()-1).add(adjacent);
                collectVerticesDFSRec(adj, adjacent, visited, res);
            }
        }
    }
}
