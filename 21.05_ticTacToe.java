```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] board = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        boolean gameHasWon = false;
        int moves = 0;

        while (!gameHasWon && moves < 9) {
            displayBoard(board);

            System.out.print("Please enter row (0-2) and column (0-2) to place your mark: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0) {
                board[row][col] = 1;
                moves++;

                if (checkYourWin(board, row)) {
                    gameHasWon = true;
                    displayBoard(board);
                    System.out.println("Congratulations! You've won!");
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        if (!gameHasWon) {
            System.out.println("The game is a draw.");
        }

        scanner.close();
    }

    public static void displayBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkYourWin(int[][] board, int row) {
        for (int j = 0; j < 3; j++) {
            if (board[row][j] != 1) {
                return false;
            }
        }
        return true;
    }
}
```
