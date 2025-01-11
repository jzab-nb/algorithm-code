package 每日一题.Y2025.M01;

public class Q2025_01_11_3270 {
    public int generateKey(int num1, int num2, int num3) {
        int ans=0;
        int pow=1;
        while(num1>0&&num2>0&&num3>0){
            ans += pow*Math.min(Math.min(num1%10,num2%10),num3%10);
            pow*=10;
            num1/=10;num2/=10;num3/=10;
        }
        return ans;
    }
}