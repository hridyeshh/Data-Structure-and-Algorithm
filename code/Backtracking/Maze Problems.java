package Backtracking;

import java.util.*;
import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
//        System.out.println("There are total "+count(3,3)+" paths");
//        path("",3,3);
//        System.out.println();
//        boolean[][] board = {{true,true,true},{true,true,true},{true,true,true}};
//        pathRestriction("",board,0,0);
//        allPath("",board,0,0);
//        System.out.println(mazeRest("",3,3));
//        System.out.println(mazeDiagonal("",3,3));
        boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("",board, 0,0,path,1);
    }
    public static int count(int row, int column) {

        if(row==1 || column==1) return 1;
        int left = count(row-1,column);
        int right = count(row,column-1);
        int diagonal = count(row-1,column-1);
        return left+right+diagonal;
    }

    public static ArrayList<String> mazeRest(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> set = new ArrayList<>();
        if(r>1){
            set.addAll(mazeRest(p+'D',r-1,c));
        }
        if(c>1){
            set.addAll(mazeRest(p+'R', r, c-1));
        }
        return set;
    }
    public static ArrayList<String> mazeDiagonal(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> set = new ArrayList<>();
        if(r>1 && c>1){
            set.addAll(mazeDiagonal(p+'A', r-1,c-1));
        }

        if(r>1){
            set.addAll(mazeDiagonal(p+'D',r-1,c));
        }
        if(c>1){
            set.addAll(mazeDiagonal(p+'R', r, c-1));
        }
        return set;
    }
    public static void pathRestriction(String p, boolean[][] maze, int r, int c){
        if(r == maze.length-1&&c == maze[0].length-1) {
            System.out.print(p + " ");
            return;
        }

        if(!maze[r][c]) return;

        if(r<maze.length-1) pathRestriction(p+'V',maze,r+1,c);
        if(c<maze[0].length-1) pathRestriction(p+'H',maze,r,c+1);
    }

    public static void allPath(String p, boolean[][] maze, int r, int c){
        if(r== maze.length-1 && c== maze[0].length-1) {
            System.out.print(p+" ");
            return;
        }
        if(!maze[r][c]) return;
        maze[r][c] = false;
        if (r < maze.length - 1) allPath(p + 'D', maze, r+1, c);
        if (c < maze[0].length - 1) allPath(p + 'R', maze, r, c+1);
        if (r > 0) allPath(p + 'U', maze, r-1, c);
        if (c > 0) allPath(p + 'L', maze, r, c-1);
        maze[r][c] = true;
    }
    public static void path(String p, int r, int c){
        if(r==1&&c==1) {
            System.out.print(p+" ");
            return;
        }
        if(r>1) path(p+'V',r-1,c);
        if(c>1) path(p+'H',r,c-1);
        if(r>1&&c>1) path(p+'D',r-1,c-1); // A stands for alternate
    }

    public static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r==maze.length-1 && c == maze[0].length-1){
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;

        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if(r<maze.length-1){
            allPathPrint(p+'D',maze,r+1,c, path, step+1);
        }
        if(c<maze[0].length-1){
            allPathPrint(p+'R',maze,r,c+1,path,step+1);
        }
        if(r>0){
            allPathPrint(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
            allPathPrint(p+'L',maze,r,c-1,path, step+1);
        }
        maze[r][c] = true;
    }
}
