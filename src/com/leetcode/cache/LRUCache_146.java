package com.leetcode.cache;

import java.util.HashMap;

//函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
public class LRUCache_146 {

    private class Node {

        Node prev;
        Node next;
        int k;
        int v;
        public Node() {}
        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }


    private Node head;
    private Node tail;
    private HashMap<Integer,Node> map;
    private int capcity;

    public LRUCache_146(int capacity) {
        this.capcity = capacity;
        this.map = new HashMap<>(capacity,1);
        head =  new Node();
        tail =  new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        remove(node);
        addHead(node);
        return node.v;
    }


    public void put(int key, int value) {
        Node node =  map.get(key);
        if(node == null){
            node = new Node(key, value);
            if(map.size() == capcity){
                Node tailNode = removeTail();
                map.remove(tailNode.k);
            }
            addHead(node);
            map.put(key,node);
        } else {
            node.v = value;
            remove(node);
            addHead(node);
        }

    }

    //其实remove的是tail.prev
    private Node removeTail() {
        Node node = tail.prev;
        remove(node);
        return node;
    }

    //其实是加到head.next
    private void addHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache_146 cache = new LRUCache_146(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

}
