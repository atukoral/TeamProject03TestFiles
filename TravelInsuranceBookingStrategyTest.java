import org.junit.Test;
import static org.junit.Assert.*;

public class TravelInsuranceBookingStrategyTest {
    @Test
    public void testBasicInsurancePricing() {
        InsurancePricingStrategy strategy = new BasicInsurancePricing();

        assertEquals(200.0,
                strategy.calculatePremium(10000.0), 0.001);
    }

    @Test
    public void testPremiumInsurancePricing() {
        InsurancePricingStrategy strategy = new PremiumInsurancePricing();

        assertEquals(500.0,
                strategy.calculatePremium(10000.0), 0.001);
    }

    @Test
    public void testAdventureInsurancePricing() {
        InsurancePricingStrategy strategy = new AdventureInsurancePricing();

        assertEquals(800.0,
                strategy.calculatePremium(10000.0), 0.001);
    }

    @Test
    public void testBasicStrategyInBooking() {
        TravelInsuranceBooking booking = new TravelInsuranceBooking(
                "P101", 10000,
                false, false, false, false, false
        );

        booking.setPricingStrategy(new BasicInsurancePricing());

        assertEquals(200.0, booking.calculatePremium(), 0.001);
    }

    @Test
    public void testPremiumStrategyInBooking() {
        TravelInsuranceBooking booking = new TravelInsuranceBooking(
                "P102", 10000,
                true, true, true, false, false
        );

        booking.setPricingStrategy(new PremiumInsurancePricing());

        assertEquals(500.0, booking.calculatePremium(), 0.001);
    }

    @Test
    public void testAdventureStrategyInBooking() {
        TravelInsuranceBooking booking = new TravelInsuranceBooking(
                "P103", 10000,
                true, true, true, true, true
        );

        booking.setPricingStrategy(new AdventureInsurancePricing());

        assertEquals(800.0, booking.calculatePremium(), 0.001);
    }

}
