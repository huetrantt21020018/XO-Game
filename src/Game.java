import java.util.Scanner;

public class Game {

    public static Board board;
    public static String turn;
    public static Scanner scanner;

    public static boolean endGame() {
        if (board.isFull()) {
            System.out.println("Draw!");
            return true;
        }

        CellStatus status = board.hasRow();
        if (status.isEmpty()) return false;

        board.print();
        if (status.isX()) {
            System.out.println("X wins");
        } else {
            System.out.println("0 wins");
        }
        return true;
    }

    public static void nextTurn() {
        System.out.println(turn + " turn:");

        int x = scanner.nextInt(), y = scanner.nextInt();

        if (!board.chooseCell(x, y, turn)) {
            System.out.println("Invalid, please try again!");
            nextTurn();
        } else {
            turn = (turn == "X") ? "O" : "X";
        }
    }

    public static void main(String[] args) {
        System.out.println("Play XO game!!!");

        scanner = new Scanner(System.in);
        board = new Board();
        turn = "X";

        while (true) {
            board.print();

            nextTurn();

            if (endGame()) break;
        }
    }
}