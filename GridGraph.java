import java.util.*;
import java.lang.*;

class GridNode{
  int x, y;
  String val;
  List<GridNode> neighbors;
  boolean visited;

  public GridNode(int n, int m, String str){
    x = n;
    y = m;
    val = str;
    this.neighbors = new ArrayList<GridNode>();
    visited = false;
  }

  public boolean isNeighbor(GridNode n){
    int x1 = n.x;
    int y1 = n.y;
    if( x1 == x ){
      if( (Math.abs(y1 - y) == 1) || (Math.abs(y1 - y) == 0)){
        return true;
      }
      return false;
    }
    else if ((Math.abs(x1 - x) == 1)){
      if( (Math.abs(y1 - y) == 0) ){
        return true;
      }
      return false;
    }
    return false;
  }
}

class GridGraph{
  ArrayList<GridNode> points;

  public GridGraph(){
    super();
    points = new ArrayList<GridNode>();
  }
  
  public void addGridNode(int x, int y, String nodeVal){
    GridNode tmp = new GridNode(x, y, nodeVal);
    points.add(tmp);
  }

  public void addUndirectedEdge(GridNode first, GridNode second){
    boolean isN = first.isNeighbor(second);
    if(isN){
      first.neighbors.add(second);
      second.neighbors.add(first);
    }
  }
  
  public void removeUndirectedEdge(GridNode first, GridNode second){
    boolean isN = first.isNeighbor(second);
    if(isN){
      first.neighbors.add(second);
      second.neighbors.add(first);
    }
  }
  
  HashSet<GridNode> getAllNodes(){
    HashSet<GridNode> lst = new HashSet();
    for(int i = 0; i < points.size(); i++){
      lst.add(points.get(i));
    }
    return lst;
  }
}