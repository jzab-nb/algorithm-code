package 代码随想录.动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class Q11_01背包 {
    public static void main(String[] args) {
        //第一行包含两个正整数，第一个整数 M 代表研究材料的种类，第二个正整数 N，代表小明的行李空间。
        //
        //第二行包含 M 个正整数，代表每种研究材料的所占空间。
        //
        //第三行包含 M 个正整数，代表每种研究材料的价值。
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxValue = in.nextInt();
        int[] space = new int[n];
        int[] value = new int[n];
        for(int i=0;i<n;i++) space[i] = in.nextInt();
        for(int i=0;i<n;i++) value[i] = in.nextInt();
        int[][] dp = new int[n][maxValue+1];
        for(int i=0;i<=maxValue;i++){
            if(space[0]<=i) dp[0][i] = value[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=maxValue;j++){
                // 不放第i个物品
                dp[i][j] = dp[i-1][j];
                // 假如能放第i个物品
                if(j>=space[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-space[i]]+value[i]);
                }
            }
        }
//        System.out.println(Arrays.toString(space));
//        System.out.println(Arrays.toString(value));
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[n-1][maxValue]);
    }
}
