package ZuoShen.Class07;

import java.util.*;

public class TopologySort {
    //directed graph and no loop
    public static List<Node> topologysort(Graph graph){
        //Node 代表节点  Integer代表该节点的入度
        HashMap<Node,Integer> inMap = new HashMap<>();
        //zeroNodes 是入度为0的节点的队列
        Queue<Node> zeroNodes = new LinkedList<>();
        for(Node node:graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in==0){
                zeroNodes.add(node);
            }
        }
        //拓扑排序的结果，一次加入result中
        ArrayList<Node> result = new ArrayList<>();
        while (!zeroNodes.isEmpty()){
            Node cur = zeroNodes.poll();
            result.add(cur);
            for (Node a:cur.nexts){
//                a.in--;  不是节点去--而是inMap中的入度要--
                inMap.put(a,inMap.get(a)-1);//相同的key会替换掉之前的
                if(a.in==0){
                    zeroNodes.add(a);
                }
            }
        }
        return result;
    }

}
