package BFS;

/**
 * OldBfs.java
 *
 * Copyright 2020 Aiden Xie (siqixie@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

public class OldBfs {
    private int startNode;
    private HashMap<Integer, ArrayList<Integer>> graph;

    public OldBfs(int node, HashMap<Integer, ArrayList<Integer>> g){
        startNode = node;
        graph = g;
    }

    public int[] outputDistances(){
        int[] result = new int[graph.size()];
        for(int i=0; i< graph.size(); i++){
            if(i == startNode){
                result[i] = 0;
            }
            else if(graph.get(i).contains(startNode)){
                result[i] = 1;
            }
            else{
                result[i] = bfs(i);
            }
        }
        return result;
    }


    public int bfs(int starting) {
        ArrayList<Integer> toExplore = new ArrayList<>();
        toExplore.add(0, starting);

        HashMap<Integer, Integer> exploredMap = new HashMap<Integer, Integer>();
        exploredMap.put(starting, 0);
        int level=0;

        while(!toExplore.isEmpty()){
            int nodeToExplore = toExplore.get(0);
            toExplore.remove(0);
            for(int node: graph.get(nodeToExplore)){
                int lastLevel = exploredMap.get(nodeToExplore);
                if(!exploredMap.keySet().contains(node)){
                    if(node == startNode){
                        //found it
                        return lastLevel+1;
                    }
                    toExplore.add(node);
                    exploredMap.put(node, lastLevel+1);
                }
            }
        }
        return level;
    }
}
