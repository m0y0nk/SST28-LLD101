public class DefaultTax implements TaxCalculator {
    private double taxPercent = 8.0;

    public double getTaxPercent() {
        return taxPercent;
    }
    
    public double taxAmount(double subtotal) {
        return subtotal * (taxPercent / 100.0);
    }
}
