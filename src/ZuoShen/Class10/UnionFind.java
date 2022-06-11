package ZuoShen.Class10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }

    }

    public static class UnionFindSet<V> {
        //给一个V  得一一对应加工出来的元素
        public HashMap<V, Element<V>> elementMap;

        //key代表一个节点  value代表它的父节点
        public HashMap<Element<V>, Element<V>> fatherMap;

        //key代表这个小集合的根节点（代表结点）  value代表它的size
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            //并查集使用的前提是有初始化
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    rankMap.remove(small);
                }
            }
        }

    }
}
