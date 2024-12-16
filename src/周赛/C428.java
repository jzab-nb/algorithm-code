package 周赛;

import java.util.HashMap;

public class C428 {
    public static void main(String[] args) {
        System.out.println(new Solution1().buttonWithLongestTime(new int[][]{
                {9, 4},
                {19, 5},
                {2, 8},
                {3, 11},
                {2, 15}
        }));
    }

    private static class Solution1 {
        public int buttonWithLongestTime(int[][] events) {
            int pre = 0;
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int[] e:events){
                int use = e[1]-pre;
                if(use>max || use==max && e[0]<maxIndex){
                    max = use;
                    maxIndex = e[0];
                }
                pre = e[1];
            }
            return maxIndex;
        }
    }
}