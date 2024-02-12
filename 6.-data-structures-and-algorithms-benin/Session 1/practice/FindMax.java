import static java.lang.System.out;

import java.util.Arrays;
import java.util.Random;

public class FindMax {
    public static int[][] array = new int[250][];

    static {
        var random = new Random();
        for (int i = 0; i < array.length; ++i) {
            array[i] = random.ints(12, 1, 5000).toArray();
        }
    }

    public static void main(String[] args) {
        int N = array.length;
        int[] max = new int[N];
        for (int i = 0; i < N; ++i) {
            int M = array[i].length;
            int maxValue = 0;
            for (int j = 0; j < M; ++j) {
                maxValue = Math.max(maxValue, array[i][j]);
            }
            max[i] = maxValue;
        }
        out.println("Max values: " + Arrays.toString(max));
    }
}
