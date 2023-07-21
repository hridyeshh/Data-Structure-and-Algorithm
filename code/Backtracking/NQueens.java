package Backtracking;
import java.util.*;
public class NQueens {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));

    }
    public static int totalNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        return queens(board,0,list);
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        Arrays.fill(board,'.');
        List<List<String>> list = new ArrayList<>();
//        queens(board,0,list);
        return list;
    }
    public static int queens(char[][] board, int row, List<List<String>> list) {
        if (row == board.length) {
            list.add(display(board));
            return 1;
        }
        int count = 0;
        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 'Q';
                count += queens(board, row + 1, list);
                board[row][column] = '.';
            }
        }
        return count;
    }

    private static boolean isSafe(char[][] board, int row, int column) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][column]=='Q') {
                return false;
            }
        }
        // diagonal left
        int maxLeft = Math.min(row, column);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][column - i]=='Q') {
                return false;
            }
        }
        // diagonal right
        int maxRight = Math.min(row, board.length - column - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][column + i]=='Q') {
                return false;
            }
        }
        return true; // if true then in the queen function, we can put 'Q' to that box
    }

    private static List<String> display(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            list.add(row);
        }
        return list;
    }

    public static boolean isValid(boolean[][] board, int row, int column) {
        if (row >= 0 && row < board.length && column >= 0 && column < board.length) {
            return true;
        }
        return false;
    }

    public static void knight(char[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = 'Q';
            knight(board, row, col + 1, knights - 1);
            board[row][col] = '.';
        }

        knight(board, row, col + 1, knights);
    }


    private static boolean safeForKnight(boolean[][] board, int row, int column) {
        if (isValid(board, row - 2, column - 1)) {
            if (board[row - 2][column - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, column - 2)) {
            if (board[row - 1][column - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, column + 1)) {
            if (board[row - 2][column + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, column + 2)) {
            if (board[row - 1][column + 2]) {
                return false;
            }
        }

        return true;
    }

}
