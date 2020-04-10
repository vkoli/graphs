import java.util.*;

class TopSort extends DirectedGraph{
  public TopSort(){
    super();
  }
  
  public ArrayList<Node> Kahns(DirectedGraph dg){
    HashMap<Node, Integer> inDegree = initializeInDegreeMap(dg);ArrayList<Node> topSort = new ArrayList<Node>();
    Deque queue = new ArrayDeque();

    addNodesWithoutDependenciesToQueue(inDegree, queue);

    while (!queue.isEmpty()) {
      Node curr = (Node) queue.pop();
      topSort.add(curr);
      for (Node n : curr.neighbors) {
        inDegree.replace(n, inDegree.get(n) - 1);
      }
      addNodesWithoutDependenciesToQueue(inDegree, queue);
    }
    return topSort;
  }

  private HashMap<Node, Integer> initializeInDegreeMap(DirectedGraph g) {
    HashMap<Node, Integer> deg = new HashMap<Node, Integer>(); 
    for (Node node : g.vertices) {
      deg.put(node, 0);
    }
    for (Node node : g.vertices) {
      for (Node n : node.neighbors) {
        deg.replace(n, deg.get(n) + 1);
      }
    }
    return deg;
  }

  private void addNodesWithoutDependenciesToQueue(
      HashMap<Node, Integer> inDegree, Deque queue) {
    for (Node curr : inDegree.keySet()) {
      if (inDegree.get(curr) == 0) {
        queue.add(curr);
        inDegree.replace(curr, inDegree.get(curr) - 1);
      }
    }
  }

  public ArrayList<Node> mDFS(DirectedGraph dg){
    Stack<Node> stack = new Stack<Node>();
    int numNodes = dg.vertices.size();

    for (Node node : dg.vertices) {
      if (node.visited == false) {
        mDFSHelper(node, stack);
      }
    }

    ArrayList<Node> path = new ArrayList<Node>();
    while (!stack.empty()) {
      Node currNode = (Node) stack.pop();
      path.add(currNode);
    }
    return path;
  }

  private void mDFSHelper(Node node, Stack stack) {
    node.visited = true;
    for (Node n : node.neighbors) {
      if (n.visited == false) {
        mDFSHelper(n, stack);
      }
    }
    stack.push(node);
  }
}