package LeetCode.medium;

import java.util.*;

public class lengthLongestPath388 {
    public static void main(String[] args) {
        System.out.println(lengthLongestPath2(
                "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//        System.out.println("/t/t/tasdasd".lastIndexOf("/t"));
    }

    public static int lengthLongestPath2(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        int[] level = new int[n + 1];

        while (pos < n) {
            /* 检测当前文件的深度 */
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            /* 统计当前文件名的长度 */
            int len = 0;
            boolean isFile = false;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            /* 跳过换行符 */
            pos++;

            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }


    public static int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        while (pos < n) {
            /* 检测当前文件的深度 */
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            /* 统计当前文件名的长度 */
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            /* 跳过当前的换行符 */
            pos++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }

    public static int getNs(String str){
        char t = '\t';
        int count = 0;//count用来接收子字符串substr在字符串str中出现的次数
        int i = 0;
        while(str.indexOf(t,i) != -1) {
            count++;
            i=str.indexOf(t, i)+2;
        }
        return count;
    }
}
