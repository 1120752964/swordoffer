package LeetCode.medium;

import java.util.Arrays;

public class updateMatrix542 {
    public static void main(String[] args) {
        int[][] result = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        result=updateMatrix(result);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int colum = mat[0].length;
        int[][] result = new int[row][colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if(mat[i][j]==1){
                    result[i][j] = reverse(mat,i,j);
                }
            }
        }
        return result;
    }

    public static int reverse(int[][] mat,int i,int j){
        if(i<0||j<0||i>=mat.length||j>=mat[0].length){
            return 0;
        }
        if(mat[i][j]==0){
            return 1;
        }else {
            return Math.max(Math.max(reverse(mat,i-1,j),reverse(mat,i,j-1)),Math.max(reverse(mat,i+1,j),reverse(mat,i,j+1)))+1;
        }
    }
}
