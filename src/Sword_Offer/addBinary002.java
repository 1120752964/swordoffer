package Sword_Offer;

public class addBinary002 {
    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
                ,"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));;
    }
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    public static int add(int x,int y){
        int res;
        int xor = x^y;
        int forword =(x&y)<<1;
        if(forword!=0){
            res=add(xor,forword);
        }else{
            res=xor;
        }
        return res;
    }

    public static String getBinaryString(int res,int len){
        StringBuilder str = new StringBuilder();
        int i=1;
        //需要找到最左边的1
        for (int j = 0; j <len ; j++) {
            if((res&i)!=0){
                str.insert(0,"1");
            }else{
                str.insert(0,"0");
            }
            i=(i<<1);
        }
        return str.toString();
    }
}
