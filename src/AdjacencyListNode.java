public class AdjacencyListNode {
    private AdjacencyListNode next;
    private Vertex vertex;
    private int weight;
    public AdjacencyListNode(Vertex vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
    public Vertex getVertex(){
        return vertex;
    }
    public boolean hasNext(){
        return next != null;
    }
    public AdjacencyListNode getNext(){
        return next;
    }
    public void setNext(AdjacencyListNode adjacencyListNode){
        next = adjacencyListNode;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
