package ZuoShen.Class07;
import java.util.*;
public class Prim {
    public ArrayList<Edge> prim(Graph graph){
        ArrayList<Edge> result = new ArrayList<>();
        //如果被放入最小生成树中 就加入该节点
        HashSet<Node> selectedNode = new HashSet<>();
        PriorityQueue<Edge> edgeweight = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        for(Node node:graph.nodes.values()){
            //先找到一个节点   解锁它的所有边
            if(!selectedNode.contains(node)){
                //将第一个节点放入图中
                selectedNode.add(node);
                for(Edge edge:node.edges){
                    edgeweight.add(edge);
                }
                //取出当前最小的边
                Edge cur = edgeweight.poll();
                Node toNode = cur.to;
                //如果这个边的节点已经在树中，则不去进行操作
                //主要是因为边会重复放入，但不会进入下面的if
                if(!selectedNode.contains(toNode)){
                    selectedNode.add(toNode);
                    result.add(cur);
                    //然后将这个节点的所有边放入小根堆中
                    for (Edge edge:toNode.edges){
                        edgeweight.add(edge);
                    }
                }
            }
        }
        return result;
    }
}
