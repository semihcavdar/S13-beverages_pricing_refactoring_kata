package beverages;

public class WithCream implements Priceable {
    private final Priceable beverage;

    public WithCream(Priceable beverage) {
        this.beverage = beverage;
    }

    @Override
    public double price() {
        return beverage.price() + 0.15;
    }
}
