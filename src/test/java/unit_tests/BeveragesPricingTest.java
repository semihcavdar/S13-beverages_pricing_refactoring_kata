package unit_tests;

import beverages.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class BeveragesPricingTest {

    public static final double REGULAR_COFFE_PRICE = 1.20;
    public static final double CREAM_OVERHEAD = 0.15;
    public static final double MILK_OVERHEAD = 0.10;

    @Test
    public void computes_coffee_price() {
        Priceable coffee = new Coffee();
        assertThat(coffee.price(), is(closeTo(REGULAR_COFFE_PRICE, 0.001)));
    }

    @Test
    public void computes_tea_price() {
        Priceable tea = new Tea();
        assertThat(tea.price(), is(closeTo(1.50, 0.001)));
    }

    @Test
    public void computes_hot_chocolate_price() {
        Priceable hotChocolate = new HotChocolate();
        assertThat(hotChocolate.price(), is(closeTo(1.45, 0.001)));
    }

    @Test
    public void computes_tea_with_milk_price() {
        Tea teaWithMilk = new TeaWithMilk();
        assertThat(teaWithMilk.price(), is(closeTo(1.60, 0.001)));
    }

    @Test
    public void computes_coffee_with_milk_price() {
        Priceable coffeeWithMilk = new WithMilk(new Coffee());
        assertThat(coffeeWithMilk.price(), is(closeTo(1.30, 0.001)));
    }

    @Test
    public void computes_coffee_with_milk_and_cream_price() {
        Priceable coffeeWithMilkAndCream = new WithCream(new WithMilk(new Coffee()));
        assertThat(coffeeWithMilkAndCream.price(), is(closeTo(1.45, 0.001)));
    }

    @Test
    public void computes_hot_chocolate_with_cream_price() {
        Priceable hotChocolateWithCream = new WithCream(new HotChocolate());
        assertThat(hotChocolateWithCream.price(),  is(closeTo(1.60, 0.001)));
    }

    @Test
    public void allows_compounding_of_supplements()
    {
        Coffee coffee = new Coffee();
        Priceable coffeeWithMilkAndCream = new WithMilk(new WithCream(coffee));

        assertThat(REGULAR_COFFE_PRICE + CREAM_OVERHEAD + MILK_OVERHEAD, is(closeTo(coffeeWithMilkAndCream.price(), 0.001)));
    }
}
