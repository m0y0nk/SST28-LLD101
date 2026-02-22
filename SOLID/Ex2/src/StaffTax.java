public class StaffTax implements TaxCalculator {
    private double taxPercent = 2.0;

    public double getTaxPercent() {
        return taxPercent;
    }

    public double taxAmount(double subtotal) {
        return subtotal * (taxPercent / 100.0);
    }
}
