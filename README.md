# Graph
Implementation of a Graph represented by adjacency lists and other graph operations in Java 

Provided functionality:
-----------------------
- Graph(boolean directed) : construct a new directed or undirected Graph
- add(Vertex vertex) : add a new vertex to the graph
- addAll(Collection\<Vertices\> vertices) : adds a collection of new vertices to the graph
- edge(Vertex from,Vertex to,int weight) : add an edge between two vertices
- BFS() : explore the graph with a breadth first search (bare-bones)
- DFS() : explore the graph with a depth first search (bare-bones)
- dijkstraShortestPath(Vertex from, Vertex to) : find the shortest path between two vertices using Dijkstra's algorithm
- isEmpty() : returns true if the Graph contains no vertices

