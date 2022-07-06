package beverages;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class WithMilkTest {

    public static final double REGULAR_COFFEE_PRICE = 1.2;
    public static final double REGULAR_TEA_PRICE = 1.5;
    public static final double MILK_OVERHEAD = 0.1;
    private static final double REGULAR_HOT_CHOCOLATE_PRICE = 1.45;

    @Test
    public void add_ten_cents_to_original_beverage_price() {
        Coffee coffee = new Coffee();
        WithMilk coffeeWithMilk = new WithMilk(coffee);
        assertThat(REGULAR_COFFEE_PRICE + MILK_OVERHEAD, is(closeTo(coffeeWithMilk.price(), 0.001)));

        Tea tea = new Tea();
        WithMilk teaWithMilk = new WithMilk(tea);
        assertThat(REGULAR_TEA_PRICE + MILK_OVERHEAD, is(closeTo(teaWithMilk.price(), 0.001)));

        HotChocolate hotChocolate = new HotChocolate();
        WithMilk hotChocolateWithMilk = new WithMilk(hotChocolate);
        assertThat(REGULAR_HOT_CHOCOLATE_PRICE + MILK_OVERHEAD, is(closeTo(hotChocolateWithMilk.price(), 0.001)));
    }
}