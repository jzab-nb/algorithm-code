package 周赛;

import java.util.Arrays;

/**
 * @author JZAB
 */
public class C427 {
    public static void main(String[] args) {
        new Solution3().maxSubarraySum(new int[]{-1,-2,-3,-4,-5},4);
    }
}

class Solution1 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] r = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                r[i] = nums[(i+n+nums[i]%n)%n];
            }else{
                r[i] = nums[(i+nums[i]%n)%n];
            }
        }
        return r;
    }
}
//
// 0,1,2 向左移动1格,等于向右移动2格
// 0,1,2,3 向左移动1格,等于向右移动3格

class Solution2 {
    public int maxRectangleArea(int[][] points) {
        return 0;
    }
}

class Solution3 {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] qzh = new long[n+1];
        // 先计算前缀和
        for(int i=1;i<=n;i++) qzh[i]+=qzh[i-1]+nums[i-1];
        System.out.println("   "+ Arrays.toString(nums) );
        System.out.println(Arrays.toString(qzh) );
        // 记录对k取余的不同数的最小值
        long[] minS = new long[k];
        Arrays.fill(minS,Long.MAX_VALUE/2);
        long max=Long.MIN_VALUE;
        for(int j=0;j<qzh.length;j++){
            // j对k取余,等于i,前面的对k取余也等于i的就是要减去的下标
            int i = j%k;
            // 答案取最大值
            max = Math.max(max,qzh[j]-minS[i]);
            // 出现在j之前的对k取余等于i的最小值
            minS[i] = Math.min(minS[i],qzh[j]);
        }

        return max;
    }
}