package 每日一题.Y2025.M01;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q2025_01_01_3280 {
    public static void main(String[] args) {
        System.out.println(new Q2025_01_01_3280().convertDateToBinary("2080-02-29"));
    }

    public String convertDateToBinary(String date) {
        return Arrays
                .stream(date.split("-"))
                .map(x->Integer.toBinaryString(Integer.parseInt(x)))
                .collect(Collectors.joining("-"));
//        return "";
    }
}
