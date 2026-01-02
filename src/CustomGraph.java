import java.util.List;
import java.util.Vector;

public class CustomGraph {

    static class Vertex<T> {
        private T data;
        private List<Edge> edges;

        public Vertex(T data) {
            this.data = data;
            this.edges = new Vector<>();
        }
    }

    static class Edge {

    }
}
