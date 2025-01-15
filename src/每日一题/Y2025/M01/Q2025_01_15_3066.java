package 每日一题.Y2025.M01;

import java.util.PriorityQueue;

public class Q2025_01_15_3066 {
    public static void main(String[] args) {
        System.out.println(new Q2025_01_15_3066().minOperations(new int[]{2, 11, 10, 1, 3}, 10));
    }

    public int minOperations(int[] nums, int k) {
        // 最小的两个数删除
        // 添加一个数:2*小+大
        // 直到所有元素都大于等于k
        // 有序队列
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int n:nums){
            pq.add((long)n);
        }
        int cnt=0;
        while(pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            pq.offer(x*2+y);
            cnt++;
        }
        return cnt;
    }
}