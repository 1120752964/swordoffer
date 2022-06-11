package ZuoShen.Class10;

public class BitMap {
    public static void main(String[] args) {
        int a = 0;
        //a 32 bit

        int[] arr = new int[10]; //32bit * 10 -> 320bits

        //arr[0]  int 0~31 bit   11111111 11111111 11111111 11111111
        //arr[1]  int 32~63 bit
        //arr[2]  int 64~95 bit

        int i = 178;  //想取得178个bit的状态

        int numIndex = 178/32;//代表第178位应该在哪个int数上去找
        int bitIndex = 178%32;//代表在这个数上的第多少位  假设是第3位  就是从右往左数
                              //低位的 所以右移

        //拿到178位的状态  1的位表示：  00000001 因此与完后 得到的是最右侧的位的状态
        int s = ((arr[numIndex] >> (bitIndex) ) & 1);

        //把178位的状态改为1   00000001 左移3位  00001000 再或 因此可以修改为1
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex));

        //把178位的状态改为0   00000001 左移3位  00001000 取反 11110111 取与运算 修改为0
        arr[numIndex] = arr[numIndex] & (~ (1 << (bitIndex)));

    }
}
