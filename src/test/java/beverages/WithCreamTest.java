package beverages;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class WithCreamTest {

    public static final double REGULAR_COFFEE_PRICE = 1.2;
    public static final double REGULAR_TEA_PRICE = 1.5;
    public static final double CREAM_OVERHEAD = 0.15;
    private static final double REGULAR_HOT_CHOCOLATE_PRICE = 1.45;

    @Test
    public void adds_fifteen_cents_to_original_price()
    {
        HotChocolate hotChocolate = new HotChocolate();
        WithCream hotChocolateWithCream = new WithCream(hotChocolate);
        assertThat(REGULAR_HOT_CHOCOLATE_PRICE + CREAM_OVERHEAD, is(closeTo(hotChocolateWithCream.price(), 0.001 )) );
    }
}