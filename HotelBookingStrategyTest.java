import org.junit.Test;
import static org.junit.Assert.*;

public class HotelBookingStrategyTest {
	
	@Test
    public void testStandardRoomPricing() {
        HotelPricingStrategy strategy = new StandardRoomPricing();

        assertEquals(600.0, strategy.calculatePrice(200.0, 3), 0.001);
    }

    @Test
    public void testLuxuryRoomPricing() {
        HotelPricingStrategy strategy = new LuxuryRoomPricing();

        assertEquals(1200.0, strategy.calculatePrice(200.0, 3), 0.001);
    }

    @Test
    public void testSeasonalPricing() {
        HotelPricingStrategy strategy = new SeasonalPricing();

        assertEquals(900.0, strategy.calculatePrice(200.0, 3), 0.001);
    }

    @Test
    public void testStandardRoomStrategyInBooking() {
        HotelBooking booking = new HotelBooking(
                "H101", "Single",
                false, false, false, false,
                false, false, false
        );

        booking.setPricingStrategy(new StandardRoomPricing());

        assertEquals(600.0,
                booking.calculateTotalPrice(200.0, 3), 0.001);
    }

    @Test
    public void testLuxuryRoomStrategyInBooking() {
        HotelBooking booking = new HotelBooking(
                "H102", "Suite",
                true, true, true, true,
                false, false, false
        );

        booking.setPricingStrategy(new LuxuryRoomPricing());

        assertEquals(1200.0,
                booking.calculateTotalPrice(200.0, 3), 0.001);
    }

    @Test
    public void testSeasonalStrategyInBooking() {
        HotelBooking booking = new HotelBooking(
                "H103", "Double",
                false, true, false, false,
                false, false, false
        );

        booking.setPricingStrategy(new SeasonalPricing());

        assertEquals(900.0,
                booking.calculateTotalPrice(200.0, 3), 0.001);
    }

   
}
