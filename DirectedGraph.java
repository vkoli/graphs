import java.util.*;

class DirectedGraph{
  List<Node> vertices;
  
  public DirectedGraph(){
    this.vertices = new ArrayList();
  }

  void addNode(int n){
    Node node = new Node(n);
    vertices.add(node);
  }

  void addDirectedEdge(Node first, Node second){
    first.neighbors.add(second);
  } 

  void removeDirectedEdge(Node first, Node second){
    first.neighbors.remove(second);
  } 

  HashSet<Node> getAllNodes(){
    HashSet<Node> lst = new HashSet();
    for(int i = 0; i < vertices.size(); i++){
      lst.add(vertices.get(i));
    }
    return lst;
  }
}