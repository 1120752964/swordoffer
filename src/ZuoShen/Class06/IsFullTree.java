package ZuoShen.Class06;

public class IsFullTree {
    public static class ReturnData{
        public int height;
        public int nodes;
        public ReturnData(int height,int nodes){
            this.height=height;
            this.nodes=nodes;
        }
    }

    public static ReturnData f(Node x){
        //方法二  用套路
        if(x==null){
            return new ReturnData(0,0);
        }
        ReturnData leftData = f(x.left);
        ReturnData rightData = f(x.right);
        int height = Math.max(leftData.height, rightData.height)+1;
        int nodes = leftData.nodes+rightData.nodes+1;
        return new ReturnData(height,nodes);
    }
}
