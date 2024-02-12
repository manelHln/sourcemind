import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] A = { { 1, 0 }, { 0, 1 } };
        int[][] B = { { 4, 1 }, { 5, 8 } };

        for (int[] row: multiply(A, B)){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int M = A.length;
        int N = B[0].length;
        int K = A[0].length;

        if (K != B.length) {
            return null;
        }

        int[][] C = new int[M][N];

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                int p = 0;
                for (int k = 0; k < K; ++k) {
                    p += A[i][k] * B[k][j];
                }
                C[i][j] = p;
            }
        }

        return C;
    }
}
