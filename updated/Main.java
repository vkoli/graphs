import java.util.*;

class Main {
  public static void main(String[] args) {
    Graph temp = createLinkedList(5);
    temp.printGraph();

    DirectedGraph dg = createRandomDAGIter(1000);
    TopSort ts = new TopSort();
    ArrayList<Node> arrK = ts.Kahns(dg);
    ArrayList<Node> arrM = ts.mDFS(dg);
  }

  public static Graph createRandomUnweightedGraphIter(int n){
    Graph graph = new Graph();

    for(int i = 0; i < n; i++){
      graph.addNode(i);
    }

    int i = 0;
    for(Node n1 : graph.vertices){
      int count = (int) (Math.random() * n);
      for(Node n2 : graph.vertices){
        if(n1 == n2){
          i++;
          continue;
        }
        if(i == count){
          i = 0;
          break;
        }
        graph.addUndirectedEdge(n1, n2);
        i++;
      }
    }

    return graph;
  }

  public static Graph createLinkedList(int n){
    Graph graph = new Graph();
    
    for(int i = 0; i < n; i++){
      graph.addNode(i);
    }

    Iterator it = graph.vertices.iterator();
    
    Node curr = null;
    while(it.hasNext()){
      Node next = (Node)it.next();
      if(curr != null){
        graph.addUndirectedEdge(curr, next);
        curr = next; 
      }
      else{
        curr = next;
      }
    }
    return graph;
  }

  public static ArrayList<Node> BFTRecLinkedList(int n){
      GraphSearch g = new GraphSearch();
      Graph tmp = createLinkedList(n);
      return g.BFTRec(tmp);
  }

  public static ArrayList<Node> BFTIterLinkedList(int n){
      GraphSearch g = new GraphSearch();
      Graph tmp = createLinkedList(n);
      return g.BFTIter(tmp);
  }

  public static DirectedGraph createRandomDAGIter(int n){
    DirectedGraph dg = new DirectedGraph();

    for(int i = 0; i < n; i++){
      dg.addNode(i);
    }

    int i = 0;
    for(Node n1 : dg.vertices){
      int count = (int) (Math.random() * n);
      for(Node n2 : dg.vertices){
        if(n1.getVal() == n2.getVal()){
          i++;
          continue;
        }

        if(i == count){
          i = 0;
          break;
        }
        
        i++;
        dg.addDirectedEdge(n1, n2);
      }
    }
    return dg;
  }

  public static WeightedGraph createRandomCompleteWeightedGraph(int n){
    WeightedGraph wg = new WeightedGraph();
    for(int i = 0; i < n; i++){
      wg.addNode(i);
    }

    for(Node n1 : wg.vertices){
      for(Node n2 : wg.vertices){
        if(n1 == n2){
          continue;
        }
        int randWeight = (int) (Math.random() * 1001);
        wg.addWeightedEdge(n1, n2, randWeight);
      }
    }

    return wg;
  }

  public static WeightedGraph createLinkedListW(int n){
    WeightedGraph wg = new WeightedGraph();

    for(int i = 0; i < n; i++){
      wg.addNode(i);
    }

    Iterator it = wg.vertices.iterator();
    
    Node curr = null;
    while(it.hasNext()){
      Node next = (Node)it.next();
      if(curr != null){
        int randWeight = (int) (Math.random() * 1001);
        wg.addWeightedEdge(curr, next, randWeight);
        curr = next; 
      }
      else{
        curr = next;
      }
    }
    return wg;
  }

  // finds the minimum distance or all Nodes in the Weighted Graph 
  // to the start Node
  public static HashMap<Node, Integer> dijkstras(WeightedGraph wg, Node start){
    HashMap<Node, Integer> result = new HashMap<Node, Integer>();

    for(Node vertex : wg.vertices){
      if(vertex == start){
        result.put(vertex, 0);
        continue;
      }
      int val = dijkstrasHelper(wg, start, vertex);
      result.put(vertex, val);
    }

    return result;
  }

  public static int dijkstrasHelper(WeightedGraph wg, Node start, Node end){
    HashSet<Node> visited = new HashSet<Node>();
    HashMap<Node, Integer> distance = new HashMap<Node, Integer>();
    for(Node n : wg.vertices){
      distance.put(n, Integer.MAX_VALUE);
    }

    Node curr = start;

    while(curr != null && distance.get(curr) != Integer.MAX_VALUE){
      visited.add(curr);
      for(Node n : curr.neighbors.keySet()){
        if(visited.contains(n) == false){
          Integer nodeDist = distance.get(curr) + curr.neighbors.get(n);
          if(nodeDist < distance.get(curr)){
            distance.replace(n, nodeDist);
          }
        }
      }
      curr = getLowestDistanceNode(distance, visited);
    }

    return distance.get(end).intValue();
  }

  public static Node getLowestDistanceNode(HashMap<Node, Integer> dist, HashSet<Node> visited){
    Node tmp = null;
    Integer min = Integer.MAX_VALUE; 

    for (Node n : dist.keySet()) {
      Integer nodeDist = dist.get(n); 
      if(visited.contains(n) == false && nodeDist < min){
        min = nodeDist;
        tmp = n;
      }
    }
    return tmp;
  }
}
