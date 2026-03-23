import java.util.HashMap;

public class Board {
    int maxNum;
    HashMap<Integer, IEntity> entities;

    Board(int maxNum, HashMap<Integer, IEntity> entities) {
        this.maxNum = maxNum;
        this.entities = entities;
    }

    public HashMap<Integer, IEntity> getEntities() {
        return entities;
    }

    public int getMaxNum() {
        return maxNum;
    }
}
