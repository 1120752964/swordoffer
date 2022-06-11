package ZuoShen.Class04;

public class merge_sort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};//小数和18
        System.out.println(smallSum(arr));
    }
    public static int smallSum(int[] arr){
        if(arr==null||arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int L,int R){
        if(L==R){
            return 0;
        }
        int mid = L + ((R-L)>>1);
        return process(arr,L,mid)+ process(arr,mid+1,R)+ merge(arr,L,mid,R);//这里返回的只有最后一次的合并 也就是想要的结果  中间的过程都是不要的
    }
    public static  int  merge(int[] arr,int L,int M,int R){
        int[] help = new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        int res=0;
        while (p1<=M&&p2<=R){
            res += arr[p1]<arr[p2]?arr[p1]*(R-p2+1):0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=M){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (i  = 0; i < help.length; i++) {
            arr[L+i]= help[i];
        }
        return res;
    }
}
