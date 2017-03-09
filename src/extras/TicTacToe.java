package extras;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToe {
    static boolean hasWon(int[][] board) {
        if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) return true;
        else return false;
    }

    @Test
    public void testGame() {
        int[][] testBoard = {{1, -1, 0}, {0, 1, -1}, {0, 0, 1}};
        assertEquals(hasWon(testBoard), true);
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();

        t.testGame();
    }
}