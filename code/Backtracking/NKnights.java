package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        knight(board,0,0,4);
    }
    private static List<String> display(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            list.add(row);
        }
        return list;
    }

    public static boolean isValid(char[][] board, int row, int column) {
        if (row >= 0 && row < board.length && column >= 0 && column < board.length) {
            return true;
        }
        return false;
    }

    public static int knight(char[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return 1;
        }

        if (row == board.length - 1 && col == board.length) {
            return 0;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
        }
        int count = 0;
        if (safeForKnight(board, row, col)) {
            board[row][col] = 'Q';
            count += knight(board, row, col + 1, knights - 1);
            board[row][col] = '.';
        }

        knight(board, row, col + 1, knights);
        return count;
    }

    private static boolean safeForKnight(char[][] board, int row, int column) {
        if (isValid(board, row - 2, column - 1)) {
            if (board[row - 2][column - 1]=='K') {
                return false;
            }
        }
        if (isValid(board, row - 1, column - 2)) {
            if (board[row - 1][column - 2]=='K') {
                return false;
            }
        }
        if (isValid(board, row - 2, column + 1)) {
            if (board[row - 2][column + 1]=='K') {
                return false;
            }
        }
        if (isValid(board, row - 1, column + 2)) {
            if (board[row - 1][column + 2]=='K') {
                return false;
            }
        }
        return true;
    }
}
