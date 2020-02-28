package BFS;

/**
 * Bfs.java
 *
 * Copyright 2020 Aiden Xie (siqixie@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */

import java.util.*;

public class Bfs {
    private int startNode;
    private HashMap<Integer, ArrayList<Integer>> graph;

    public Bfs(int node, HashMap<Integer, ArrayList<Integer>> g){
        startNode = node;
        graph = g;
    }

    int[] distVisited;

    public int[] outputDistances(){
        distVisited = new int[graph.size()];
        Arrays.fill(distVisited, -1);
        distVisited[startNode] = 0;
        bfs();
        return distVisited;
    }

    public void bfs() {
        Queue<Integer> exploreQueue = new LinkedList<>();
        exploreQueue.add(startNode);
        while(!exploreQueue.isEmpty()){
            int nodeToExplore = exploreQueue.remove();
            ArrayList<Integer> adjList = graph.get(nodeToExplore);
            for(int i=0; i<adjList.size(); i++){
                int currentNeighbor = adjList.get(i);
                if(distVisited[currentNeighbor] == -1){
                    exploreQueue.add(currentNeighbor);
                    distVisited[currentNeighbor] = distVisited[nodeToExplore]+1;
                }
            }
        }
    }
}
