package DfsCycle;

import java.util.*;

/**
 * Floyd.java
 *
 * Reference: https://www.youtube.com/watch?v=pKO9UjSeLew
 *
 * Copyright 2020 Aiden Xie (siqixie@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */

public class DfsCycle {

    private HashMap<Integer, ArrayList<Integer>> graph;
    boolean[] visited;
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<Integer> cleanPath;
    int storedStarting;

    public DfsCycle(HashMap<Integer, ArrayList<Integer>> graph) {
        this.graph = graph;
    }

    public ArrayList<Integer> findCycle() {
        visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        for (int i = 0, size = graph.size(); i < size; ++i) {
            if (!visited[i]){
                if (dfs(i, -1)) {
                    //NOTE: if found, return path
                    //System.out.println("cycle starts at: " + storedStarting);
                    break;
                }
            }
        }
        int indexOfStored = path.indexOf(storedStarting);
        Integer[] cleaned = Arrays.copyOfRange(path.toArray(new Integer[indexOfStored + 1]), 0, indexOfStored+1);
        cleanPath = new ArrayList<>(Arrays.asList(cleaned));
        return cleanPath;
    }

    //NOTE: DFS reference KT Algorithm Design textbook page 84 DFS pseudo-code
    public boolean dfs(int currentNode, int startingParent){
        visited[currentNode] = true; //NOTE: initialize 0 as first
        ArrayList<Integer> adjList = graph.get(currentNode);
        for(int i=0, len = adjList.size(); i<len; ++i) //optimized
        {
            int currentNeighbor = adjList.get(i);
            if(!visited[currentNeighbor]){ //NOTE: if never visited, do it
                if(dfs(currentNeighbor, currentNode)){ //NOTE: recursive call dfs
                    path.add(currentNode);
                    return true; //true then keep going
                }
            }
            //NOTE: p=3 but 0 visited, cycle
            else if(currentNeighbor != startingParent){
                storedStarting = currentNeighbor;
                path.add(currentNode);
                return true; //NOTE: stop the whole thing when find a cycle
            }
        }
        return false; //NOTE: false find another path or not just end the whole shit
    }


}
