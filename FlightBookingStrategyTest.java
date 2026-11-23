import org.junit.Test;
import static org.junit.Assert.*;

public class FlightBookingStrategyTest {

    @Test
    public void testEconomyPricing() {
        FlightPricingStrategy strategy = new EconomyPricing();

        assertEquals(500.0, strategy.calculatePrice(500.0), 0.001);
    }

    @Test
    public void testBusinessClassPricing() {
        FlightPricingStrategy strategy = new BusinessClassPricing();

        assertEquals(1250.0, strategy.calculatePrice(500.0), 0.001);
    }

    @Test
    public void testPremiumPricing() {
        FlightPricingStrategy strategy = new PremiumPricing();

        assertEquals(900.0, strategy.calculatePrice(500.0), 0.001);
    }

    @Test
    public void testEconomyStrategyInBooking() {
        FlightBooking booking = new FlightBooking(
                "JFK", "LAX",
                false, false, false, false,
                false, false, false
        );

        booking.setPricingStrategy(new EconomyPricing());

        assertEquals(500.0, booking.calculateTotalPrice(500.0), 0.001);
    }

    @Test
    public void testBusinessClassStrategyInBooking() {
        FlightBooking booking = new FlightBooking(
                "JFK", "LAX",
                true, false, true, false,
                false, false, false
        );

        booking.setPricingStrategy(new BusinessClassPricing());

        assertEquals(1250.0, booking.calculateTotalPrice(500.0), 0.001);
    }

    @Test
    public void testPremiumStrategyInBooking() {
        FlightBooking booking = new FlightBooking(
                "JFK", "LAX",
                false, false, false, false,
                false, false, false
        );

        booking.setPricingStrategy(new PremiumPricing());

        assertEquals(900.0, booking.calculateTotalPrice(500.0), 0.001);
    }

}
