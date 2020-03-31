class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Graph g = createRandomUnweightedGraphIter(6);
  }

  public static Graph createRandomUnweightedGraphIter(int n){
    Graph g = new Graph();

    for(int i = 0; i < n; i++){
      g.addNode(i);
    }

    for(int i = 0; i < n; i++){
      int rand = (int) (Math.random() * n);
      System.out.println(rand);
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
}