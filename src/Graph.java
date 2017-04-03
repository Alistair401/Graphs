import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean directed;
    public Graph(boolean directed){
        vertices = new ArrayList<>();
        this.directed = directed;
    }
    public void edge(Vertex from,Vertex to,int weight){
        from.connect(to,weight);
        if (!directed){
            to.connect(from, weight);
        }
    }
    public void edge(Vertex from, Vertex to){
        edge(from,to,1);
    }
    public void add(Vertex vertex){
        vertices.add(vertex);
    }
    public void addAll(Collection<Vertex> vertices){
        this.vertices.addAll(vertices);
    }
    private void visitDFS(Vertex vertex){
        vertex.setVisited(true);
        AdjacencyListNode adjacent = vertex.getAdjacencyListHead();
        if (adjacent == null) return;
        while(true){
            if (!adjacent.getVertex().isVisited()) visitDFS(adjacent.getVertex());
            if (adjacent.hasNext()) adjacent = adjacent.getNext();
            else return;
        }
    }
    public void DFS(){
        if (vertices.size() == 0) return;
        for (Vertex v : vertices) v.setVisited(false);
        for (Vertex v : vertices) if (!v.isVisited()) visitDFS(v);
    }
    private LinkedList<Vertex> visitBFS(Vertex vertex){
        LinkedList<Vertex> unvisited = new LinkedList<>();
        vertex.setVisited(true);
        AdjacencyListNode adjacent = vertex.getAdjacencyListHead();
        if (adjacent == null) return unvisited;
        if (!adjacent.getVertex().isVisited()) unvisited.add(adjacent.getVertex());
        while (adjacent.hasNext()) {
            adjacent = adjacent.getNext();
            if (!adjacent.getVertex().isVisited()) unvisited.add(adjacent.getVertex());
        }
        return unvisited;
    }
    public void BFS(){
        if (vertices.size() == 0) return;
        for (Vertex v : vertices) v.setVisited(false);
        for (Vertex v : vertices){
            if (!v.isVisited()){
                Queue<Vertex> visitQueue = new LinkedList<>();
                visitQueue.add(v);
                while(!visitQueue.isEmpty()){
                    Vertex current = visitQueue.poll();
                    Collection<Vertex> newVertices = visitBFS(current);
                    for (Vertex adjacent : newVertices) if (!visitQueue.contains(adjacent)) visitQueue.add(adjacent);
                }
            }
        }
    }
    public LinkedList<Vertex> dijkstraShortestPath(Vertex from, Vertex to){
        LinkedList<Vertex> path = new LinkedList<>();
        if (vertices.size() == 0) return path;
        for (Vertex v : vertices) {
            v.setDistance(Integer.MAX_VALUE);
            v.setVisited(false);
        }
        from.setDistance(0);
        Queue<Vertex> visitQueue = new LinkedList<>();
        visitQueue.add(from);
        while(!visitQueue.isEmpty()){
            Vertex current = visitQueue.poll();
            if (current.equals(to)){
                Vertex last = current;
                path.addFirst(current);
                while (true){
                    last = last.getPrevious();
                    path.addFirst(last);
                    if (last.equals(from)) return path;
                }
            }
            Collection<Vertex> newVertices = visitDijkstra(current);
            for (Vertex adjacent : newVertices) if (!visitQueue.contains(adjacent)) visitQueue.add(adjacent);
        }
        return path;
    }
    private LinkedList<Vertex> visitDijkstra(Vertex vertex) {
        LinkedList<Vertex> unvisited = new LinkedList<>();
        vertex.setVisited(true);
        AdjacencyListNode adjacent = vertex.getAdjacencyListHead();
        if (adjacent == null) return unvisited;
        while (true) {
            if (!adjacent.getVertex().isVisited()) unvisited.add(adjacent.getVertex());
            int tentativeWeight = vertex.getDistance() + adjacent.getWeight();
            if (tentativeWeight < adjacent.getVertex().getDistance()){
                adjacent.getVertex().setDistance(tentativeWeight);
                adjacent.getVertex().setPrevious(vertex);
            }
            if (adjacent.hasNext()) adjacent = adjacent.getNext();
            else break;
        }
        return unvisited;
    }
    public boolean isEmpty(){
        return vertices.size() == 0;
    }
}
