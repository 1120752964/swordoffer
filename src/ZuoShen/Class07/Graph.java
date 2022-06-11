package ZuoShen.Class07;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashSet<Edge> edges;          //图中的边
    public HashMap<Integer,Node> nodes;  //图中的节点

    public Graph(){
        edges=new HashSet<>();
        nodes=new HashMap<>();
    }
}
