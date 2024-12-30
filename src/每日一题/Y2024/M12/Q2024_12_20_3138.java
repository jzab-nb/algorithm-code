package 每日一题.Y2024.M12;

import java.util.Arrays;

public class Q2024_12_20_3138 {
    public static void main(String[] args) {

    }

    public int minAnagramLength(String s) {
        int[] mem;
        int[] tmp;
        int n = s.length();
        // 枚举重复的长度
        next:
        for(int l=1;l<n;l++){
            mem = new int[26];
            // 无法恰好整除，则跳过
            if(n%l!=0) continue;
            // 遍历是第几个子集
            for(int k=0;k<n/l;k++){
                tmp = new int[26];
                for(int i=k*l;i<k*l+l;i++){
                    if(k==0){
                        mem[s.charAt(i)-'a']++;
                    }else{
                        tmp[s.charAt(i)-'a']++;
                    }
                    // System.out.printf("%d %d %d\n",l,k,i);
                }
                if(k!=0 && !Arrays.equals(mem, tmp)) continue next;
            }
            return l;
        }
        return n;
    }
}
