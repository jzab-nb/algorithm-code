package 每日一题.Y2025.M01;

import java.util.Arrays;

public class Q2025_01_13_2270 {
    public static void main(String[] args) {
        System.out.println(new Q2025_01_13_2270().waysToSplitArray(new int[]{10, 4, -8, 7}));
    }

    public int waysToSplitArray(int[] nums) {
        // 下标 1: 前2个元素和（包含当前下标），大于等于后面的元素和
        long[] pre = new long[nums.length];
        long[] after = new long[nums.length];

        pre[0] = nums[0];

        for(int i=1;i<nums.length;i++) pre[i] = pre[i-1]+nums[i];
        for(int i=nums.length-2;i>=0;i--) after[i] = after[i+1]+nums[i+1];
        int cnt=0;
        for(int i=0;i<nums.length-1;i++) {
            if(pre[i]>=after[i]) cnt++;
        }

        return cnt;
    }
}
