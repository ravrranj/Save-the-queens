import java.util.Scanner;
import java.util.*;

public class NQueens {

   public static void printBoard(char[][] board){
      for (char[] row: board) {
          System.out.println(new String(row));
      }
      System.out.println();  //Blank line between solutions
   }

    public static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column (upper part)
        for (int i = 0; i < row ; i++) {
            if (board[i][col] == 'Q' ) {
                return false;
            }
        }

        //check upper left diagonal
        for ( int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //check upper right diagonal
        for ( int i = row, j = col; i >= 0 && j < n; i--, j++ ){
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; //Position is safe
    }
    
    public static void solveNQueens(char[][] board, int row, int n ) {
           //Base case : if all queens are placed, print the solution
           if( row == n ) {
            printBoard(board);
            return;
           }
          
           // Try placing a queen in each column
           for ( int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; //Place queen
                solveNQueens(board, row + 1, n);  // Move to the next row
                board[row][col] = '.';  //BackTrack (remove queen)
            }
           }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        // Initialize an empty chessboard
        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }

        System.out.println("\nPossible solutions: ");
        solveNQueens(board, 0, n);
        sc.close();
    }
}