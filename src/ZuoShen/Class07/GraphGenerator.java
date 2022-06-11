package ZuoShen.Class07;

public class GraphGenerator {
    //以二维数组形式存储的图    其中的一维数组有三项  边的权重 入度 出度
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (Integer[] integers : matrix) {
            Integer weight = integers[0];
            Integer from = integers[1];
            Integer to = integers[2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
