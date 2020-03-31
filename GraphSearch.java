import java.util.*;

class GraphSearch extends Graph{
  public GraphSearch(){
    super();
  }

  ArrayList<Node> DFSRec(Graph g, Node start, Node end){
    for(int i = 0; i < g.vertices.size(); i++){
      g.vertices.get(i).visited = false;
    }

    int st = g.vertices.indexOf(start);
    ArrayList<Node> lst = new ArrayList<Node>();
    lst = DFSRecHelper(g, st, end.val, lst);

    return lst;
  }

  ArrayList<Node> DFSRecHelper(Graph g, int pos, int search, ArrayList<Node> arr){
    g.vertices.get(pos).visited = true;
    arr.add(g.vertices.get(pos));

    if(g.vertices.get(pos).val == search){
      return arr;
    }

    for(Node n: g.vertices.get(pos).neighbors){
      int index = g.vertices.indexOf(n);
      if(n.visited == false){
        DFSRecHelper(g, index, search, arr);
      }
    }

    return null;
  }

  ArrayList<Node> DFSIter(Graph g, Node start, Node end){
    Stack s = new Stack();
    ArrayList<Node> path = new ArrayList<Node>();
    for(int i = 0; i < g.vertices.size(); i++){
      if(g.vertices.get(i).visited == true){
        g.vertices.get(i).visited = false;
      }
    }

    int st = path.indexOf(start);

    for (int i = st; i < g.vertices.size(); i++) {
      if (g.vertices.get(i).visited == false) {
        g.vertices.get(i).visited = true;
        s.push(g.vertices.get(i));

        while (s.size() > 0) {
          Node newCurr = (Node) s.pop();
          path.add(newCurr);

          if (newCurr.val == end.val) {
            System.out.println("Path has been found!");
            return path;
          }

          for (Node vi: g.vertices.get(i).neighbors){
            int index = g.vertices.indexOf(vi);
            if (!g.vertices.get(index).visited) {
              g.vertices.get(index).visited = true;
              s.push(vi);
            }
          }
        }
      }
    }
    return null;
  }

  ArrayList<Node> BFTRec(Graph graph){
    for(int i = 0; i < graph.vertices.size(); i++){
      graph.vertices.get(i).visited = false;
    }

    Queue<Node> q = new LinkedList<Node>();
    q.add(graph.vertices.get(0));
    ArrayList<Node> lst = new ArrayList<Node>();
    lst = BFTRecHelper(graph, q, lst);

    for(int i = 0; i < graph.vertices.size(); i++){
      if(graph.vertices.get(i).visited == false){
        lst.add(graph.vertices.get(i));
      }
    }

    return lst;
  }

  ArrayList<Node> BFTRecHelper(Graph g, Queue<Node> q,ArrayList<Node> arr){

    if(q.isEmpty()){
      return arr;
    }
    Node n = q.remove();
    n.visited = true;
    arr.add(n);

    for(Node u: n.neighbors){
      if(u.visited == false){
        u.visited = true;
        q.add(u);
      }
    }
    
    return BFTRecHelper(g, q, arr);
  }

  ArrayList<Node> BFTIter(Graph graph){
    Queue<Node> q = new LinkedList<Node>();
    ArrayList<Node> result = new ArrayList<Node>();

    for (int i = 0; i < graph.vertices.size(); i++) {
      graph.vertices.get(i).visited = false;
    }

    graph.vertices.get(0).visited = true;
    q.add(graph.vertices.get(0));

    while(q.size() > 0){
      Node newCurr = q.remove();
      result.add(newCurr);

      for(Node n: graph.vertices.get(graph.vertices.indexOf(newCurr)).neighbors){
        if(n.visited == false){
          n.visited = true;
          q.add(n);
        }
      }
    }

    return result;
  }
}