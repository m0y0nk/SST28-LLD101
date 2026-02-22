public class InvoiceFormatter {
    
    public String format(Invoice invoice) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoice.getId()).append("\n");

        for (OrderLine l : invoice.getLines()) {
            MenuItem item = invoice.getMenu().get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        
        out.append(String.format("Subtotal: %.2f\n", invoice.getSubtotal()));
        out.append(String.format("Tax(%.0f%%): %.2f\n", invoice.getTaxPct(), invoice.getTax()));
        out.append(String.format("Discount: -%.2f\n", invoice.getDiscount()));
        out.append(String.format("TOTAL: %.2f\n", invoice.getTotal()));

        return out.toString();
    }
}
