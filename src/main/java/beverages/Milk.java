package beverages;

public class Milk extends Supplement{
    Beverage beverage;
    public Milk(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double price() {
        return beverage.price() + 0.10;
    }
}
