class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n], cols = new int[n];
        int diag = 0, antidiag = 0;
        int player = 1;

        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];

            rows[row] += player;
            cols[col] += player;
            // Diagonal
            if (row == col)
                diag += player;
            // Anti-diagonal
            if (row + col == (n - 1))
                antidiag += player;
            // Winning condition
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antidiag) == n)
                return player == 1 ? "A" : "B";
            // Switch player
            player *= -1;
        }
        return moves.length == n * n ? "Draw" : "Pending";
    }
}