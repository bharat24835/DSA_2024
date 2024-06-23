package Array.Easy;

public class Questio_3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 2},
                {1, 2, 0},
                {0, 2, 0}
        };

        System.out.println(minChangesToY(matrix));

    }
    public static int minChangesToY(int[][] matrix) {
        int n = matrix.length;
        int center = n / 2;

        int minChanges = Integer.MAX_VALUE;
        int[] values = {0, 1, 2};

        for (int v : values) {
            for (int u : values) {
                if (v == u) {
                    continue;
                }

                int changes = 0;

                // Calculate changes for 'Y' structure
                for (int i = 0; i < n; i++) {
                    if (i <= center) {
                        if (matrix[i][i] != v) {
                            changes++;
                        }
                        if (matrix[i][n - i - 1] != v) {
                            changes++;
                        }
                    } else {
                        if (matrix[i][center] != v) {
                            changes++;
                        }
                    }
                }

                // Calculate changes for remaining part of the matrix
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i <= center && (j == i || j == n - i - 1)) {
                            continue;
                        }
                        if (i > center && j == center) {
                            continue;
                        }
                        if (matrix[i][j] != u) {
                            changes++;
                        }
                    }
                }

                minChanges = Math.min(minChanges, changes);
            }
        }

        return minChanges;
    }
}
