package 代码随想录.动态规划;

import java.util.Scanner;

public class Q12_01背包压缩 {
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
        // dp[i][j]代码背包容量为j时且能选择前i个物品时，能获得的最大价值
        int[] dp = new int[maxValue+1];
        for(int i=0;i<=maxValue;i++){
            // 初始化第一行
            if(space[0]<=i) dp[i] = value[0];
        }
        for(int i=1;i<n;i++){
            for(int j=maxValue;j>=0;j--){
                // 不放第i个物品
                dp[j] = dp[j];
                // 假如能放第i个物品
                if(j>=space[i]){
                    dp[j] = Math.max(dp[j],dp[j-space[i]]+value[i]);
                }
            }
        }
//        System.out.println(Arrays.toString(space));
//        System.out.println(Arrays.toString(value));
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[maxValue]);
    }
}
