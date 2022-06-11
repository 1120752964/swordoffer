//package ZuoShen2.ZhongClass02;
//
//public class SnakeGame {
//    public static int snake(int[][] matrix){
//        int ans = Integer.MIN_VALUE;//当前点的最好答案
//        for(int row=0;row<matrix.length;row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                Info cur = process(matrix,row,col);
//                ans = Math.max(ans,Math.max(cur.no,cur.yes));
//            }
//        }
//    }
//    public static class Info{
//        public int no;
//        public int yes;
//
//        public Info(int n,int yes){
//
//        }
//    }
//
//    //从最左侧出发（具体位置不关心），当前到达(row,col)
//    //在这个旅程中
//    //no,一次能力也不用，能达到的最大路径和（如果是负数，表示没有该答案）
//    //yes,使用了一次能力，能达到的最大路径和（如果是负数，表示没有该答案）
//    public static Info process(int[][] matrix,int row,int col){
//        if(col==0){
//            return new Info(matrix[row][0],-matrix[row][0]);
//        }
//        //没有在最左列
//        int preNo=-1;//我之前的路程中，一次能力也没用，能达到的最大路径和
//        int preYes=-1;//我之前的路程中，用过一次能力了，能达到的最大路径和
//        //p1
//        if(row>0){
//            Info leftUp = process(matrix,row-1,col-1);
//            if(leftUp.no>0){
//                preNo=leftUp.no;
//            }
//            if(leftUp.yes>0){
//                preYes=leftUp.yes;
//            }
//        }
//        //p2
//        Info left = process(matrix,row,col-1);
//        if(left.no>0){
//            preNo=left.no;
//        }
//        if(left.yes>0){
//            preYes=left.yes;
//        }
//        //p3
//        if(row<matrix.length-1){
//            Info leftDown = process(matrix,row+1,col-1);
//            if(leftDown.no>0){
//                preNo=left.no;
//            }
//            if(leftDown.yes>0){
//                preYes=left.yes;
//            }
//        }
//
//        int no=-1;
//        int yes=-1;
//
//        if(preNo>=0){
//            no = preNo+matrix[row][col];
//            yes = preNo + -matrix[row][col];
//        }
//        if(preYes>=0){
//            yes = Math.max(yes,preYes+matrix[row][col]);
//        }
//
//        return new Info(no,yes);
//    }
//}
