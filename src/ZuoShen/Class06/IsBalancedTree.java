package ZuoShen.Class06;

public class IsBalancedTree {

    public static boolean IsBalanced(Node head){
       return process(head).isBalanced;
    }
    public static class ReturnType{
        public boolean isBalanced;
        public int height;
        ReturnType(boolean isBalanced,int height){
            this.isBalanced=isBalanced;
            this.height = height;
        }
    }
    public static ReturnType process(Node x){
        if(x==null){
            return new ReturnType(true,0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height,rightData.height)+1;
        boolean isBalanced = leftData.isBalanced&&rightData.isBalanced&&Math.abs(leftData.height-rightData.height)<2;
        return new ReturnType(isBalanced,height);
    }
}
