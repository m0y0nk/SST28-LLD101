public class StaffDiscount implements DiscountCalculator {
    public double discountAmount(double subtotal, int distinctLines) {
        return (distinctLines >= 3) ? 15.0 : 5.0;
    }
}