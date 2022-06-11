package Sword_Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class checkInclusion014 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion2("ab", "eidbaooo"));
        System.out.println(checkInclusion3("ab", "asndlknaklbadslk"));
    }
    public static boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
    public  static boolean checkInclusion2(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] map1 =new int[26];
        int[] map2 =new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(map1,map2)){
            return true;
        }
        int left=0;int right = s1.length();
        for(;right<s2.length();left++,right++){
            map2[s2.charAt(right)-'a']++;
            map2[s2.charAt(left)-'a']--;
            if(Arrays.equals(map1,map2)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        HashMap<Character,Integer> map1 =new  HashMap<>();
        HashMap<Character,Integer> map2 =new  HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        if(map1.equals(map2)){
            return true;
        }
        int left=1;int right = s1.length();
        for(;right<s2.length();left++,right++){
            map2.put(s2.charAt(right),map2.getOrDefault(s2.charAt(right),0)+1);
            map2.put(s2.charAt(left-1),map2.get(s2.charAt(left-1))-1);
            if(map2.get(s2.charAt(left-1))<=0){
                map2.remove(s2.charAt(left-1));
            }
            if(map1.equals(map2)){
                return true;
            }
        }
        return false;
    }
}
