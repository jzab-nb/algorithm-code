package 每日一题.Y2025.M01;

import java.util.TreeMap;

public class Q2025_01_03_731 {
    static class MyCalendarTwo {

        private TreeMap<Integer,Integer> map;

        public MyCalendarTwo() {
            map = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            map.put(startTime, map.getOrDefault(startTime, 0) + 1);
            map.put(endTime, map.getOrDefault(endTime, 0) - 1);
            int cnt=0;
            for(int i:map.values()){
                cnt+=i;
                if(cnt>2) return false;
            }
            return true;
        }
    }
}

