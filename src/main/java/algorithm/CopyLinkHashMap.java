package algorithm;

import java.util.Map;

/**
 * Created by wqc on 2017/8/2.
 */
public class CopyLinkHashMap {
    static class Node<K,V> implements Map.Entry<K,V>
    {
        K key;
        V value;
        Node<K,V> next;

        Node(K key,V value,Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
    static class Entry<K,V> extends Node<K,V>
    {
        Entry<K,V> before;
        Entry<K,V> after;
        Entry(K key,V value,Node next)
        {
            super(key,value,next);
        }
    }

    Entry tail;
    Entry head;

    private void linkNodeLast(Entry p)
    {
        Entry last = tail;
        if(tail == null)
        {
            head = p;
        }else{
            p.before = last;
            last.after =p;
        }
    }

//    Node newNode(K key,V value,Node next)
//    {
//        Entry p = new Entry<K,V>(key,value,next);
//        linkNodeLast(p);
//        return p;
//    }

}
