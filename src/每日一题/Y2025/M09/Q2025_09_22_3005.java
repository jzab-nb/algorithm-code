package 每日一题.Y2025.M09;

public class Q2025_09_22_3005 {
}

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max=0;
        int maxCnt=1;
        int[] cnt = new int[101];
        for(int i:nums){
            cnt[i]++;
            // System.out.printf("%d %d %d %d\n",cnt[1],cnt[2],cnt[3],cnt[4]);
            if(cnt[i]==max){
                maxCnt++;
            }else if(cnt[i]>max){
                maxCnt=1;
                max = cnt[i];
            }
        }
        return max * maxCnt;
    }
}