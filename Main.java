import java.util.*;

class Main {
  public static void main(String[] args) {
    Graph g = createRandomUnweightedGraphIter(6);

    DirectedGraph dg = createRandomDAGIter(1000);
    TopSort ts = new TopSort();
    ArrayList<Node> arrK = ts.Kahns(dg);
    ArrayList<Node> arrM = ts.mDFS(dg);
    
  }

  public static Graph createRandomUnweightedGraphIter(int n){
    Graph g = new Graph();

    for(int i = 0; i < n; i++){
      g.addNode(i);
    }

    for(int i = 0; i < n; i++){
      int rand = (int) (Math.random() * n);
      for(int j = 0; j < rand; j++){
        g.addUndirectedEdge(g.vertices.get(i), g.vertices.get(j));
      }
    }
    return g;
  }

  public static Graph createLinkedList(int n){
    Graph g = new Graph();
    g.addNode(0);

    for(int i = 1; i <= n; i++){
      g.addNode(i);
      g.addUndirectedEdge(g.vertices.get(i - 1), 
        g.vertices.get(i));
    }
    return g;
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

    for(int i = 0; i < n; i++){
      int rand = (int) (Math.random() * n);
      for(int j = 0; j < rand; j++){
        dg.addDirectedEdge(dg.vertices.get(i), dg.vertices.get(j));
      }
    }
    return dg;
  }

  public static WeightedGraph createRandomCompleteWeightedGraph(int n){
    WeightedGraph wg = new WeightedGraph();
    for(int i = 0; i < n; i++){
      wg.addNode(i);
    }
    for(int i = 0; i < wg.vertices.size(); i++){
      Node one = wg.vertices.get(i);
      for(int j = 0; j < wg.vertices.size(); j++){
        Node two = wg.vertices.get(j);
        int rand = (int) (Math.random() * 1001);
        if( i == j){
          continue;
        }
        wg.addWeightedEdge(one, two, rand);
      }
    }
    return wg;
  }

  public static WeightedGraph createLinkedListW(int n){
    WeightedGraph wg = new WeightedGraph();
    wg.addNode(0);
    for(int i = 1; i <= n; i++){
      wg.addNode(i);
      wg.addWeightedEdge(wg.vertices.get(i - 1), 
        wg.vertices.get(i), 1);
    }
    return wg;
  }

  public static void resetVisited(WeightedGraph wg){
    for(int i = 0; i < wg.vertices.size(); i++){
      wg.vertices.get(i).visited = false;
    }
  }

  public static HashMap<Node, Integer> dijkstras(WeightedGraph wg, Node start){
    HashMap<Node, Integer> result = new HashMap<Node, Integer>();
    resetVisited(wg);
    HashMap<Node, Integer> dist = new HashMap<Node, Integer>();

    for(int i = 0; i < wg.vertices.size(); i++){
      Node dst = wg.vertices.get(i);
      if(dst == start){
        result.put(dst, 0);
        resetVisited(wg);
        continue;
      }
      int val = dijkstrasHelper(wg, start, dst);
      result.put(dst, val);
      resetVisited(wg);
    }
    return result;
  }

  public static int dijkstrasHelper(WeightedGraph wg, Node st, Node dest){
    // initialize distance mapping
    HashMap<Node, Integer> dist = new HashMap<Node, Integer>();
    dist.put(st, 0);
    for(int i = 0; i < wg.vertices.size(); i++){
      dist.put(wg.vertices.get(i), Integer.MAX_VALUE);
    }

    // add start node's neighbors as not evaluated
    ArrayList<Node> notEval = new ArrayList<Node>();
    for(Node n : st.neighbors){
      notEval.add(n);
    }

    Node curr = st;

    while(curr != null && dist.get(curr) != Integer.MAX_VALUE){
      curr.visited = true;

      for(Node n : curr.neighbors){
        if(n.visited == false){
          Integer nodeDist = dist.get(curr) + curr.weights.get(n);
          if(nodeDist < dist.get(curr)){
            dist.replace(n, nodeDist);
          }
        }
      }
      curr = getLowestDistanceNode(dist);
    }

    return dist.get(dest).intValue();
  }

  public static Node getLowestDistanceNode(HashMap<Node, Integer> dist){
    Node tmp = null;
    Integer min = Integer.MAX_VALUE; 

    for (Node n : dist.keySet()) {
      Integer nodeDist = dist.get(n); 
      if(n.visited == false && nodeDist < min){
        min = nodeDist;
        tmp = n;
      }
    }
    return tmp;
  }

  public static GridGraph createRandomGridGraph(int n){
    GridGraph gg = new GridGraph();
    // not implemented
    return gg;
  }
}