package ZuoShen2.ZhongClass02;

public class PackingMachine {
    public static int MinOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        if (sum % size != 0) {
            return -1;
        }
        int avg = sum / size;
        int leftSum = 0; //左侧已经遍历过的累加和
        int ans = 0; //结果
        for (int i = 0; i < arr.length; i++) {
            //正 需要输入  负 需要输出
            int L = i * avg - leftSum;
            //正 需要输入  负 需要输出
            int R = (size - i - 1) * avg - (sum - leftSum - arr[i]);
            if (L > 0 && R > 0) {
                ans = Math.max(ans, Math.abs(L) + Math.abs(R));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(L), Math.abs(R)));
            }
            leftSum += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
