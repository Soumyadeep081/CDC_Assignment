package Backtracking;

import java.util.*;

public class NQueens {

    private static boolean isSafeQueen(int row, int col, char[][] board, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private static void solve(int row, int n, char[][] board, List<List<String>> res) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            res.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafeQueen(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(row + 1, n, board, res);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> nQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        solve(0, n, board, res);
        return res;
    }

    private static void printBoard(List<String> board) {
        for (String row : board) System.out.println(row);
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = nQueens(n);
        System.out.println("Number of solutions: " + solutions.size());
        if (!solutions.isEmpty()) {
            System.out.println("First solution:");
            printBoard(solutions.get(0));
        }
    }
}
