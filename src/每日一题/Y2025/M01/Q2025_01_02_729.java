package 每日一题.Y2025.M01;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2025_01_02_729 {
    static class MyCalendar {

        private PriorityQueue<int[]> pq;

        public MyCalendar() {
            pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        }

        public boolean book(int startTime, int endTime) {
            for (int[] x : pq) {
                if(x[1]>startTime && x[0]<=startTime || x[0]<endTime && x[1]>endTime
                || x[0]<=startTime && x[1]>endTime || x[0]>=startTime && x[1]<endTime) return false;
            }
            pq.add(new int[]{startTime, endTime});
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));;
        System.out.println(myCalendar.book(15, 25));;
        System.out.println(myCalendar.book(20, 30));;
        // 25年12月的rw——detailt 更新到24年12月
        //
    }
}
