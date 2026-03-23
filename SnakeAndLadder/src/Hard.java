public class Hard implements PlayStrategy {

    public int move(int currPos, int threshold) {
        return helper(currPos, threshold, 0);
    }

    private int helper(int currPos, int threshold, int sixCnt) {
        int rolledNo = Dice.roll();

        if (rolledNo == 6) {
            sixCnt++;
        }

        if (sixCnt == 3) {
            return currPos;
        }

        int newPos = rolledNo + currPos;
        if(newPos > threshold) return currPos;

        return helper(newPos, threshold, sixCnt);
    }
}