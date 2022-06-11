package ZuoShen2.ZhongClass01;

public class CordCoverMaxPoint {
    //第一种思路 N*LogN的复杂度
    public static int maxPoint(int[] arr, int L) {
        //arr代表的是那些点  L代表绳子长度
        int res = 1;
        for (int i = 0; i < arr.length; i++) { //遍历点
            //这里相当于是绳子的右端放在一个点上 然后绳子左端往左伸
            //找到能伸到的最左侧的节点 即在arr[0..i]范围上，找满足>=value的最左位置
            int nearest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    // 在arr[0..R]范围上，找满足>=value的最左位置
    // 二分查找  如果满足>=value就R往左走 不满足L就往左走
    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    //第二种思路 N的复杂度(手撸的)
    public static int maxPoint2(int[] arr, int length) {
        //arr代表的是那些点  L代表绳子长度
        int res = 1;
        int l=0,r=0;
        for (int i = 0; i < arr.length-1; i++) {
            l=i;
            r=i+1;
            while (r<arr.length){ //防止越界
                if(arr[r]-arr[l]<=length){
                    r++;  //因为r每次都会多加一次  因此最后是r-l
                }else {
                    break;
                }
            }
            res=Math.max(res,r-l);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] arr = { 0, 13, 24, 35, 46, 57, 65, 69, 70 };
        int L = 6;

        System.out.println(maxPoint(arr, L));
        System.out.println(maxPoint2(arr, L));

    }
}
