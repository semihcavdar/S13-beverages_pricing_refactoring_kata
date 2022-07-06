package beverages;

public class WithMilk implements Priceable {
    private final Priceable beverage;

    public WithMilk(Priceable beverage) {
        this.beverage = beverage;
    }

    @Override
    public double price() {
        return beverage.price() + 0.1;
    }
}
