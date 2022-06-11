package ZuoShen.Class08;

public class TrieTree {
    public static class TrieNode{
        public int pass;  //该节点走过多少次
        public int end;   //该节点作为结尾多少次
        public TrieNode[] nexts;
        //HashMap<Char,Node> nexts 如果字符种类特别多可以选择用hash表来表达路
        //TreeMap<Char,Node> nexts 如果字符种类特别多并且要求有序可以选择用有序表来表达路
        public TrieNode(){
            pass=0;
            end=0;
            //脚标为0-25  代表该节点可以有26个小写字母连接
            // 默认是null代表没有指向该脚标的字母的连接
            nexts=new TrieNode[26];
        }
    }
    public static class Trie{
        private TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        //将一个字符串插入到前缀树
        public void insert(String word){
            if(word==null){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++; //根节点的pass先+1
            int index = 0;  //这个index用于控制新加入的节点放入trieNodes数组中的哪个位置
            for (int i = 0; i < chars.length; i++) {
                index=chars[i] - 'a'; //这样'a'的脚标为0，'b'的脚标为1  以此类推
                if(node.nexts[index]==null){
                    node.nexts[index]=new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }
        //删除word字符 （一次）
        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null; //c++要去底层去析构
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
        //查询word这个单词加入过几次
        public int search(String word){
            if(word==null){
                return 0;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;//查找abcdefg  走到abc结束了 说明没加入过
                }
                node = node.nexts[index];
            }
            return node.end;
        }
        //查询word这个单词作为前缀加入过几次
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
