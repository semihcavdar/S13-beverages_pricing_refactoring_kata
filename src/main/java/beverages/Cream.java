package beverages;

public class Cream extends Supplement{
    Beverage beverage;
    public Cream(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double price() {
        return beverage.price() + 0.15;
    }
}