import java.util.*;

class DirectedGraph{
  HashSet<Node> vertices;

  public DirectedGraph(){
    this.vertices = new HashSet<Node>();
  }

  void addNode(int n){
    Node node = new Node(n);
    vertices.add(node);
  }

  void addDirectedEdge(Node first, Node second){
    first.neighbors.put(second, 0);
  } 

  void removeDirectedEdge(Node first, Node second){
    first.neighbors.remove(second);
  } 

  HashSet<Node> getAllNodes(){
    return vertices;
  }
}
