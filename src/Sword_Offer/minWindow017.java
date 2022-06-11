package Sword_Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class minWindow017 {
    static HashMap<Character,Integer> s1= new HashMap<>();
    static HashMap<Character,Integer> t1= new HashMap<>();
    public static void main(String[] args) {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append("asdasd");
        System.out.println( stringBuilder.equals(stringBuilder.reverse()));

//        System.out.println(minWindow("cabwefgewcwaefgcf"
//               , "cae"));
    }

    public static String minWindow(String s, String t) {

        if(s.length()<t.length()){
            return "";
        }
        if(s.length()==1){
            return s.equals(t)?s:"";
        }
        int n=t.length();int start=-1,end=-1;
        //
        for(int i=0;i<n;i++){
            s1.put(s.charAt(i),s1.getOrDefault(s.charAt(i),0)+1);
            t1.put(t.charAt(i),t1.getOrDefault(t.charAt(i),0)+1);
        }

        if(isOk()){
            return s.substring(0,n);
        }
        int left=0,right=n-1;
        int minLen=Integer.MAX_VALUE;
        while(right<s.length()-1){
            //往右走 找到第一个满足条件的情况  然后left往右走
            right++;
            s1.put(s.charAt(right),s1.getOrDefault(s.charAt(right),0)+1);
            while(isOk()){
                //left往右走 走到走不了 right继续走
                if(minLen>right-left+1){
                    start=left;end=right+1;
                }
                minLen=Math.min(minLen,right-left+1);
                if(s1.containsKey(s.charAt(left))){
                    if(s1.get(s.charAt(left))-1<=0){
                        s1.remove(s.charAt(left));
                    }else {
                        s1.put(s.charAt(left),s1.get(s.charAt(left))-1);
                    }
                }
                left++;
            }
        }
        if(start==-1){
            return "";
        }
        return s.substring(start,end);
    }

    public static boolean isOk(){
        for (Map.Entry<Character,Integer> entry:t1.entrySet()){
            if(s1.getOrDefault(entry.getKey(),-1)<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
