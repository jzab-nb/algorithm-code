package 每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2024_12_24_1705 {
    public int eatenApples(int[] apples, int[] days) {
        int ans=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<apples.length||!pq.isEmpty();i++){
            // 去掉已经腐烂的
            while(!pq.isEmpty() && pq.peek()[0]==i) pq.poll();
            // 当天有苹果,传入腐烂日期和苹果个数
            if(i<apples.length && apples[i]>0) pq.offer(new int[]{i+days[i],apples[i]});
            // 有苹果可以吃
            if(!pq.isEmpty()){
                // 吃一个苹果
                ans++;
                // 吃完了，则去掉当前项
                if(--pq.peek()[1]==0) pq.poll();
            }
        }
        return ans;
    }
}
