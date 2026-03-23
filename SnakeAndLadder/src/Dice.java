public class Dice {
    public static int roll() {
        int rolledNo = (int) (Math.random()*6)+1;
        System.out.println("Rolled number is : " + rolledNo);
        return rolledNo;
    }
}
