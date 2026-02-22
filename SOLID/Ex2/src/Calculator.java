class Calculator {
    static TaxCalculator getTaxCalculator(String customerType) {
        return switch(customerType.toLowerCase()) {
            case "student" -> new StudentTax();
            case "staff" -> new StaffTax();
            default -> new DefaultTax();
        };
    }
    
    static DiscountCalculator getDiscountCalculator(String customerType) {
        return switch(customerType.toLowerCase()) {
            case "student" -> new StudentDiscount();
            case "staff" -> new StaffDiscount();
            default -> new DefaultDiscount();
        };
    }
}