package ZuoShen.Class07;

public class Edge {
    public int weight;  //边的权重
    public Node from;   //边的两头的节点 一个from 一个to
    public Node to;

    public Edge(int weight,Node from,Node to){
        this.weight=weight;
        this.from=from;
        this.to=to;
    }
}
