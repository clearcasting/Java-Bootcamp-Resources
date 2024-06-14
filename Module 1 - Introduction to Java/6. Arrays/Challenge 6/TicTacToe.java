import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            char[][] board = {
                    {'_', '_', '_'},
                    {'_', '_', '_'},
                    {'_', '_', '_'}
            };

            //Task 2: Call the function printBoard();
            printBoard(board);

            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                    System.out.println("Turn: X");
                    int[] a = askUser(board);
                    board[a[0]][a[1]] = 'X';
                    printBoard(board);
                } else {
                    System.out.println("Turn: O");
                    int[] a = askUser(board);
                    board[a[0]][a[1]] = 'O';
                    printBoard(board);
                }

                int count = checkWin(board);
                if (count == 3) {
                    System.out.println("X wins!");
                    System.exit(0);
                } else if (count == -3){
                    System.out.println("O wins!");
                    System.exit(0);
                }
            }
        System.out.println("It's a tie!");
              /*
              {  Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser(). 
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser(). 
                      Task 5: populate the board using askUser's return value. Then, print it.
                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */

            scan.close();
        }


    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */
    public static void printBoard(char[][] board) {
        System.out.println();
        for (char[] row : board) {
            System.out.print("    ");
            for (char value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */
   private static int[] askUser(char[][] board) {
       boolean flag = true;
       int[] position = new int[2];

       while (flag) {
           System.out.print("Pick a row and column number: ");
           String[] answer = scan.nextLine().split(" ");
           position[0] = Integer.parseInt(answer[0]);
           position[1] = Integer.parseInt(answer[1]);
           int x = position[0];
           int y = position[1];

           if (board[x][y] == '_') {
               flag = false;
           } else {
               System.out.println("Sorry this spot is taken try again");
           }
       }
       return position;
   }

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */
    public static int checkWin(char[][] board) {
        int count = 0;
        int rows = checkRows(board);

        // Math.abs returns the absolute value of a given number, removing any negative sign.
        if (Math.abs(rows) == 3) return rows; // If the block of code consists of only one line, you can omit the curly braces.

        int columns = checkColumns(board);
        if (Math.abs(columns) == 3) return columns;

        int leftDiagonal = checkLeft(board);
        if (Math.abs(leftDiagonal) == 3) return leftDiagonal;

        int rightDiagonal = checkRight(board);
        if (Math.abs(rightDiagonal) == 3) return rightDiagonal;

        return count;
    }

    public static int checkRows(char[][] board) {
        int count = 0;

        for (char[] chars : board) {
            if (count == 3 || count == -3) {
                break;
            } else {
                count = 0;
            }
            for (char aChar : chars) {
                if (aChar == 'X') {
                    count++;
                } else if (aChar == 'O'){
                    count--;
                }
                if (count == 3 || count == -3) break;
            }
        }

        return count;
    }


    public static int checkColumns(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            if (count == 3 || count == -3) {
                break;
            } else {
                count = 0;
            }
            for (char[] chars : board) {
                if (chars[i] == 'X') {
                    count++;
                } else if (chars[i] == 'O') {
                    count--;
                }
                if (count == 3 || count == -3) break;
            }
        }

        return count;
    }


    public static int checkLeft(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                count++;
            } else if (board[i][i] == 'O') {
                count--;
            }
            if (count == 3 || count == -3) break;
        }
        return count;
    }


    public static int checkRight(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[2 - i][i] == 'X') {
                count++;
            } else if (board[2 - i][i] == 'O') {
                count--;
            }
            if (count == 3 || count == -3) break;
        }
        return count;
    }



}
