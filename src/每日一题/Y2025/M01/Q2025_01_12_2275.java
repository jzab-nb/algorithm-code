package 每日一题.Y2025.M01;

import java.util.Arrays;

public class Q2025_01_12_2275 {
    public int largestCombination(int[] candidates) {
        int[] cnt = new int[24];
        for(int i=0;i<candidates.length;i++){
            int num = candidates[i];
            int j=0;
            while(num>0){
                cnt[j]+=num&1;
                num>>=1;
                j++;
            }
        }
        return Arrays.stream(cnt).max().getAsInt();
    }
}