package 双周赛;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C146 {
    public static void main(String[] args) {
//        new Solution1().countSubarrays(new int[]{1,2,1,4,1});
        new Solution2().countPathsWithXorValue(
                new int[][]{{2, 1, 5},{7, 10, 0},{12, 6, 4}}
                ,11);
    }

    static class Solution1{
        public int countSubarrays(int[] nums) {
            // 第一个数和第三个数的和恰好是第二个数的一半
            int cnt=0;
            for(int i=0;i<nums.length-2;i++){
//                System.out.printf("%d %d %d\n",nums[i],nums[i+1],nums[i+2]);
                if(nums[i+1]%2==0 && nums[i]+nums[i+2]==nums[i+1]/2){
                    cnt++;
                }
            }
            return cnt;
        }
    }

    static class Solution2 {
        public int countPathsWithXorValue(int[][] grid, int k) {
            //1. dp[i][j] 含义 走到i，j处的复合答案的路径条数
            //2. 推导公式
            //3. 初始化
            //4. 方向
            //5. 举例
            int m = grid.length;
            int n = grid[0].length;
            // 先反向遍历出条件数组
            HashSet<Integer>[][] set = new HashSet[m][n];
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    set[i][j]=new HashSet<>();
                    if(i==m-1&&j==n-1) set[i][j].add(k^grid[i][j]);
                    // 不是最后一行，取下一行的值去异或
                    if(i!=m-1){
                        for(int x:set[i+1][j]) set[i][j].add(x^grid[i][j]);
                    }
                    // 不是最后一列，取下一列的值去异或
                    if(j!=n-1){
                        for(int x:set[i][j+1]) set[i][j].add(x^grid[i][j]);
                    }
                }
            }
//            System.out.println(Arrays.deepToString(set));
            // 遍历生成的条件数组
            int[][] dp = new int[m][n];
            dp[0][0]=1;
            return 0;
        }
    }
}


