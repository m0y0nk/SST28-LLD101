public class StudentDiscount implements DiscountCalculator {
    public double discountAmount(double subtotal, int distinctLines) {
        return (subtotal >= 180.0) ? 10.0 : 0.0;
    }
}
