import java.util.*;

class WeightedGraph{

  List<Node> vertices;
  
  public WeightedGraph(){
    this.vertices = new ArrayList();
  }

  void addNode(int n){
    Node node = new Node(n);
    vertices.add(node);
  }

  void addWeightedEdge(Node first, Node second, int w){
    first.neighbors.add(second);
    first.weights.put(second, w);
  }

  void removeDirectedEdge(Node first, Node second){
    first.neighbors.remove(second);
    first.weights.remove(second);
  }

  HashSet<Node> getAllNodes(){
    HashSet<Node> lst = new HashSet();
    for(int i = 0; i < vertices.size(); i++){
      lst.add(vertices.get(i));
    }
    return lst;
  }

}



