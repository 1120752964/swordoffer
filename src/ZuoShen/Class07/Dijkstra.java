package ZuoShen.Class07;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class Dijkstra {
    //dijkstra返回值为当前节点与头结点到当前节点的距离
    public static HashMap<Node,Integer> dijkstra(Node head){
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        //先将头放进去  未放入的视为无穷大小
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();
        //找到当前该更新的节点（锁定）
        Node minNode =  getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode!=null){
            int distance = distanceMap.get(minNode);
            for (Edge edge:minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance+edge.weight);
                }else {
                    distanceMap.put(toNode,Math.min(distance+edge.weight,distanceMap.get(toNode)));
                }
            }
            selectedNodes.add(minNode);
            minNode =  getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }
    //找到不在路径中，并且距离最短的节点  就是更新完路径距离最近的节点后更新第二近第三近的
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node,Integer> distanceMap,HashSet<Node> touchedNodes){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for(Map.Entry<Node,Integer> entry:distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!touchedNodes.contains(node) && distance<minDistance){
                minNode=node;
                minDistance=distance;
            }
        }
        return minNode;
    }
}
