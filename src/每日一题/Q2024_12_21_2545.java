package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q2024_12_21_2545 {
    public static void main(String[] args) {

    }

    public int[][] sortTheStudents(int[][] score, int k) {
        return Arrays.stream(score)
                .sorted(Comparator.comparingInt(x -> -x[k]))
                .collect(Collectors.toList())
                .toArray(score);
    }
}
