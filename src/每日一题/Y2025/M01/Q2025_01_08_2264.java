package 每日一题.Y2025.M01;

public class Q2025_01_08_2264 {
    public String largestGoodInteger(String num) {
        int l=0,m=1,r=2;
        int res=0;
        while(r<num.length()){
            if(num.charAt(l)==num.charAt(m) && num.charAt(m)==num.charAt(r)){
                res = Math.max((int)num.charAt(l),res);
            }
            l++;m++;r++;
        }
        if(res==0) return "";
        return new String(new char[]{(char)res,(char)res,(char)res});
    }
}