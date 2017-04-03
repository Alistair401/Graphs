import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(false);
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");
        Vertex<String> e = new Vertex<>("e");
        Vertex<String> f = new Vertex<>("f");
        g.addAll(Arrays.asList(a,b,c,d,e,f));
        g.edge(a,b,20);
        g.edge(b,c,2);
        g.edge(a,f,3);
        g.edge(a,e,4);
        g.edge(a,d,5);
        g.edge(d,e,6);
        g.edge(e,f,7);
        g.edge(b,f,8);
        g.edge(e,b,100);
        for (Vertex v : g.dijkstraShortestPath(d,c)) {
            System.out.println(v.getContent());
        }
    }
}
