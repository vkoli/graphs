import java.util.*;

class Node{
  int val;
  ArrayList<Node> neighbors;
  HashMap<Node, Integer> weights;
  boolean visited;

  public Node(int n){
    val = n;
    this.neighbors = new ArrayList<Node>();
    this.weights = new HashMap<Node, Integer>();
    visited = false;
  }
}