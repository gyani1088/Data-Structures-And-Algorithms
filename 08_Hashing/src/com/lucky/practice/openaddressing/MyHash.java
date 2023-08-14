package com.lucky.practice.openaddressing;

public class MyHash {
    int arr[];
    int capacity,size;
    MyHash(int capacity){
        this.capacity = capacity;
        this.size=0;
        this.arr = new int[capacity];
        for(int i=0;i<capacity;i++){
            //-1 means the slot is empty slot
            this.arr[i]=-1;
        }
    }
    int hash(int key){
        return key%this.capacity;
    }
    boolean search(int key){
        int h = hash(key);
        int i = h;
        while(this.arr[i]!=-1){
            if(this.arr[i]==key) return true;
            //linear probing
            i = (i+1) % capacity;
            if(i==h) return false;
        }
        return false;
    }

    boolean erase(int key){
        int h = hash(key);
        int i = h;
        while(this.arr[i]!=-1){
            if(this.arr[i]==key) {
                arr[i] = -2;
                return true;
            }
            i=(i+1)%capacity;
            if(i==h) return false;
        }
        return false;
    }

    boolean insert(int key){
        if(size==capacity) return false;
        int i = hash(key);
        while (arr[i]!=-1 && arr[i]!=-2 && arr[i]!=key) i=(i+1)%capacity;
        if(arr[i]==key) return false;
        else{
            arr[i] = key;
            size++;
            return true;
        }
    }
}
