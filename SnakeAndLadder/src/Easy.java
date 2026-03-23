public class Easy implements PlayStrategy {
    public int move(int currPos, int threshold) {
        int rolledNo = Dice.roll();
        if(rolledNo + currPos > threshold) return currPos;

        int newPos = rolledNo + currPos;

        if(rolledNo == 6) newPos = move(newPos, threshold);

        return newPos;
    }
}
