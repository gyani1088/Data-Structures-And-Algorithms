package com.lucky.practice;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "geek";
        System.out.println(minPartitionsForPalindrome(str,0,str.length()-1));
        System.out.println(minPartitions_DP(str));
    }
    public static int minPartitionsForPalindrome(String str, int i, int j){
        if(isPalindrome(str,i,j)) return 0;
        int res = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            res = Math.min(res,1+ minPartitionsForPalindrome(str,i,k)+ minPartitionsForPalindrome(str,k+1,j));
        }
        return res;
    }
    //Time complexity; O(n3)
    public static int minPartitions_DP(String str){
        int n = str.length();
        int dp[][] = new int[n][n];
        boolean[][] isPal = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=0; // because isPalindrome(str,i,i)=true;
            isPal[i][i]=true;
        }
        for(int gap =1;gap<n;gap++){
            for(int i=0;i+gap<n;i++){ //window
                int j = i+gap;
                if(str.charAt(i)==str.charAt(j) && (isPal[i+1][j-1] || gap==1)) {
                    dp[i][j]=0;
                    isPal[i][j]=true;
                }
               // if(isPalindrome(str,i,j)) dp[i][j]=0;
                else{
                    isPal[i][j]=false;
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.min(dp[i][j],1+dp[i][k]+dp[k+1][j]);
                    }
                }
            }
        }
        return  dp[0][n-1];
    }
    private static boolean isPalindrome(String str, int i, int j) {
        boolean isPal = true;
         while(i<j){
             if(str.charAt(i)!=str.charAt(j)){
                 isPal=false;
                 break;
             }
             i++;
             j--;
         }
         return isPal;
    }
}
