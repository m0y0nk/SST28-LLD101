public class Player {
    int id;
    int currPos;

    Player(int id) {
        this.id = id;
        this.currPos = 0;
    }

    public int getId() {
        return id;
    }
    public int getCurrPos() {
        return currPos;
    }
    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }
}
