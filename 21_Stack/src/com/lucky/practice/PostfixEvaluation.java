package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeSet;

public class PostfixEvaluation {
    public static void main(String[] args) {
        System.out.println(calculatePostfixExpression("10 2 * 3 5 * + 9 -"));
        System.out.println(calculatePostfixExpression("10 2 3 ^ ^"));
    }
    // 10 2 * 3 5 * + 9 -
    public static int calculatePostfixExpression(String str){
        String[] splits = str.split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : splits){
            if(s.matches("\\d+")) stack.push(Integer.parseInt(s));
            else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (s){
                    case "+":
                        stack.push(operand1+operand2);
                        break;
                    case "-":
                        stack.push(operand1-operand2);
                        break;
                    case "*":
                        stack.push(operand1*operand2);
                        break;
                    case "/":
                        stack.push(operand1/operand2);
                        break;
                    case "^":
                        stack.push((int)Math.pow(operand1,operand2));
                        break;
                }
            }
        }
        return stack.pop();
    }
}
