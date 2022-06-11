package Sword_Offer;

import java.util.HashMap;

public class isAlienSorted034 {
    public static void main(String[] args) {

        System.out.println(isAlienSorted(new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=0;i<words.length-1;i++){
            //判断两个字符串的字典序是否递增
            String a=words[i];
            String b=words[i+1];
            int index=0;
            while(index<a.length()&&index<b.length()){
                if(a.charAt(index)==b.charAt(index)){
                    index++;
                    continue;
                }
                if(map.get(a.charAt(index))>map.get(b.charAt(index))){
                    return false;
                }else{
                    break;
                }
            }
            if((index==a.length()||index==b.length())&&b.length()<a.length()){
                return false;
            }
        }
        return true;
    }
}
