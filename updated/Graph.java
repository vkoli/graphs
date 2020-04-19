import java.util.*;

class Graph{
  HashSet<Node> vertices;

  public Graph(){
    vertices = new HashSet<Node>();
  }

  void addNode(int n){
    Node node = new Node(n);
    vertices.add(node);
  }

  void addUndirectedEdge(Node first, Node second){
    first.neighbors.put(second, 0);
    second.neighbors.put(first, 0);
  } 

  void removeUndirectedEdge(Node first, Node second){
    first.neighbors.remove(second);
    second.neighbors.remove(first);
  } 

  HashSet<Node> getAllNodes(){
    return vertices;
  }

  void printGraph(){
    for(Node n : vertices){
      System.out.println("-->" + n.getVal());
      n.printNeighbors();
    }
    System.out.println();
  }
}
