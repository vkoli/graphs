import java.util.*;

class WeightedGraph{

  HashSet<Node> vertices;

  public WeightedGraph(){
    this.vertices = new HashSet<Node>();
  }

  void addNode(int n){
    Node node = new Node(n);
    vertices.add(node);
  }

  void addWeightedEdge(Node first, Node second, int w){
    first.neighbors.put(second, w);
  }

  void removeDirectedEdge(Node first, Node second){
    first.neighbors.remove(second);
  }

  HashSet<Node> getAllNodes(){
    return vertices;
  }

}
