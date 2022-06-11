package ZuoShen2.ZhongClass02;

public class Problem05_EditCost {

	public static int minCost1(String str1, String str2, int ic, int dc, int rc) {
		if (str1 == null || str2 == null) {
			return 0;
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		for (int i = 0; i < chs1.length; i++) {
			System.out.print(chs1[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < chs2.length; i++) {
			System.out.print(chs2[i]+" ");
		}
		System.out.println();
		int row = chs1.length + 1;
		int col = chs2.length + 1;
		int[][] dp = new int[row][col];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dc * i;
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = ic * j;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (chs1[i - 1] == chs2[j - 1]) { //情况4
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + rc;//情况3
				}
				dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic); //情况2
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc); //情况1
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[row - 1][col - 1];
	}

	public static int minCost2(String str1, String str2, int ic, int dc, int rc) {
		if (str1 == null || str2 == null) {
			return 0;
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		char[] longs = chs1.length >= chs2.length ? chs1 : chs2;
		char[] shorts = chs1.length < chs2.length ? chs1 : chs2;
		if (chs1.length < chs2.length) { // str2�ϳ��ͽ���ic��dc��ֵ
			int tmp = ic;
			ic = dc;
			dc = tmp;
		}
		int[] dp = new int[shorts.length + 1];
		for (int i = 1; i <= shorts.length; i++) {
			dp[i] = ic * i;
		}
		for (int i = 1; i <= longs.length; i++) {
			int pre = dp[0]; // pre��ʾ���Ͻǵ�ֵ
			dp[0] = dc * i;
			for (int j = 1; j <= shorts.length; j++) {
				int tmp = dp[j]; // dp[j]û����ǰ�ȱ�������
				if (longs[i - 1] == shorts[j - 1]) {
					dp[j] = pre;
				} else {
					dp[j] = pre + rc;
				}
				dp[j] = Math.min(dp[j], dp[j - 1] + ic);
				dp[j] = Math.min(dp[j], tmp + dc);
				pre = tmp; // pre���dp[j]û����ǰ��ֵ
			}
		}
		return dp[shorts.length];
	}

	public static void main(String[] args) {
		String str1 = "OSLO";
		String str2 = "SNOW";
		System.out.println(minCost1(str1, str2, 1, 1, 1));
//		System.out.println(minCost2(str1, str2, 5, 3, 2));

//		str1 = "abcdf";
//		str2 = "ab12cd3";
//		System.out.println(minCost1(str1, str2, 3, 2, 4));
//		System.out.println(minCost2(str1, str2, 3, 2, 4));
//
//		str1 = "";
//		str2 = "ab12cd3";
//		System.out.println(minCost1(str1, str2, 1, 7, 5));
//		System.out.println(minCost2(str1, str2, 1, 7, 5));
//
//		str1 = "abcdf";
//		str2 = "";
//		System.out.println(minCost1(str1, str2, 2, 9, 8));
//		System.out.println(minCost2(str1, str2, 2, 9, 8));

	}

}