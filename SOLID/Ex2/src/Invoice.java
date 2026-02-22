import java.util.*;

public class Invoice {
    private final String id;
    private final List<OrderLine> lines;
    private final Map<String, MenuItem> menu;
    private final double subtotal;
    private final double taxPct;    
    private final double tax;
    private final double discount;
    private final double total;

    public Invoice(String id, List<OrderLine> lines, Map<String, MenuItem> menu, double subtotal, double taxPct, double tax, double discount, double total) {
        this.id = id;
        this.lines = lines;
        this.menu = menu;
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }

    public String getId() { return id; }
    public List<OrderLine> getLines() { return lines; }
    public Map<String, MenuItem> getMenu() { return menu; }
    public double getSubtotal() { return subtotal; }
    public double getTaxPct() { return taxPct; }
    public double getTax() { return tax; }
    public double getDiscount() { return discount; }
    public double getTotal() { return total; }
}
