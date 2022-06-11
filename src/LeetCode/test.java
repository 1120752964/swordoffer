package LeetCode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        test test=new test();
        String a = "asdasd";a.substring(0,1);
        int[] sdfsd = new int[]{1,3,5,1,6};
        int sum = Arrays.stream(sdfsd).sum();
        HashMap<int[],Integer> map = new HashMap<>();
        map.put(new int[]{1,2,3},2);
        map.put(new int[]{1,2,3},3);
        System.out.println();
//        System.out.println(test.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(isPacific(heights,i,j)&&isAtlantic(heights,i,j)){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public boolean isPacific(int[][] heights,int i,int j){
        if(i<=0||j<=0){
            return true;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        //i和j都大于等于1
        if(i+1<heights.length){
            if(heights[i+1][j]<=heights[i][j]){
                flag1= isPacific(heights,i+1,j);
            }
        }
        if(j+1<heights[0].length){
            if(heights[i][j+1]<=heights[i][j]){
                flag2= isPacific(heights,i,j+1);
            }
        }
        if(heights[i-1][j]<=heights[i][j]){
            flag3= isPacific(heights,i-1,j);
        }
        if(heights[i][j-1]<=heights[i][j]){
            flag4= isPacific(heights,i,j-1);
        }
        return flag1||flag2||flag3||flag4;
    }
    public boolean isAtlantic(int[][] heights,int i,int j){
        if(i>=heights.length||j>=heights[0].length){
            return true;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        //i和j需要判断下界
        if(heights[i+1][j]<=heights[i][j]){
            flag1= isAtlantic(heights,i+1,j);
        }
        if(heights[i][j+1]<=heights[i][j]){
            flag2= isAtlantic(heights,i,j+1);
        }
        if(i-1>=0){
            if(heights[i-1][j]<=heights[i][j]){
                flag3= isAtlantic(heights,i-1,j);
            }
        }
        if(j-1>=0){
            if(heights[i][j-1]<=heights[i][j]){
                flag4= isAtlantic(heights,i,j-1);
            }
        }
        return flag1||flag2||flag3||flag4;
    }
}
