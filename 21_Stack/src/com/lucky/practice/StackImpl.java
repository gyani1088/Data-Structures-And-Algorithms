package com.lucky.practice;

public class StackImpl {
    private int[] arr;
    private int capacity;
    private int top;

    public StackImpl(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }
    public void push(int x){
        if(top==capacity-1) throw new RuntimeException("Overflow");
        this.top++;
        arr[top]=x;
    }
    public int pop(){
        if(this.isEmpty()) throw  new RuntimeException("Underflow");
        int res = arr[top];
        top--;
        return res;
    }
    public int peek(){
        if(this.isEmpty()) throw  new RuntimeException("Underflow");
        return arr[top];
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return (top==-1);
    }

    public static void main(String[] args) throws Exception {
        StackImpl stack = new StackImpl(10);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        stack.push(30);
    }
}
