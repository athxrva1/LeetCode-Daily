import java.util.HashSet;

class Solution {
    /*
    This problem looks intimidating in the first glance but we just need to split our solution into three parts:
    1. Check if the sudoku board fulfills the row requirement that "Each row must contain the digits 1-9 without repetition."

    2. Check if it fulfills the column requirement that "Each column must contain the digits 1-9 without repetition."

    3. Check if it has the right subbox such that "Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition."

    If you scroll down to the bottom, "Constraints" section, you'll find that board[i][j] must be a digit from 1 to 9. So all we need to check is if there is any repetition in row, column, and subbox. To support quick lookups, we can use a HashSet.

    A note is that I used two HashSets: checkRow, checkCol in my solution. However, you can just use one, which means that you reuse the HashSet after part 1 by clearing its content and reusing it for part 2.

    Time complexity is O(1) because the nested for loops will run 81 (9 * 9) times. Space complexity is O(n).

    Since I'm a beginner, I'm still looking for ways to improve the time and memory efficiency of my solution, but I'm sure it's an understandable, though not perfect, solution.
    */
    public boolean isValidSudoku(char[][] board) {
        // 1. Check row quality
        for (int row = 0; row < 9; row++) {
            HashSet<Character> checkRow = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.' && checkRow.contains(board[row][col])) {
                    return false;
                }
                checkRow.add(board[row][col]);
            }
        }

        // 2. Check column quality
        for (int col = 0; col < 9; col++) {
            HashSet<Character> checkCol = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.' && checkCol.contains(board[row][col])) {
                    return false;
                }
                checkCol.add(board[row][col]);
            }
        }

        // 3. Check 3*3 sub-boxes
        /*
        Idea here is that we can break the Sudoku board into 9 subboxes, numbered 0, 1, 2, ..., 8, and these box numbers correspond to the index in the HashSet array "checkSubbox".

        Then, we need to find a way to determine which subbox an element should go based on its row and col number. We can use a formula: int location = (row/3) * 3 + col/3. This way, we can put the element into the desired box. One example is coordinate [8, 8]. It should be put into the last subbox (subbox 8). By this formula, it should go to (8/3) * 3 + 8/3 = 2*3 + 2 = 8. You can take other examples to verify but that's pretty much the logic.
        */
        HashSet<Character>[] checkSubbox = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            checkSubbox[i] = new HashSet<>();
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int loc = (row / 3) * 3 + col / 3;
                if (board[row][col] != '.' && checkSubbox[loc].contains(board[row][col])) {
                    return false;
                }
                checkSubbox[loc].add(board[row][col]);
            }
        }
        return true;
    }
}
