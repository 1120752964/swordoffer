package LeetCode.note;

//线段树   https://www.cnblogs.com/xenny/p/9801703.html
public class Segment_Tree {
    int[] a;
    int[] t;//a为传入的数组，t为线段树
    int[] lazy;
    Segment_Tree(int[] a) {
        this.a = a;
        t = new int[a.length << 2];
    }

    //更新index处的max值
    public void Pushup(int k) {
        t[k] = Math.max(t[k << 1], t[k << 1 | 1]);
    }

    //TODO 递归的方式建树 build(1,1,n）
    public void build(int k, int l, int r) { //l和r是a数组的范围区间  k是t数组的节点位置
        if (l == r)    //左端点等于右端点，即为叶子节点，直接赋值即可
            t[k] = a[l];
        else {
            int m = l + ((r - l) >> 1);    //m则为中间点，左儿子的结点区间为[l,m],右儿子的结点区间为[m+1,r]
            build(k << 1, l, m);    //递归构造左儿子结点
            build(k << 1 | 1, m + 1, r);    //递归构造右儿子结点
            Pushup(k);    //更新父节点
        }
    }

    // TODO 点更新   递归方式更新 updata(p,v,1,r,k);
    public void updata(int p,int v,int l,int r,int k){
        //p为a数组下标，v为要加上的值，l，r为a结点区间，k为t数组结点下标
        if(l==r){
            t[k]+=v;
            a[p]+=v;
        }else {
            int m = l + ((r - l) >> 1);
            if(l<=m){
                updata(p, v, l, m, k<<2);
            }else {
                updata(p, v, m+1, r, k<<2|1);
            }
            Pushup(k);
        }
    }
    //TODO 区间查询  [1,6]分为[1,3],[4,6] 假如查询[2,5] 得分成三个部分
    //[1,3]分为[1,2]和[3,3]还要在细分
    public int query(int L,int R,int l,int r,int k){
        //[L,R]为要查询的区间 [l,r]为递归到的区间
        if(l>=L&&r<=R){
            return t[k];
        }else {
            int res = Integer.MIN_VALUE;//返回值变量，根据具体线段树查询的什么而自定义
            int m = l + ((r - l) >> 1);
            if(L<=m){ //如果左子树和需要查询的区间交集非空
                res=Math.max(res,query(L, R, l, m, k<<2));
            }
            if(R>m){//如果右子树和需要查询的区间交集非空，注意这里不是else if，因为查询区间可能同时和左右区间都有交集
                res=Math.max(res,query(L, R, m+1, r, k<<2|1));
            }
            return res;
        }
    }

    //TODO 区间更新
    void Pushdown(int k){    //更新子树的lazy值，这里是RMQ的函数，要实现区间和等则需要修改函数内容
        if(lazy[k]!=0){    //如果有lazy标记
            lazy[k<<1] += lazy[k];    //更新左子树的lazy值
            lazy[k<<1|1] += lazy[k];    //更新右子树的lazy值
            t[k<<1] += lazy[k];        //左子树的最值加上lazy值
            t[k<<1|1] += lazy[k];    //右子树的最值加上lazy值
            lazy[k] = 0;    //lazy值归0
        }
    }

    //递归更新区间 updata2(L,R,v,1,n,1);
    public void updata2(int L,int R,int v,int l,int r,int k){    //[L,R]即为要更新的区间，l，r为结点区间，k为结点下标
        if(L <= l && r <= R){    //如果当前结点的区间真包含于要更新的区间内
            lazy[k] += v;    //懒惰标记
            t[k] += v;    //最大值加上v之后，此区间的最大值也肯定是加v
        }
        else{
            Pushdown(k);    //重难点，查询lazy标记，更新子树
            int m = l + ((r-l)>>1);
            if(L <= m){
                //如果左子树和需要更新的区间交集非空
                updata2(L,R,v,l,m,k<<1);
            }
            if(m < R)    //如果右子树和需要更新的区间交集非空
                updata2(L,R,v,m+1,r,k<<1|1);
            Pushup(k);    //更新父节点
        }
    }
}
