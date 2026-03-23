import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladders!!");

        System.out.println("Enter the number of players: ");
        int n = sc.nextInt();

        System.out.println("Enter the 'a' such that the size of board is going to be a * a: ");
        int size = sc.nextInt();

        Game game = GameFactory.createGame(size, n, "hard");

        while(game.getPlayerCnt()!=1) {
            sc.nextLine();
            game.makeMove();
        }
    }
}
