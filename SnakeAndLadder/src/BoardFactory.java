import java.util.HashMap;
import java.util.Random;

public class BoardFactory {
    private static final Random rand = new Random();

    public static Board createBoard(int x) {
        HashMap<Integer, IEntity> entities = new HashMap<>();
        int boardSize = x * x;

        generateEntities(entities, x, true, boardSize, x);
        generateEntities(entities, x, false, boardSize, x);

        return new Board(boardSize, entities);
    }

    private static void generateEntities(HashMap<Integer, IEntity> entities, int count, boolean isLadder, int boardSize, int x) {
        int created = 0;
        while (created < count) {
            int start = rand.nextInt(boardSize - 2) + 2;

            if (entities.containsKey(start)) continue;

            int startLvl = (start - 1) / x;
            int end = -1;

            if (isLadder) {
                if (startLvl >= x - 1) continue;

                int minEnd = (startLvl + 1) * x + 1;
                int maxEnd = boardSize - 1;

                if (minEnd >= maxEnd) continue;
                end = rand.nextInt(maxEnd - minEnd + 1) + minEnd;
                entities.put(start, new Ladder(start, end));

            } else {
                if (startLvl == 0) continue;

                int minEnd = 2;
                int maxEnd = startLvl * x;

                if (minEnd >= maxEnd) continue;
                end = rand.nextInt(maxEnd - minEnd + 1) + minEnd;
                entities.put(start, new Snake(start, end));
            }
            created++;
        }
    }
}