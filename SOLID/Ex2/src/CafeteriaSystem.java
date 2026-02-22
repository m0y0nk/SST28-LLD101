import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }
        
        TaxCalculator taxCalc = Calculator.getTaxCalculator(customerType);
        DiscountCalculator discountCalc = Calculator.getDiscountCalculator(customerType);

        double taxPct = taxCalc.getTaxPercent();
        double tax = taxCalc.taxAmount(subtotal);

        double discount = discountCalc.discountAmount(subtotal, lines.size());

        double total = subtotal + tax - discount;

        Invoice invoice = new Invoice(invId, lines, menu, subtotal, taxPct, tax, discount, total);

        InvoiceFormatter formatter = new InvoiceFormatter();
        String printable = formatter.format(invoice);

        System.out.println(printable);

        store.save(invoice.getId(), printable);
        System.out.println("Saved invoice: " + invoice.getId() + " (lines=" + store.countLines(invoice.getId()) + ")");
    }
}
 