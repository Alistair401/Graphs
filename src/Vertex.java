public class Vertex<T> {
    private AdjacencyListNode adjacencyListHead;
    private AdjacencyListNode adjacencyListTail;
    private T content;
    private boolean visited;
    private int distance;
    private Vertex previous;
    public Vertex(T object){
        content = object;
    }
    public void connect(Vertex vertex, int weight){
        AdjacencyListNode adjacencyListNode = new AdjacencyListNode(vertex,weight);
        if (adjacencyListTail == null){
            adjacencyListHead = adjacencyListNode;
            adjacencyListTail = adjacencyListNode;
        }
        else {
            adjacencyListTail.setNext(adjacencyListNode);
            adjacencyListTail = adjacencyListNode;
        }
    }
    public T getContent(){
        return content;
    }
    public AdjacencyListNode getAdjacencyListHead(){
        return adjacencyListHead;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public Vertex getPrevious() {
        return previous;
    }
    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }
}
