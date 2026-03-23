public class GameFactory {
    public static Game createGame(int x, int n, String lvl) {
        Board board = BoardFactory.createBoard(x);
        PlayStrategy playStrategy;
        if(lvl.equalsIgnoreCase("easy")) playStrategy = new Easy();
        else if(lvl.equalsIgnoreCase("hard")) playStrategy = new Hard();
        else throw new IllegalArgumentException("Invalid lvl");
        return new Game(n, board, playStrategy);
    }
}
