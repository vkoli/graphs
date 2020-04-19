import java.util.*;
import java.lang.*;

class GridNode{
  int x;
  int y;
  String val;
  HashSet<GridNode> neighbors;

  public GridNode(int n, int m, String str){
    x = n; y = m;
    val = str;
    neighbors = new HashSet<GridNode>();
  }

  public boolean isNeighbor(GridNode node){
    int x1 = node.x;
    int y1 = node.y;

    if(x1 == x){
      if(Math.abs(y1 - y) <= 1){
        return true;
      }
    }
    else if(Math.abs(x1 - x) == 1){
      if(Math.abs(y1 - y) == 0){
        return true;
      }
    }

    return false;
  }
}
