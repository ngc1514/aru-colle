# Aru-colle
My shitcode algo collection from Data Structure and Algorithms and Complexity.

# Collection:
1. Improved BFS (20 times faster than my 250 old BFS. Not formally analyzed. Based on Autograder's runtime)
<p align="center">
  <img width="300" height="300" src="https://raw.githubusercontent.com/Shesky17/shesky17.github.io/master/static/host_files/bfs.png">
</p>

## Input
```
2             <- Starting node
1 2           <- Node 0 shares edges with nodes 1 & 2
0 3           <- Node 1 shares edges with nodes 0 & 3
0 3 4 5	      <- Node 2 shares edges with nodes 0, 3, 4 & 5
1 2 6 7       <- Node 3 shares edges with nodes 1, 2, 6 & 7
2             <- Node 4 shares edges with node 2
2             <- Node 5 shares an edge with node 2
3 8           <- Node 6 shares an edge with nodes 3 & 8
3 8           <- Node 7 shares edges with nodes 3 & 8
6 7           <- Node 8 shares edges with nodes 6 & 7
```
## Output
```
[1, 2, 0, 1, 1, 1, 2, 2, 3]     <- Node 0 is distance 1 from node 2
                                   Node 1 is distance 2 from node 2
                                   Node 2 is distance 0 from itself 
                                   Node 3 is distance 1 from node 2 
                                   Node 4 is distance 1 from node 2
                                   Node 5 is distance 1 from node 2
                                   Node 6 is distance 2 from node 2
                                   Node 7 is distance 2 from node 2
                                   Node 8 is distance 3 from node 2
```
