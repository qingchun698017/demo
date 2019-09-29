///*
// * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
// * This software is the confidential and proprietary information of GuaHao Company.
// * ("Confidential Information").
// * You shall not disclose such Confidential Information and shall use it only
// * in accordance with the terms of the license agreement you entered into with GuaHao.com.
// */
//package jdk8;
//
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.AbstractMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//
///**
// * TODO
// *
// * @author wqc
// * @version V1.0
// * @since 2019-06-15 13:08
// */
//public class HashMap<K,V> extends AbstractMap<K,V>
//    implements Map<K,V>, Cloneable, Serializable {
//    /**
//     * 默认容量，1向左移位4个. 1x2^4
//     */
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
//
//    /**
//     * 最大容量，1x2^30=1 073 741 824
//     */
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//    /**
//     * 默认加载因子，用于扩容使用。
//     * 当前 HashMap 所能容纳键值对数量的最大值，
//     * 超过threshold = capacity * loadFactor这个值，则需扩容
//     * 通过调节负载因子，可使 HashMap 时间和空间复杂度上有不同的表现。
//     * 当我们调低负载因子时，HashMap 所能容纳的键值对数量变少。扩容时，重新将键值对存储新的桶数组里，键的键之间产生的碰撞会下降，链表长度变短。此时，HashMap 的增删改查等操作的效率将会变高，这里是典型的拿空间换时间。
//     * 如果增加负载因子（负载因子可以大于1），HashMap 所能容纳的键值对数量变多，空间利用率高，但碰撞率也高。这意味着链表长度变长，效率也随之降低，这种情况是拿时间换空间。
//     */
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    /**
//     * 当某个桶节点数量大于8时，会转换为红黑树。
//     *
//     */
//    static final int TREEIFY_THRESHOLD = 8;
//
//
//
//    /**
//     * 当整个hashMap中元素数量大于64时，也会进行转为红黑树结构。
//     */
//    static final int MIN_TREEIFY_CAPACITY = 64;
//
//    //存储元素的数组，transient关键字表示该属性不能被序列化
//    transient Node<K,V>[] table;
//
//    /**
//     * 将数据转换成set的另一种存储形式，这个变量主要用于迭代功能
//     */
//    transient Set<Entry<K,V>> entrySet;
//
//    /**
//     *元素数量
//     */
//    transient int size;
//
//    /**
//     * 统计该map修改的次数
//     */
//    transient int modCount;
//
//    /**
//     *临界值，也就是元素数量达到临界值时，会进行扩容。
//     */
//    int threshold;
//
//    /**
//     * 加载因子
//     * 当前 HashMap 所能容纳键值对数量的最大值，
//     * 超过threshold = capacity * loadFactor这个值，则需扩容
//     * 通过调节负载因子，可使 HashMap 时间和空间复杂度上有不同的表现。
//     * 当我们调低负载因子时，HashMap 所能容纳的键值对数量变少。扩容时，重新将键值对存储新的桶数组里，键的键之间产生的碰撞会下降，链表长度变短。此时，HashMap 的增删改查等操作的效率将会变高，这里是典型的拿空间换时间。
//     * 如果增加负载因子（负载因子可以大于1），HashMap 所能容纳的键值对数量变多，空间利用率高，但碰撞率也高。这意味着链表长度变长，效率也随之降低，这种情况是拿时间换空间
//     * @serial
//     */
//    final float loadFactor;
//
//    /* ---------------- Public operations -------------- */
//
//    /**
//     * 设置加载因子为默认加载因子
//     */
//    public HashMap() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
//    }
//
//
//    /**
//     * 设置初始容量、加载因子为默认加载因子
//     */
//    public HashMap(int initialCapacity) {
//        this(initialCapacity, DEFAULT_LOAD_FACTOR);
//    }
//
//
//    /**
//     * 设置初始容量、加载因子
//     */
//    public HashMap(int initialCapacity, float loadFactor) {
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal initial capacity: " +
//                initialCapacity);
//        if (initialCapacity > MAXIMUM_CAPACITY)
//            initialCapacity = MAXIMUM_CAPACITY;
//        if (loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new IllegalArgumentException("Illegal load factor: " +
//                loadFactor);
//        this.loadFactor = loadFactor;
//        this.threshold = tableSizeFor(initialCapacity);
//    }
//
//    /**
//     * 将另一个 Map 中的映射拷贝一份到自己的存储结构中来
//     */
//    public HashMap(Map<? extends K, ? extends V> m) {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//        putMapEntries(m, false);
//    }
//
//
//    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
//        int s = m.size();
//        if (s > 0) {
//            if (table == null) { // pre-size
//                float ft = ((float)s / loadFactor) + 1.0F;
//                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
//                    (int)ft : MAXIMUM_CAPACITY);
//                if (t > threshold)
//                    threshold = tableSizeFor(t);
//            }
//            else if (s > threshold)
//                resize();
//            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
//                K key = e.getKey();
//                V value = e.getValue();
//                putVal(hash(key), key, value, false, evict);
//            }
//        }
//    }
//
//    static Class<?> comparableClassFor(Object x) {
//        if (x instanceof Comparable) {
//            Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
//            if ((c = x.getClass()) == String.class) // bypass checks
//                return c;
//            if ((ts = c.getGenericInterfaces()) != null) {
//                for (int i = 0; i < ts.length; ++i) {
//                    if (((t = ts[i]) instanceof ParameterizedType) &&
//                        ((p = (ParameterizedType)t).getRawType() ==
//                            Comparable.class) &&
//                        (as = p.getActualTypeArguments()) != null &&
//                        as.length == 1 && as[0] == c) // type arg is c
//                        return c;
//                }
//            }
//        }
//        return null;
//    }
//    /**
//     * Returns k.compareTo(x) if x matches kc (k's screened comparable
//     * class), else 0.
//     */
//    @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
//    static int compareComparables(Class<?> kc, Object k, Object x) {
//        return (x == null || x.getClass() != kc ? 0 :
//            ((Comparable)k).compareTo(x));
//    }
//
//    /**
//     * Returns a power of two size for the given target capacity.
//     */
//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//
//
//
//    public Set<Entry<K, V>> entrySet() {
//        return null;
//    }
//
//
//    /**
//     * 删除
//     */
//    public V remove(Object key) {
//        Node<K,V> e;
//        return (e = removeNode(hash(key), key, null, false, true))
//            == null ? null : e.value;
//    }
//
//    /**
//     * 删除节点
//     */
//    final Node<K,V> removeNode(int hash, Object key, Object value,
//        boolean matchValue, boolean movable) {
//        Node<K,V>[] tab; Node<K,V> p; int n, index;
//        // 1. 定位桶位置 p = tab[index = (n - 1) & hash]
//        if ((tab = table) != null && (n = tab.length) > 0 &&
//            (p = tab[index = (n - 1) & hash]) != null) {
//            Node<K,V> node = null, e; K k; V v;
//            // 如果键的值与链表第一个节点相等，则将 node 指向该节点
//            if (p.hash == hash &&
//                ((k = p.key) == key || (key != null && key.equals(k))))
//                node = p;
//            else if ((e = p.next) != null) {
//                if (p instanceof TreeNode)
//                    // 如果是 TreeNode 类型，调用红黑树的查找逻辑定位待删除节点
//                    node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
//                else {
//                    // 2. 遍历链表，找到待删除节点
//                    do {
//                        if (e.hash == hash &&
//                            ((k = e.key) == key ||
//                                (key != null && key.equals(k)))) {
//                            node = e;
//                            break;
//                        }
//                        p = e;
//                    } while ((e = e.next) != null);
//                }
//            }
//            // 3. 删除节点，并修复链表或红黑树
//            if (node != null && (!matchValue || (v = node.value) == value ||
//                (value != null && value.equals(v)))) {
//                if (node instanceof TreeNode)
//                    ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
//                else if (node == p)
//                    tab[index] = node.next;
//                else
//                    p.next = node.next;
//                ++modCount;
//                --size;
//                afterNodeRemoval(node);
//                return node;
//            }
//        }
//        return null;
//    }
//
//
//
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//        boolean evict) {
//        Node<K,V>[] tab;
//        Node<K,V> p;
//        int n, i;
//
//        // 初始化桶数组 table，table 被延迟到插入新数据时再进行初始化
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        // 如果桶中不包含键值对节点引用，则将新键值对节点的引用存入桶中即可
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null);
//        else {
//            Node<K,V> e; K k;
//            // 如果键的值以及节点 hash 等于链表中的第一个键值对节点时，则将 e 指向该键值对
//            if (p.hash == hash &&
//                ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//            // 如果桶中的引用类型为 TreeNode，则调用红黑树的插入方法
//            else if (p instanceof TreeNode)
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {
//                //对链表进行遍历，并统计链表长度
//                for (int binCount = 0; ; ++binCount) {
//                    // 链表中不包含要插入的键值对节点时，则将该节点接在链表的最后
//                    if ((e = p.next) == null) {
//                        // 如果链表长度大于或等于树化阈值，则进行树化操作
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    //条件为 true，表示当前链表包含要插入的键值对，终止遍历
//                    if (e.hash == hash &&
//                        ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            // 判断要插入的键值对是否存在 HashMap 中
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                // onlyIfAbsent 表示是否仅在 oldValue 为 null 的情况下更新键值对的值
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        // 键值对数量超过阈值时，则进行扩容
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//
//
//
//    public V get(Object key) {
//        Node<K,V> e;
//        return (e = getNode(hash(key), key)) == null ? null : e.value;
//    }
//
//    /**
//     * 查找：，即先定位键值对所在的桶的位置，然后再对链表或红黑树进行查找。
//     *
//     */
//    final Node<K,V> getNode(int hash, Object key) {
//        Node<K,V>[] tab;
//        Node<K,V> first, e;
//        int n;
//        K k;
//        // 1. 定位键值对所在桶的位置 first = tab[(n - 1) & hash]  index=(n-1)&hash
//        if ((tab = table) != null && (n = tab.length) > 0 &&
//            (first = tab[(n - 1) & hash]) != null) {
//            if (first.hash == hash && // always check first node
//                ((k = first.key) == key || (key != null && key.equals(k))))
//                return first;
//            if ((e = first.next) != null) {
//                // 2. 如果 first 是 TreeNode 类型，则调用黑红树查找方法
//                if (first instanceof TreeNode)
//                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
//                // 2. 对链表进行查找
//                do {
//                    if (e.hash == hash &&
//                        ((k = e.key) == key || (key != null && key.equals(k))))
//                        return e;
//                } while ((e = e.next) != null);
//            }
//        }
//        return null;
//    }
//
//    void afterNodeAccess(Node<K,V> p) { }
//
//    void afterNodeInsertion(boolean evict) { }
//
//
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    /**
//     * 将普通节点链表转换成树形节点链表
//     * @param tab
//     * @param hash
//     */
//    final void treeifyBin(Node<K,V>[] tab, int hash) {
//        int n, index; Node<K,V> e;
//        // 桶数组容量小于 MIN_TREEIFY_CAPACITY=64，优先进行扩容而不是树化
//        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
//            resize();
//        else if ((e = tab[index = (n - 1) & hash]) != null) {
//            // hd 为头节点（head），tl 为尾节点（tail）
//            TreeNode<K,V> hd = null, tl = null;
//            do {
//                // 将普通节点替换成树形节点
//                TreeNode<K,V> p = replacementTreeNode(e, null);
//                if (tl == null)
//                    hd = p;
//                else {
//                    p.prev = tl;
//                    tl.next = p;
//                }
//                tl = p;
//            } while ((e = e.next) != null);// 将普通链表转成由树形节点链表
//
//            if ((tab[index] = hd) != null)
//                // 将树形链表转换成红黑树
//                hd.treeify(tab);
//        }
//    }
//
//    TreeNode<K,V> replacementTreeNode(Node<K,V> p, Node<K,V> next) {
//        return new TreeNode<>(p.hash, p.key, p.value, next);
//    }
//
//    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
//        return new Node<>(hash, key, value, next);
//    }
//
//    final Node<K,V>[] resize() {
//        Node<K,V>[] oldTab = table;
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;
//        int newCap, newThr = 0;
//        // 如果 table 不为空，表明已经初始化过了
//        if (oldCap > 0) {
//            // 当 table 容量超过容量最大值1x2^30=1 073 741 824，则不再扩容
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            }
//            // 按旧容量和阈值的2倍计算新容量和阈值的大小
//            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold
//        }
//        else if (oldThr > 0) // initial capacity was placed in threshold
//            /*
//             * 初始化时，将 threshold 的值赋值给 newCap，
//             * HashMap 使用 threshold 变量暂时保存 initialCapacity 参数的值
//             */
//            newCap = oldThr;
//        else {               // zero initial threshold signifies using defaults
//            /*
//             * 调用无参构造方法时，桶数组容量为默认容量，
//             * 阈值为默认容量与默认负载因子乘积
//             */
//            newCap = DEFAULT_INITIAL_CAPACITY;
//            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//        }
//        // newThr 为 0 时，按阈值计算公式进行计算
//        if (newThr == 0) {
//            float ft = (float)newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                (int)ft : Integer.MAX_VALUE);
//        }
//        threshold = newThr;
//        // 创建新的桶数组，桶数组的初始化也是在这里完成的
//        @SuppressWarnings({"rawtypes","unchecked"})
//        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
//        table = newTab;
//        if (oldTab != null) {
//            // 如果旧的桶数组不为空，则遍历桶数组，并将键值对映射到新的桶数组中
//            for (int j = 0; j < oldCap; ++j) {
//                Node<K,V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null)
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof TreeNode)
//                        // 重新映射时，需要对红黑树进行拆分
//                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        Node<K,V> loHead = null, loTail = null;
//                        Node<K,V> hiHead = null, hiTail = null;
//                        Node<K,V> next;
//                        // 遍历链表，并将链表节点按原顺序进行分组
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        // 将分组后的链表映射到新桶中
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;
//    }
//
//
//    static class Node<K,V> implements Map.Entry<K,V> {
//        final int hash;
//        final K key;
//        V value;
//        Node<K,V> next;
//
//        Node(int hash, K key, V value, Node<K,V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        public final K getKey()        { return key; }
//        public final V getValue()      { return value; }
//        public final String toString() { return key + "=" + value; }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (o instanceof Map.Entry) {
//                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                if (Objects.equals(key, e.getKey()) &&
//                    Objects.equals(value, e.getValue()))
//                    return true;
//            }
//            return false;
//        }
//    }
//
//
//    static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
//        TreeNode<K,V> parent;  // red-black tree links
//        TreeNode<K,V> left;
//        TreeNode<K,V> right;
//        TreeNode<K,V> prev;    // needed to unlink next upon deletion
//        boolean red;
//        TreeNode(int hash, K key, V val, Node<K,V> next) {
//            super(hash, key, val, next);
//        }
//
//        /**
//         * Returns root of tree containing this node.
//         */
//        final TreeNode<K,V> root() {
//            for (TreeNode<K,V> r = this, p;;) {
//                if ((p = r.parent) == null)
//                    return r;
//                r = p;
//            }
//        }
//
//        /**
//         * Ensures that the given root is the first node of its bin.
//         */
//        static <K,V> void moveRootToFront(Node<K,V>[] tab, TreeNode<K,V> root) {
//            int n;
//            if (root != null && tab != null && (n = tab.length) > 0) {
//                int index = (n - 1) & root.hash;
//                TreeNode<K,V> first = (TreeNode<K,V>)tab[index];
//                if (root != first) {
//                    Node<K,V> rn;
//                    tab[index] = root;
//                    TreeNode<K,V> rp = root.prev;
//                    if ((rn = root.next) != null)
//                        ((TreeNode<K,V>)rn).prev = rp;
//                    if (rp != null)
//                        rp.next = rn;
//                    if (first != null)
//                        first.prev = root;
//                    root.next = first;
//                    root.prev = null;
//                }
//                assert checkInvariants(root);
//            }
//        }
//
//        /**
//         * Finds the node starting at root p with the given hash and key.
//         * The kc argument caches comparableClassFor(key) upon first use
//         * comparing keys.
//         */
//        final TreeNode<K,V> find(int h, Object k, Class<?> kc) {
//           TreeNode<K,V> p = this;
//            do {
//                int ph, dir; K pk;
//                TreeNode<K,V> pl = p.left, pr = p.right, q;
//                if ((ph = p.hash) > h)
//                    p = pl;
//                else if (ph < h)
//                    p = pr;
//                else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                    return p;
//                else if (pl == null)
//                    p = pr;
//                else if (pr == null)
//                    p = pl;
//                else if ((kc != null ||
//                    (kc = comparableClassFor(k)) != null) &&
//                    (dir = compareComparables(kc, k, pk)) != 0)
//                    p = (dir < 0) ? pl : pr;
//                else if ((q = pr.find(h, k, kc)) != null)
//                    return q;
//                else
//                    p = pl;
//            } while (p != null);
//            return null;
//        }
//
//        /**
//         * Calls find for root node.
//         */
//        final TreeNode<K,V> getTreeNode(int h, Object k) {
//            return ((parent != null) ? root() : this).find(h, k, null);
//        }
//
//        /**
//         * Tie-breaking utility for ordering insertions when equal
//         * hashCodes and non-comparable. We don't require a total
//         * order, just a consistent insertion rule to maintain
//         * equivalence across rebalancings. Tie-breaking further than
//         * necessary simplifies testing a bit.
//         */
//        static int tieBreakOrder(Object a, Object b) {
//            int d;
//            if (a == null || b == null ||
//                (d = a.getClass().getName().
//                    compareTo(b.getClass().getName())) == 0)
//                d = (System.identityHashCode(a) <= System.identityHashCode(b) ?
//                    -1 : 1);
//            return d;
//        }
//
//        /**
//         * Forms tree of the nodes linked from this node.
//         * @return root of tree
//         */
//        final void treeify(Node<K,V>[] tab) {
//            TreeNode<K,V> root = null;
//            for (TreeNode<K,V> x = this, next; x != null; x = next) {
//                next = (TreeNode<K,V>)x.next;
//                x.left = x.right = null;
//                if (root == null) {
//                    x.parent = null;
//                    x.red = false;
//                    root = x;
//                }
//                else {
//                    K k = x.key;
//                    int h = x.hash;
//                    Class<?> kc = null;
//                    for (TreeNode<K,V> p = root;;) {
//                        int dir, ph;
//                        K pk = p.key;
//                        if ((ph = p.hash) > h)
//                            dir = -1;
//                        else if (ph < h)
//                            dir = 1;
//                        else if ((kc == null &&
//                            (kc = comparableClassFor(k)) == null) ||
//                            (dir = compareComparables(kc, k, pk)) == 0)
//                            dir = tieBreakOrder(k, pk);
//
//                        TreeNode<K,V> xp = p;
//                        if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                            x.parent = xp;
//                            if (dir <= 0)
//                                xp.left = x;
//                            else
//                                xp.right = x;
//                            root = balanceInsertion(root, x);
//                            break;
//                        }
//                    }
//                }
//            }
//            moveRootToFront(tab, root);
//        }
//
//        /**
//         * 红黑树链华：链表长度小于等于 6，则将红黑树转成链表
//         */
//        final Node<K,V> untreeify(java.util.HashMap<K,V> map) {
//            Node<K,V> hd = null, tl = null;
//            // 遍历 TreeNode 链表，并用 Node 替换
//            for (Node<K,V> q = this; q != null; q = q.next) {
//                // 替换节点类型
//                Node<K,V> p = map.replacementNode(q, null);
//                if (tl == null)
//                    hd = p;
//                else
//                    tl.next = p;
//                tl = p;
//            }
//            return hd;
//        }
//
//        /**
//         * Tree version of putVal.
//         */
//        final TreeNode<K,V> putTreeVal(java.util.HashMap<K,V> map, Node<K,V>[] tab,
//            int h, K k, V v) {
//            Class<?> kc = null;
//            boolean searched = false;
//            TreeNode<K,V> root = (parent != null) ? root() : this;
//            for (TreeNode<K,V> p = root;;) {
//                int dir, ph; K pk;
//                if ((ph = p.hash) > h)
//                    dir = -1;
//                else if (ph < h)
//                    dir = 1;
//                else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                    return p;
//                else if ((kc == null &&
//                    (kc = comparableClassFor(k)) == null) ||
//                    (dir = compareComparables(kc, k, pk)) == 0) {
//                    if (!searched) {
//                        TreeNode<K,V> q, ch;
//                        searched = true;
//                        if (((ch = p.left) != null &&
//                            (q = ch.find(h, k, kc)) != null) ||
//                            ((ch = p.right) != null &&
//                                (q = ch.find(h, k, kc)) != null))
//                            return q;
//                    }
//                    dir = tieBreakOrder(k, pk);
//                }
//
//                TreeNode<K,V> xp = p;
//                if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                    Node<K,V> xpn = xp.next;
//                    TreeNode<K,V> x = map.newTreeNode(h, k, v, xpn);
//                    if (dir <= 0)
//                        xp.left = x;
//                    else
//                        xp.right = x;
//                    xp.next = x;
//                    x.parent = x.prev = xp;
//                    if (xpn != null)
//                        ((TreeNode<K,V>)xpn).prev = x;
//                    moveRootToFront(tab, balanceInsertion(root, x));
//                    return null;
//                }
//            }
//        }
//
//        /**
//         * Removes the given node, that must be present before this call.
//         * This is messier than typical red-black deletion code because we
//         * cannot swap the contents of an interior node with a leaf
//         * successor that is pinned by "next" pointers that are accessible
//         * independently during traversal. So instead we swap the tree
//         * linkages. If the current tree appears to have too few nodes,
//         * the bin is converted back to a plain bin. (The test triggers
//         * somewhere between 2 and 6 nodes, depending on tree structure).
//         */
//        final void removeTreeNode(java.util.HashMap<K,V> map, Node<K,V>[] tab,
//            boolean movable) {
//            int n;
//            if (tab == null || (n = tab.length) == 0)
//                return;
//            int index = (n - 1) & hash;
//            TreeNode<K,V> first = (TreeNode<K,V>)tab[index], root = first, rl;
//            TreeNode<K,V> succ = (TreeNode<K,V>)next, pred = prev;
//            if (pred == null)
//                tab[index] = first = succ;
//            else
//                pred.next = succ;
//            if (succ != null)
//                succ.prev = pred;
//            if (first == null)
//                return;
//            if (root.parent != null)
//                root = root.root();
//            if (root == null || root.right == null ||
//                (rl = root.left) == null || rl.left == null) {
//                tab[index] = first.untreeify(map);  // too small
//                return;
//            }
//            TreeNode<K,V> p = this, pl = left, pr = right, replacement;
//            if (pl != null && pr != null) {
//                TreeNode<K,V> s = pr, sl;
//                while ((sl = s.left) != null) // find successor
//                    s = sl;
//                boolean c = s.red; s.red = p.red; p.red = c; // swap colors
//                TreeNode<K,V> sr = s.right;
//                TreeNode<K,V> pp = p.parent;
//                if (s == pr) { // p was s's direct parent
//                    p.parent = s;
//                    s.right = p;
//                }
//                else {
//                    TreeNode<K,V> sp = s.parent;
//                    if ((p.parent = sp) != null) {
//                        if (s == sp.left)
//                            sp.left = p;
//                        else
//                            sp.right = p;
//                    }
//                    if ((s.right = pr) != null)
//                        pr.parent = s;
//                }
//                p.left = null;
//                if ((p.right = sr) != null)
//                    sr.parent = p;
//                if ((s.left = pl) != null)
//                    pl.parent = s;
//                if ((s.parent = pp) == null)
//                    root = s;
//                else if (p == pp.left)
//                    pp.left = s;
//                else
//                    pp.right = s;
//                if (sr != null)
//                    replacement = sr;
//                else
//                    replacement = p;
//            }
//            else if (pl != null)
//                replacement = pl;
//            else if (pr != null)
//                replacement = pr;
//            else
//                replacement = p;
//            if (replacement != p) {
//                TreeNode<K,V> pp = replacement.parent = p.parent;
//                if (pp == null)
//                    root = replacement;
//                else if (p == pp.left)
//                    pp.left = replacement;
//                else
//                    pp.right = replacement;
//                p.left = p.right = p.parent = null;
//            }
//
//            TreeNode<K,V> r = p.red ? root : balanceDeletion(root, replacement);
//
//            if (replacement == p) {  // detach
//                TreeNode<K,V> pp = p.parent;
//                p.parent = null;
//                if (pp != null) {
//                    if (p == pp.left)
//                        pp.left = null;
//                    else if (p == pp.right)
//                        pp.right = null;
//                }
//            }
//            if (movable)
//           moveRootToFront(tab, r);
//        }
//
//        /**
//         * 当某个桶节点数量小于6时，会转换为链表，前提是它当前是红黑树结构。
//         */
//        static final int UNTREEIFY_THRESHOLD = 6;
//
//        /**
//         * 红黑树拆分
//         */
//        final void split(java.util.HashMap<K,V> map, Node<K,V>[] tab, int index, int bit) {
//            TreeNode<K,V> b = this;
//            // Relink into lo and hi lists, preserving order
//            TreeNode<K,V> loHead = null, loTail = null;
//            TreeNode<K,V> hiHead = null, hiTail = null;
//            int lc = 0, hc = 0;
//            /*
//             * 红黑树节点仍然保留了 next 引用，故仍可以按链表方式遍历红黑树。
//             * 下面的循环是对红黑树节点进行分组，与上面类似
//             */
//            for (TreeNode<K,V> e = b, next; e != null; e = next) {
//                next = (TreeNode<K,V>)e.next;
//                e.next = null;
//                if ((e.hash & bit) == 0) {
//                    if ((e.prev = loTail) == null)
//                        loHead = e;
//                    else
//                        loTail.next = e;
//                    loTail = e;
//                    ++lc;
//                }
//                else {
//                    if ((e.prev = hiTail) == null)
//                        hiHead = e;
//                    else
//                        hiTail.next = e;
//                    hiTail = e;
//                    ++hc;
//                }
//            }
//
//            if (loHead != null) {
//                // 如果 loHead 不为空，且链表长度小于等于 6，则将红黑树转成链表
//                if (lc <= UNTREEIFY_THRESHOLD)
//                    tab[index] = loHead.untreeify(map);
//                else {
//                    tab[index] = loHead;
//                    /*
//                     * hiHead == null 时，表明扩容后，
//                     * 所有节点仍在原位置，树结构不变，无需重新树化
//                     */
//                    if (hiHead != null) // (else is already treeified)
//                        loHead.treeify(tab);
//                }
//            }
//            // 与上面类似
//            if (hiHead != null) {
//                if (hc <= UNTREEIFY_THRESHOLD)
//                    tab[index + bit] = hiHead.untreeify(map);
//                else {
//                    tab[index + bit] = hiHead;
//                    if (loHead != null)
//                        hiHead.treeify(tab);
//                }
//            }
//        }
//
//        /* ------------------------------------------------------------ */
//        // Red-black tree methods, all adapted from CLR
//
//        static <K,V> TreeNode<K,V> rotateLeft(TreeNode<K,V> root,
//            TreeNode<K,V> p) {
//            TreeNode<K,V> r, pp, rl;
//            if (p != null && (r = p.right) != null) {
//                if ((rl = p.right = r.left) != null)
//                    rl.parent = p;
//                if ((pp = r.parent = p.parent) == null)
//                    (root = r).red = false;
//                else if (pp.left == p)
//                    pp.left = r;
//                else
//                    pp.right = r;
//                r.left = p;
//                p.parent = r;
//            }
//            return root;
//        }
//
//        static <K,V> TreeNode<K,V> rotateRight(TreeNode<K,V> root,
//            TreeNode<K,V> p) {
//            TreeNode<K,V> l, pp, lr;
//            if (p != null && (l = p.left) != null) {
//                if ((lr = p.left = l.right) != null)
//                    lr.parent = p;
//                if ((pp = l.parent = p.parent) == null)
//                    (root = l).red = false;
//                else if (pp.right == p)
//                    pp.right = l;
//                else
//                    pp.left = l;
//                l.right = p;
//                p.parent = l;
//            }
//            return root;
//        }
//
//        static <K,V> TreeNode<K,V> balanceInsertion(TreeNode<K,V> root,
//            TreeNode<K,V> x) {
//            x.red = true;
//            for (TreeNode<K,V> xp, xpp, xppl, xppr;;) {
//                if ((xp = x.parent) == null) {
//                    x.red = false;
//                    return x;
//                }
//                else if (!xp.red || (xpp = xp.parent) == null)
//                    return root;
//                if (xp == (xppl = xpp.left)) {
//                    if ((xppr = xpp.right) != null && xppr.red) {
//                        xppr.red = false;
//                        xp.red = false;
//                        xpp.red = true;
//                        x = xpp;
//                    }
//                    else {
//                        if (x == xp.right) {
//                            root = rotateLeft(root, x = xp);
//                            xpp = (xp = x.parent) == null ? null : xp.parent;
//                        }
//                        if (xp != null) {
//                            xp.red = false;
//                            if (xpp != null) {
//                                xpp.red = true;
//                                root = rotateRight(root, xpp);
//                            }
//                        }
//                    }
//                }
//                else {
//                    if (xppl != null && xppl.red) {
//                        xppl.red = false;
//                        xp.red = false;
//                        xpp.red = true;
//                        x = xpp;
//                    }
//                    else {
//                        if (x == xp.left) {
//                            root = rotateRight(root, x = xp);
//                            xpp = (xp = x.parent) == null ? null : xp.parent;
//                        }
//                        if (xp != null) {
//                            xp.red = false;
//                            if (xpp != null) {
//                                xpp.red = true;
//                                root = rotateLeft(root, xpp);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        static <K,V> TreeNode<K,V> balanceDeletion(TreeNode<K,V> root,
//            TreeNode<K,V> x) {
//            for (TreeNode<K,V> xp, xpl, xpr;;)  {
//                if (x == null || x == root)
//                    return root;
//                else if ((xp = x.parent) == null) {
//                    x.red = false;
//                    return x;
//                }
//                else if (x.red) {
//                    x.red = false;
//                    return root;
//                }
//                else if ((xpl = xp.left) == x) {
//                    if ((xpr = xp.right) != null && xpr.red) {
//                        xpr.red = false;
//                        xp.red = true;
//                        root = rotateLeft(root, xp);
//                        xpr = (xp = x.parent) == null ? null : xp.right;
//                    }
//                    if (xpr == null)
//                        x = xp;
//                    else {
//                        TreeNode<K,V> sl = xpr.left, sr = xpr.right;
//                        if ((sr == null || !sr.red) &&
//                            (sl == null || !sl.red)) {
//                            xpr.red = true;
//                            x = xp;
//                        }
//                        else {
//                            if (sr == null || !sr.red) {
//                                if (sl != null)
//                                    sl.red = false;
//                                xpr.red = true;
//                                root = rotateRight(root, xpr);
//                                xpr = (xp = x.parent) == null ?
//                                    null : xp.right;
//                            }
//                            if (xpr != null) {
//                                xpr.red = (xp == null) ? false : xp.red;
//                                if ((sr = xpr.right) != null)
//                                    sr.red = false;
//                            }
//                            if (xp != null) {
//                                xp.red = false;
//                                root = rotateLeft(root, xp);
//                            }
//                            x = root;
//                        }
//                    }
//                }
//                else { // symmetric
//                    if (xpl != null && xpl.red) {
//                        xpl.red = false;
//                        xp.red = true;
//                        root = rotateRight(root, xp);
//                        xpl = (xp = x.parent) == null ? null : xp.left;
//                    }
//                    if (xpl == null)
//                        x = xp;
//                    else {
//                        TreeNode<K,V> sl = xpl.left, sr = xpl.right;
//                        if ((sl == null || !sl.red) &&
//                            (sr == null || !sr.red)) {
//                            xpl.red = true;
//                            x = xp;
//                        }
//                        else {
//                            if (sl == null || !sl.red) {
//                                if (sr != null)
//                                    sr.red = false;
//                                xpl.red = true;
//                                root = rotateLeft(root, xpl);
//                                xpl = (xp = x.parent) == null ?
//                                    null : xp.left;
//                            }
//                            if (xpl != null) {
//                                xpl.red = (xp == null) ? false : xp.red;
//                                if ((sl = xpl.left) != null)
//                                    sl.red = false;
//                            }
//                            if (xp != null) {
//                                xp.red = false;
//                                root = rotateRight(root, xp);
//                            }
//                            x = root;
//                        }
//                    }
//                }
//            }
//        }
//
//        /**
//         * Recursive invariant check
//         */
//        static <K,V> boolean checkInvariants(TreeNode<K,V> t) {
//            TreeNode<K,V> tp = t.parent, tl = t.left, tr = t.right,
//                tb = t.prev, tn = (TreeNode<K,V>)t.next;
//            if (tb != null && tb.next != t)
//                return false;
//            if (tn != null && tn.prev != t)
//                return false;
//            if (tp != null && t != tp.left && t != tp.right)
//                return false;
//            if (tl != null && (tl.parent != t || tl.hash > t.hash))
//                return false;
//            if (tr != null && (tr.parent != t || tr.hash < t.hash))
//                return false;
//            if (t.red && tl != null && tl.red && tr != null && tr.red)
//                return false;
//            if (tl != null && !checkInvariants(tl))
//                return false;
//            if (tr != null && !checkInvariants(tr))
//                return false;
//            return true;
//        }
//    }
//}
