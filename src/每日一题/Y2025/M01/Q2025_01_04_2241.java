package 每日一题.Y2025.M01;

import java.util.Arrays;

public class Q2025_01_04_2241 {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0,1,0,1,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(500)));
    }

    static class ATM {

        int[] record;
        int[] M = new int[]{20,50,100,200,500};

        public ATM() {
            record = new int[5];
        }

        public void deposit(int[] banknotesCount) {
            for(int i=0;i<5;i++){
                record[i]+=banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] tmp = new int[5];
            // 有大的优先取大的
            for(int i=4;i>=0;i--){
                int cnt = record[i];
                if(amount>=M[i] && cnt!=0){
                    // 能从当前面额取，并且当前面额还有钱
                    int q = Math.min(amount/M[i],cnt);
                    amount-=M[i]*q;
                    cnt-=q;
                }
                tmp[i] = cnt;
            }
            if(amount==0){
                int[] result = new int[5];
                for(int i=0;i<5;i++){
                    result[i] = record[i]-tmp[i];
                }
                record = tmp;
                return result;
            }else{
                return new int[]{-1};
            }
        }
    }
}
