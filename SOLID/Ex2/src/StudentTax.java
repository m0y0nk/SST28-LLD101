public class StudentTax implements TaxCalculator {
    private double taxPercent = 5.0;

    public double getTaxPercent() {
        return taxPercent;
    }

    public double taxAmount(double subtotal) { 
        return subtotal * (taxPercent / 100.0);
    }
}
