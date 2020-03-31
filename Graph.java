import java.util.*;

class Node{
  int val;
  List<Node> neighbors;
  boolean visited;

  public Node(int n){
    val = n;
    this.neighbors = new ArrayList<Node>();
    visited = false;
  }

  public void setVisited() {
    visited = true;
  }

  public boolean getVisited() {
    return visited;
  }
}


class Graph{
  List<Node> vertices;
  
  public Graph(){
    this.vertices = new ArrayList();
  }

  void addNode(int n){
    Node node = new Node(n);
    vertices.add(node);
  }

  void addUndirectedEdge(Node first, Node second){
    first.neighbors.add(second);
    second.neighbors.add(first);
  } 

  void removeUndirectedEdge(Node first, Node second){
    first.neighbors.remove(second);
    second.neighbors.remove(first);
  } 

  HashSet<Node> getAllNodes(){
    HashSet<Node> lst = new HashSet();

    for(int i = 0; i < vertices.size(); i++){
      lst.add(vertices.get(i));
    }

    return lst;
  }
}