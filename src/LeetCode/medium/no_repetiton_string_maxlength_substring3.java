package LeetCode.medium;

public class no_repetiton_string_maxlength_substring3 {
    public static void main(String[] args) {
        int a =lengthOfLongestSubstring("bbbbb");
        System.out.println(a);
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int left=0,right=1,largest=0;
        while(right<s.length()){
            int temp = left;
            while(temp<right){
                if(s.charAt(temp)==s.charAt(right)){
                    left=temp+1;
                    break;
                }else {
                    temp++;
                }
            }
            largest=Math.max(largest,right-left+1);
            right++;
        }
        return largest;
    }
}

//
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        // 哈希集合，记录每个字符是否出现过
//        Set<Character> occ = new HashSet<Character>();
//        int n = s.length();
//        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
//        int rk = -1, ans = 0;
//        for (int i = 0; i < n; ++i) {
//            if (i != 0) {
//                // 左指针向右移动一格，移除一个字符
//                occ.remove(s.charAt(i - 1));
//            }
//            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
//                // 不断地移动右指针
//                occ.add(s.charAt(rk + 1));
//                ++rk;
//            }
//            // 第 i 到 rk 个字符是一个极长的无重复字符子串
//            ans = Math.max(ans, rk - i + 1);
//        }
//        return ans;
//    }
//}
//
