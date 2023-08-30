package com.lucky.practice;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer,CacheNode> map;
    private int count,capacity;
    private CacheNode head,tail;

    public LRUCache(int capacity) {
        //Map for faster search O(1)
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new CacheNode(0,0);
        tail = new CacheNode(0,0);
        head.next = tail;
        tail.prev = head;
        count=0;
    }

    public void deleteNode(CacheNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addNodeToHead(CacheNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    //fetch the cached data
    public int get(int key){
        if(map.get(key)!=null){
            CacheNode node = map.get(key);
            deleteNode(node);
            addNodeToHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value){
        if(map.get(key) != null){
            CacheNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeToHead(node);
        }
        else{
            CacheNode node = new CacheNode(key,value);
            map.put(key,node);
            if(count<capacity){
                count++;
                addNodeToHead(node);
            }
            else{
                //deleting the map entry, but it doesn't make it null since it's also a part of the linked list
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addNodeToHead(node);
            }
        }
    }

    public static void traversal(CacheNode head){
        CacheNode curr = head;
        while(curr!=null){
            System.out.print(curr.key+":"+curr.value+" ");
            curr= curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(1,10);
        System.out.println("cache:"+cache.map);
        traversal(cache.head);
        cache.set(2,20);
        System.out.println("cache:"+cache.map);
        traversal(cache.head);
        cache.set(3,30);
        System.out.println("cache:"+cache.map);
        traversal(cache.head);
        cache.set(4,40);
        System.out.println("cache:"+cache.map);
        traversal(cache.head);
        cache.get(1);
        System.out.println("cache:"+cache.map);
        traversal(cache.head);
        cache.get(2);
        System.out.println("cache:"+cache.map);
        traversal(cache.head);
        cache.set(4,40);
        System.out.println("cache:"+cache.map);
        traversal(cache.head);
    }
}

class CacheNode{
    int key;
    int value;
    CacheNode prev;
    CacheNode next;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
