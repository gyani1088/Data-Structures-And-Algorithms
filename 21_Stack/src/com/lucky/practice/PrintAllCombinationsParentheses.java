package com.lucky.practice;


public class PrintAllCombinationsParentheses {
    public static void main(String[] args) {
        int n=4;
        printCombinations(new char[2*n],0,n,0,0);
    }
    public static void printCombinations(char[] str,int pos,int n, int open, int close){
        if(close==n){
            for(int i=0;i<2*n;i++){
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }
        else{
            if(open<n){
                str[pos]='(';
                printCombinations(str,pos+1,n,open+1,close);
            }

            if(open>close){
                str[pos]=')';
                printCombinations(str,pos+1,n,open,close+1);
            }
        }
    }
}
