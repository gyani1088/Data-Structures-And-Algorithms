package com.lucky.practice;

public class AllocateMinPages {
    public static void main(String[] args) {
        int[] arr = {10,5,3,25,4,4,20};
        System.out.println(allocateMinPages(arr,arr.length,3));
    }
    public static int allocateMinPages(int arr[],int n, int k){
        if(k==1) return sum(arr,0,n-1);
        if(n==1) return arr[0];
        int res = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            res = Math.min(res,Math.max(sum(arr,i,n-1),allocateMinPages(arr,i,k-1)));
        }
        return res;
    }

    public static int minPages_DP(int[] arr,int k){
        int n = arr.length;
        int[][] dp = new int[k+1][n+1];
        for(int i=1;i<=n;i++){
            dp[1][i]=sum(arr,0,n-1);
        }
        for(int i=1;i<=k;i++){
            dp[i][1]=arr[0];
        }
        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++){
                int res= Integer.MAX_VALUE;
                for(int p=1;p<j;p++){
                    res = Math.min(res,Math.max(dp[i-1][p],sum(arr,p,j-1)));
                }
                dp[i][j]=res;
            }
        }
        return dp[k][n];
    }
    private static int sum(int[] arr,int i,int j){
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=arr[k];
        }
        return sum;
    }
}
