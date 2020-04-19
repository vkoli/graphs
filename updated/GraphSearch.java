import java.security.Key;
import java.util.*;

class GraphSearch {

  public ArrayList<Node> DFSRec(Node start, Node end) {
    HashSet<Node> visited = new HashSet<Node>();
    ArrayList<Node> result = new ArrayList<Node>();

    return DFSRecHelper(start, end, visited, result);
  }

  private ArrayList<Node> DFSRecHelper(Node curr, Node end, HashSet<Node> visited, ArrayList<Node> result) {
    visited.add(curr);
    result.add(curr);

    if (curr.getVal() == end.getVal()) {
      return result;
    }

    for (Node n : curr.neighbors.keySet()) {
      if (visited.contains(curr) == false) {
        DFSRecHelper(n, end, visited, result);
      }
    }

    return result;
  }

  public ArrayList<Node> DFSIter(Node start, Node end) {
    Stack<Node> stack = new Stack<Node>();
    HashSet<Node> visited = new HashSet<Node>();
    ArrayList<Node> result = new ArrayList<Node>();

    stack.push(start);

    while (stack.empty() == false) {
      Node curr = stack.pop();
      result.add(curr);

      if (visited.contains(curr) == false) {
        visited.add(curr);
        if (curr == end) {
          break;
        }

        for (Node n : curr.neighbors.keySet()) {
          if (visited.contains(curr) == false) {
            stack.push(n);
          }
        }
      }
    }

    return result;
  }

  public ArrayList<Node> BFTRec(Graph graph) {
    Queue<Node> queue = new LinkedList<Node>();
    HashSet<Node> visited = new HashSet<Node>();
    ArrayList<Node> result = new ArrayList<Node>();

    Iterator it = graph.vertices.iterator();
    Node n = (Node)it.next();

    visited.add(n);
    queue.add(n);
    result.add(n);

    result = BFTRecHelper(queue, visited, result);

    if(visited.size() != result.size()){
      while(it.hasNext()){
        n = (Node)it.next();
        if(result.contains(n) == false){
          result.add(n);
        }
      }
    }

    return result;
  }

  private ArrayList<Node> BFTRecHelper(Queue<Node> queue, HashSet<Node> visited, ArrayList<Node> result) {
    if (queue.isEmpty()) {
      return result;
    }

    Node curr = queue.remove();
    visited.add(curr);
    result.add(curr);

    for (Node n : curr.neighbors.keySet()) {
      if (visited.contains(n) == false) {
        visited.add(n);
        queue.add(n);
      }
    }

    return BFTRecHelper(queue, visited, result);
  }

  public ArrayList<Node> BFTIter(Graph graph) {
    Queue<Node> queue = new LinkedList<Node>();
    HashSet<Node> visited = new HashSet<Node>();
    ArrayList<Node> result = new ArrayList<Node>();

    for (Node n : graph.vertices) {
      if (visited.contains(n) == false) {
        visited.add(n);
        queue.add(n);

        while (queue.size() > 0) {
          Node curr = queue.remove();
          result.add(curr);

          for (Node currN : curr.neighbors.keySet()) {
            if (visited.contains(currN) == false) {
              visited.add(currN);
              queue.add(currN);
            }
          }
        }
      }

      if (visited.size() != result.size()) {
        result.add(n);
      }
    }

    return result;
  }

}