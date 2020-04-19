import java.util.*;

class Node{
  private int val;
  HashMap<Node, Integer> neighbors;

  public Node(int n){
    val = n; 
    neighbors = new HashMap<Node, Integer>();
  }

  public int getVal(){
    return val;
  }

  public void printNeighbors(){
    for(Node n : neighbors.keySet()){
      System.out.print("    ->" + n.getVal());
    }
    System.out.println();
  }
}
