import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Game {
    int n;
    Board board;
    PlayStrategy playStrategy;
    Queue<Player> players = new LinkedList<>();

    public Game(int n, Board board, PlayStrategy playStrategy) {
        this.n = n;
        this.board = board;
        this.playStrategy = playStrategy;
        for(int i = 0; i<n; i++)
            players.add(new Player(i+1));
    }

    public int getPlayerCnt() {
        return players.size();
    }

    public void makeMove() {
        Player curr = players.poll();
        System.out.println("Current player is " + curr.getId() + ", at position : " + curr.getCurrPos());

        int rolledNo = playStrategy.move(curr.getCurrPos(), board.getMaxNum());
        System.out.println("After rolling the position of player " + curr.getId() + ", is " + rolledNo);

        HashMap<Integer, IEntity> entities = board.getEntities();
        int newPos = rolledNo;
        if(entities.containsKey(newPos)) {
            IEntity entity = entities.get(newPos);
            newPos = entity.e;
            PrinterUtil.print(entity, newPos);
        }

        curr.setCurrPos(newPos);

        if(newPos == board.getMaxNum()) {
            System.out.println("Player "+ curr.getId() + "Won!");
        } else {
            players.add(curr);
        }
    }
}
