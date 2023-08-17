package spiralmatrix3;

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows * cols][2];
        int len = 0;
        int d = 0;
        int i = 0;
        int[] directions = new int[] { 0, 1, 0, -1, 0 };
        // starting coords
        matrix[i++] = new int[] { rStart, cStart };

        while (i < rows * cols) {
            // Moving along x-axis, increment by one
            if (d == 0 || d == 2) {
                len++;
            }

            for (int k = 0; k < len; k++) {
                rStart += directions[d];
                cStart += directions[d + 1];
                // Ensure its not out of bounds
                if (rStart < rows && rStart >= 0 && cStart < cols && cStart >= 0) {
                    matrix[i++] = new int[] { rStart, cStart };
                }
            }
            // Cycle through directions
            d = ++d % 4;
        }

        return matrix;
    }
}
