package 每日一题.Y2025.M01;

import java.util.Arrays;
import java.util.Comparator;

public class Q2025_01_22_1561 {
    public static void main(String[] args) {
        System.out.println(new Q2025_01_22_1561().maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int cnt=0;
        System.out.println(Arrays.toString(piles));
        for(int i=piles.length/3;i<piles.length;i+=2){
            cnt+=piles[i];
        }
        return cnt;
    }
}

// 1, 2, 2, 4, 7, 8