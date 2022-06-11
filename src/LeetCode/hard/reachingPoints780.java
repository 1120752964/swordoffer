package LeetCode.hard;

public class reachingPoints780 {
    public static void main(String[] args) {
        System.out.println((int)Math.pow(2,31)+1);
        System.out.println((int)Math.pow(2,31));
        System.out.println((int)Math.pow(-2,31)+1);
        System.out.println((int)Math.pow(-2,31)-1);
//        System.out.println(reachingPoints(35, 13,455955547,420098884));
//        System.out.println(reachingPoints(1, 1,3,5));
    }
    //正常的递归会因为栈内存爆掉
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx>tx||sy>ty){
            return false;
        }
        if(sx==tx&&sy==ty){
            return true;
        }
        return reachingPoints(sx+sy,sy,tx,ty)||reachingPoints(sx,sx+sy,tx,ty);
    }
    //正常的递归会因为栈内存爆掉
    public static boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        int max = Math.max(tx,ty);
        int[][] result = new int[max][max];
        return reverse(sx+sy,sy,tx,ty,result);

    }
    public static boolean reverse(int sx, int sy, int tx, int ty,int[][] result){
        for (int i = sx; i < tx; i+=sy) {
            for (int j = sy; j < ty; j+=sx) {
                if(i<tx||j<ty){
                    result[i][j]=-1;
                }
                if(i>tx||j>ty){

                }
            }
        }
        return reachingPoints(sx+sy,sy,tx,ty)||reachingPoints(sx,sx+sy,tx,ty);
    }
}
