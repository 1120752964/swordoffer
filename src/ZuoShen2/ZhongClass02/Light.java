package ZuoShen2.ZhongClass02;

public class Light {
    //至少需要多少等，可以把.都点亮
    public static int minLight(String s){
        char[] str = s.toCharArray();
        int index = 0;
        int light = 0;
        //当你来到i位置，一定要保证之前的灯，彻底不会影响到i位置
        while(index< str.length){
            if(str[index] == 'X'){
                index++;
            }else { // str[index] == '.'
                light++;
                if(str[index+1] == 'X'){
                    index = index+2;
                }else { //下一个位置是'.'
                    index = index+3;
                }
            }
        }
        return light;
    }
}
