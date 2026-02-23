import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {

        BasePriceCalculator baseCalc = Calculator.getBasePriceCalculator(req.roomType);

        double base = baseCalc.calculate();

        double add = 0.0;
        for (AddOn a : req.addOns) {
            AddOnPriceCalculator addOnCalc = Calculator.getAddOnPriceCalculator(a);
            add += addOnCalc.calculate();
        }

        return new Money(base + add);
    }
}
