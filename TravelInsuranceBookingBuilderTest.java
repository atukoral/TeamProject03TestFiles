import org.junit.Test;
import static org.junit.Assert.*;

public class TravelInsuranceBookingBuilderTest {

    @Test
    public void testBasicInsuranceBooking() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY101", 100000).build();

        assertEquals("POLICY101", booking.getPolicyId());
        assertEquals(100000, booking.getCoverageAmount());

        assertFalse(booking.isMedicalCoverage());
        assertFalse(booking.isTripCancellation());
        assertFalse(booking.isLostBaggage());
        assertFalse(booking.isExtremeSportsCoverage());
        assertFalse(booking.isPersonalLiability());
    }

    @Test
    public void testMedicalCoverage() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY102", 150000)
                        .includeMedicalCoverage()
                        .build();

        assertTrue(booking.isMedicalCoverage());
        assertFalse(booking.isTripCancellation());
    }

    @Test
    public void testTripCancellationCoverage() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY103", 200000)
                        .includeTripCancellation()
                        .build();

        assertTrue(booking.isTripCancellation());
    }

    @Test
    public void testLostBaggageCoverage() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY104", 100000)
                        .includeLostBaggage()
                        .build();

        assertTrue(booking.isLostBaggage());
    }

    @Test
    public void testExtremeSportsCoverage() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY105", 250000)
                        .includeExtremeSportsCoverage()
                        .build();

        assertTrue(booking.isExtremeSportsCoverage());
    }

    @Test
    public void testPersonalLiabilityCoverage() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY106", 300000)
                        .includePersonalLiability()
                        .build();

        assertTrue(booking.isPersonalLiability());
    }

    @Test
    public void testCompleteInsuranceBooking() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY107", 500000)
                        .includeMedicalCoverage()
                        .includeTripCancellation()
                        .includeLostBaggage()
                        .includeExtremeSportsCoverage()
                        .includePersonalLiability()
                        .build();

        assertTrue(booking.isMedicalCoverage());
        assertTrue(booking.isTripCancellation());
        assertTrue(booking.isLostBaggage());
        assertTrue(booking.isExtremeSportsCoverage());
        assertTrue(booking.isPersonalLiability());
    }

    @Test
    public void testUniqueInsuranceBookingIDs() {
        TravelInsuranceBooking booking1 =
                new TravelInsuranceBookingBuilder(
                        "POLICY101", 100000).build();

        TravelInsuranceBooking booking2 =
                new TravelInsuranceBookingBuilder(
                        "POLICY102", 200000).build();

        assertNotEquals(
                booking1.getBookingID(),
                booking2.getBookingID());
    }

    @Test
    public void testInsuranceBookingToString() {
        TravelInsuranceBooking booking =
                new TravelInsuranceBookingBuilder(
                        "POLICY108", 250000)
                        .includeMedicalCoverage()
                        .includeLostBaggage()
                        .build();

        String result = booking.toString();

        assertTrue(result.contains("POLICY108"));
        assertTrue(result.contains("250000"));
        assertTrue(result.contains("Medical"));
        assertTrue(result.contains("Lost Baggage"));
    }
}
