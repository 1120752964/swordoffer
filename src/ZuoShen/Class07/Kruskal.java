package ZuoShen.Class07;

import java.util.*;

public class Kruskal {
    //可以用并查集优化！！！
    //把所有元素依次生成一个Arraylist对应
    HashMap<Node,ArrayList<Node>> map = new HashMap<>();
    public  List<Edge> kruskal(Graph graph){
        //Kruskal的结果，加入result中
        ArrayList<Edge> result = new ArrayList<>();
        PriorityQueue<Edge> edgeweight = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        for (Edge edge:graph.edges){  //M条边
            edgeweight.add(edge);   //O(logM)
            //因为是无向图，因此直接放入所有from就是所有节点。
            ArrayList<Node> temp = new ArrayList<>();
            temp.add(edge.from);
            map.put(edge.from,temp);
        }
        while (!edgeweight.isEmpty()){//M条边
            Edge edge = edgeweight.poll();//O(logM)
            if(!judgeLoop(edge.from,edge.to)){
                union(edge.from,edge.to);
//                result.add(edge.from);//最小生成树用点表示可能会重复
//                result.add(edge.to);//因此选择用边去表示
                result.add(edge);
            }
        }
        return result;
    }
    public  boolean judgeLoop(Node from,Node to){
        return map.get(from)==map.get(to);//如果相等，说明这俩集合一样，会成环
    }
    public void union(Node from,Node to){
        ArrayList<Node> fromList = map.get(from);
        ArrayList<Node> toList = map.get(to);
        //这里的左神版本for循环里面写的put，有点奇怪  是我效率低了吗？？？
        fromList.addAll(toList);
        map.put(to,fromList);
        map.put(from,fromList);
    }
}
