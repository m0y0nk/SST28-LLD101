public class Calculator {

    public static BasePriceCalculator getBasePriceCalculator(int roomType) {
        return switch (roomType) {
            case LegacyRoomTypes.SINGLE -> new SingleRoom();
            case LegacyRoomTypes.DOUBLE -> new DoubleRoom();
            case LegacyRoomTypes.TRIPLE -> new TripleRoom();
            default -> new DefaultRoom();
        };
    }

    public static AddOnPriceCalculator getAddOnPriceCalculator(AddOn addOn) {
        if (addOn == AddOn.MESS) return new MessAddOnPriceCalculator();
        else if (addOn == AddOn.LAUNDRY) return new LaundryAddOnPriceCalculator();
        else if (addOn == AddOn.GYM) return new GYMAddOnPriceCalculator();
        else return new DefaultAddOnPriceCalculator();
    }
}