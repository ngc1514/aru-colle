package Weighted_ShortestPath;

import java.util.*;

/**
 * Shortest.java
 *
 * Copyright 2020 Aiden Xie (siqixie@buffalo.edu)
 **
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */

public class Shortest {
    
    private int _startNode;
    private int _endNode;
    private HashMap<Integer, ArrayList<Integer>> graph;

    public Shortest(int startNode, int endNode, HashMap<Integer, ArrayList<Integer>> g){
        _startNode = startNode;
        _endNode = endNode;
        graph = g;
    }

    public ArrayList<Integer> outputPath(){
        if(_startNode == _endNode)
            return new ArrayList<>();

        int[] disArr = new int[graph.size()];
        Arrays.fill(disArr, -1);
        int[] lastVisit = new int[graph.size()];
        Arrays.fill(lastVisit, -1);

        PriorityQueue<myPair> toBeExploredQueue = new PriorityQueue<>(Comparator.comparingInt(myPair::getDistance));
        ArrayList<Integer> result = new ArrayList<>();

        // initialization
        int curNode = _endNode; //_startNode; //NOTE: Optimization, start from end
        int startWeight = graph.get(curNode).get(0);
        disArr[curNode] = startWeight;
        toBeExploredQueue.add(new myPair(curNode, startWeight));

        outerloop:
        while(!toBeExploredQueue.isEmpty())
        {
            for(int i=1, size = graph.get(curNode).size(); i < size; i++)
            {
                int adjNode = graph.get(curNode).get(i);
                if(disArr[adjNode] == -1){ // -1 means never visited before
                    lastVisit[adjNode] = curNode; // save last visited node
                    if(adjNode == _startNode) //_endNode) // NOTE: Optimization
                        break outerloop;
                    int curDistance = disArr[curNode];
                    int nextNodeWeight = graph.get(adjNode).get(0);
                    toBeExploredQueue.add(new myPair(adjNode, curDistance + nextNodeWeight));
                    disArr[adjNode] = curDistance + nextNodeWeight;
                }
            }
            // update current node to the next smallest weight one
            curNode = toBeExploredQueue.poll().getID();
        }

        // if last is -1, reaches the end
        // if endNode's last visit == -1, then we've never visited it, it's disconnected
        int tempLast = lastVisit[_startNode]; //_endNode]; // NOTE: Optimization, reversed
        if(tempLast != -1){
            result.add(_startNode); //_endNode); // NOTE: Optimization, reversed
        }
        while(tempLast != -1){
            result.add(tempLast);
            tempLast = lastVisit[tempLast];
        }
        //NOTE: Optimization, no reverse, slightly faster
        //Collections.reverse(result);

        return result;
    }

    // NOTE: (K,V), K = index, V = distance to last node
    static class myPair<I extends Number, T extends Number> {
        final int id;
        final int distance;
        myPair(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
        public int getID(){
            return this.id;
        }
        public int getDistance(){
            return this.distance;
        }
    }
}

