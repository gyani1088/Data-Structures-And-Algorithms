package com.lucky.practice;

import java.util.ArrayDeque;

/***
 * Only positive numbers as input
 */

public class StackWithGetMinimumEfficient_PositiveNums extends ArrayDeque<Integer> {
    private Integer min = null;
    public static void main(String[] args) {
            StackWithGetMinimumEfficient_PositiveNums stack = new StackWithGetMinimumEfficient_PositiveNums();
            stack.push(10);
            stack.push(5);
            System.out.println(stack);
            System.out.println(stack.getMin());
    }

    @Override
    public void push(Integer integer) {
        if (super.isEmpty()){
            min=integer;
            super.push(integer);
        }
        else if(min>=integer){
            int temp = integer-min;
            min = integer;
            super.push(temp);
        }
        else super.push(integer);
    }

    @Override
    public Integer pop() {
        int temp = super.pop();
        if(temp<=0){
            int res = min;
            int topVal = min-temp;
            return topVal;
        }
        else return temp;
    }

    //Time complexity: O(n)
    public int getMin(){
        return min;
    }

    @Override
    public Integer peek() {
        int temp = super.peek();
        return (temp<=0)?min:temp;
    }
}
