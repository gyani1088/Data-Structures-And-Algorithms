package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangularAreaHistogram {
    public static void main(String[] args) {
        int arr[] ={6,2,5,4,1,5,6};
        System.out.println(largestRectangularArea(arr));
        System.out.println(largestRectangularArea_Method2(arr));
        System.out.println(largestRectangularArea_Efficient(arr));
    }
    //Naive approach
    //Time complexity :O(n)
    public static int largestRectangularArea(int[] arr){
        int n = arr.length;
        int res = 0;
        for(int i=0;i<n;i++){
            int curr = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]) curr+=arr[i];
                else break;
            }
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]) curr+=arr[i];
                else break;
            }
            res=Math.max(curr,res);
        }
        return res;
    }
    //Better solution
    //Time complexity: O(n) but 3 traversal
    /**
     *         arr = [ 6, 2,5,4, 1,5,6]
     * prevSmaller = [-1,-1,1,1,-1,4,5]
     * nextSmaller = [ 1, 4,3,4, 7,7,7]
     *
     * */
    public static int largestRectangularArea_Method2(int arr[]){
        int n = arr.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        prevSmaller[0]=-1;
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            int index = stack.isEmpty()?-1:stack.peek();
            prevSmaller[i]=index;
            stack.push(i);
        }
        System.out.println(Arrays.toString(prevSmaller));
        stack = new ArrayDeque<>();
        stack.push(n-1);
        nextSmaller[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            int index = stack.isEmpty()?n:stack.peek();
            nextSmaller[i]=index;
            stack.push(i);
        }
        System.out.println(Arrays.toString(nextSmaller));
        for(int i=0;i<n;i++){
            // (curr + LHS feasible + RHS feasible) * currHeight
            int curr = (1+(i-prevSmaller[i]-1)+(nextSmaller[i]-i-1))*arr[i];
            res = Math.max(curr,res);
        }
        return res;
    }

    //Time complexity: O(n)
    //Aux space: O(n)
    public static int largestRectangularArea_Efficient(int[] arr){
        int n = arr.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                System.out.println(stack.toString());
                int top = stack.pop();
                //width of rectangle
                int width = (stack.isEmpty())?i:i-stack.peek()-1;
                res = Math.max(res,arr[top]*width);
            }
            stack.push(i);
        }
        //from the right
        while(!stack.isEmpty()){
            int top = stack.pop();
            int width = stack.isEmpty()?n:n-stack.peek()-1;
            res =  Math.max(res,arr[top]*width);
            System.out.println(stack.toString());
        }
        return res;
    }
}
