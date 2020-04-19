import java.util.*;

class GridGraph{
  HashSet<GridNode> points;

  public GridGraph(){
    points = new HashSet<GridNode>();
  }

  public void addGridNode(int x, int y, String nodeVal){
    GridNode tmp = new GridNode(x, y, nodeVal);
    points.add(tmp);
  }

  public void addUndirectedEdge(GridNode first, GridNode second){
    boolean isN = first.isNeighbor(second);
    if(first.neighbors.size() != 4 && second.neighbors.size() != 4){
      if(isN){
        first.neighbors.add(second);
        second.neighbors.add(first);
      }
    }
  }
  
  public void removeUndirectedEdge(GridNode first, GridNode second){
    boolean isN = first.isNeighbor(second);
    if(isN){
      first.neighbors.remove(second);
      second.neighbors.remove(first);
    }
  }
  
  HashSet<GridNode> getAllNodes(){
    return points;
  }
}
