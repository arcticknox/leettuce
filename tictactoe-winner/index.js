/**
 * @param {number[][]} moves
 * @return {string}
 */

const checkWinnerCondition = (row, col, diag, antidiag, n) => {
    return (Math.abs(row) === n || Math.abs(col) === n || Math.abs(diag) === n || Math.abs(antidiag) === n);
}

const tictactoe = (moves) => {
    let rows = [0, 0, 0];
    let cols = [0, 0, 0];
    let diag = 0; antidiag = 0;
    let player = 1;
    const n = 3;
    for (const [row, col] of moves) {
        rows[row] += player;
        cols[col] += player;
        // Diagonal invariant
        if (row === col) diag += player;
        // Antidiagonal invariant
        if (row + col === (n - 1)) antidiag += player;
        // Check winner
        if (checkWinnerCondition(rows[row], cols[col], diag, antidiag, n)) {
            return player === 1 ? 'A' : 'B';
        }
        // Switch player
        player *= -1;
    }
    return moves.length === n * n ? 'Draw' : 'Pending';
};