package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(isBalanced("()()(()"));
        System.out.println(isBalanced("{}(()[])"));
    }
    public static boolean matching(char a, char b){
        return ((a=='(' && b==')') ||
                (a=='{' && b=='}') ||
                (a=='[' && b==']'));
    }

    public static boolean isBalanced(String str){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<str.length();i++){
            char x= str.charAt(i);
            if(x=='('||x=='['||x=='{') stack.push(x);
            else{
                if (stack.isEmpty()) return false;
                else if(!matching(stack.peek(),x)) return false;
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
