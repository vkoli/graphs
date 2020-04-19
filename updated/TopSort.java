import java.util.*;

class TopSort extends DirectedGraph{

  public TopSort(){
    super();
  }
  
  public ArrayList<Node> Kahns(DirectedGraph dg){
    HashMap<Node, Integer> inDegree = initializeInDegreeMap(dg);
    ArrayList<Node> path = new ArrayList<Node>();
    Deque queue = new ArrayDeque();

    addNodesWithoutDependenciesToQueue(inDegree, queue);

    while (!queue.isEmpty()) {
      Node curr = (Node) queue.pop();
      path.add(curr);
      for (Node n : curr.neighbors.keySet()) {
        inDegree.replace(n, inDegree.get(n) - 1);
      }
      addNodesWithoutDependenciesToQueue(inDegree, queue);
    }
    return path;
  }

  private HashMap<Node, Integer> initializeInDegreeMap(DirectedGraph dg) {
    HashMap<Node, Integer> deg = new HashMap<Node, Integer>(); 
    for (Node node : dg.vertices) {
      deg.put(node, 0);
    }

    for (Node node : dg.vertices) {
      for (Node neighbor : node.neighbors.keySet()) {
        deg.replace(neighbor, deg.get(neighbor) + 1);
      }
    }
    return deg;
  }

  private void addNodesWithoutDependenciesToQueue(HashMap<Node, Integer> inDegree, Deque queue) {
    for (Node curr : inDegree.keySet()) {
      if (inDegree.get(curr) == 0) {
        queue.add(curr);
        inDegree.replace(curr, inDegree.get(curr) - 1);
      }
    }
  }
  

  public ArrayList<Node> mDFS(DirectedGraph dg){
    Stack<Node> stack = new Stack<Node>();
    HashSet<Node> visited = new HashSet<Node>();

    for (Node node : dg.vertices) {
      if (visited.contains(node) == false) {
        mDFSHelper(node, stack, visited);
      }
    }

    ArrayList<Node> path = new ArrayList<Node>();
    while (!stack.empty()) {
      Node currNode = (Node) stack.pop();
      path.add(currNode);
    }
    return path;
  }

  private void mDFSHelper(Node curr, Stack stack, HashSet<Node> visited) {
    visited.add(curr);
    for (Node n : curr.neighbors.keySet()) {
      if (visited.contains(n) == false) {
        mDFSHelper(n, stack, visited);
      }
    }
    stack.push(curr);
  }
}
