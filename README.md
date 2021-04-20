# Aru-colle
My algo collection <br>

# Collection:
## 1. Improved BFS
<p align="center">
  <img width="300" height="300" src="https://raw.githubusercontent.com/Shesky17/shesky17.github.io/master/static/host_files/bfs.png">
</p>

### Input
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
### Output
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

## 2. Floyd's tortoise and hare - Cycle Detection

### Reference
- <a href="https://en.wikipedia.org/wiki/Cycle_detection"> https://en.wikipedia.org/wiki/Cycle_detection </a>


## 3. DFS Cycle Detection
<p align="center">
  <img width="300" height="300" src="https://raw.githubusercontent.com/Shesky17/shesky17.github.io/master/static/host_files/bfs.png">
</p>

### Input
```
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
### Output
```
[0, 1, 3, 2]  <- Node 0 shares an edge with 1 & 2
              <- Node 1 shares an edge with 0 & 3
              <- Node 3 shares an edge with 1 & 2
              <- Node 2 shares an edge with 3 & 0
```

## 4. Shortest path in weighted (node) graph 

### Input
Inputs are in adj-list format <br/>
Leading num: node's weight <br/>
The rest are adj nodes <br/>

```
s                 <- Starting node (some node between u0 and un-1).
e                 <- Ending node (some node between u0 and un-1).0 3 4 5	      
w0 u1 u4 u6       <- All nodes that share edges with u0
w1 u3 uu          <- All nodes that share edges with u1
.
.
.
wn-1 u0 u4 u2 u7  <- All nodes that share edges with un-1
```
### Output
```
[s, n0 n1 n2... nm, e]  <- Each entry is a node on the shortest path between 's' and 'e'
```


