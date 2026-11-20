import org.junit.Test;
import static org.junit.Assert.*;

public class FlightBookingBuilderTest {

    @Test
    public void testBasicFlightBooking() {
        FlightBooking booking = new FlightBookingBuilder(
                "Minneapolis", "New York").build();

        assertEquals("Minneapolis", booking.getFrom());
        assertEquals("New York", booking.getTo());
        assertFalse(booking.isBusinessClass());
        assertFalse(booking.isExtraBaggage());
        assertFalse(booking.isWindowSeat());
        assertFalse(booking.isSpecialMeal());
        assertFalse(booking.isSpecialAccommodation());
        assertFalse(booking.isTravellingWithKids());
        assertFalse(booking.isTravellingWithServiceAnimal());
    }

    @Test
    public void testBusinessClassBooking() {
        FlightBooking booking = new FlightBookingBuilder(
                "Chicago", "Los Angeles")
                .addBusinessClass().build();

        assertTrue(booking.isBusinessClass());
        assertFalse(booking.isExtraBaggage());
    }

    @Test
    public void testAdditionalFlightOptions() {
        FlightBooking booking = new FlightBookingBuilder(
                "Boston", "Miami")
                .addExtraBaggage()
                .addWindowSeat()
                .addSpecialMeal()
                .build();

        assertTrue(booking.isExtraBaggage());
        assertTrue(booking.isWindowSeat());
        assertTrue(booking.isSpecialMeal());
        assertFalse(booking.isBusinessClass());
    }

    @Test
    public void testSpecialAccommodationAndTravellingWithKids() {
        FlightBooking booking = new FlightBookingBuilder(
                "Seattle", "Denver")
                .addSpecialAccommodation()
                .addTravellingWithKids()
                .build();

        assertTrue(booking.isSpecialAccommodation());
        assertTrue(booking.isTravellingWithKids());
    }

    @Test
    public void testTravellingWithServiceAnimal() {
        FlightBooking booking = new FlightBookingBuilder(
                "Dallas", "Houston")
                .addTravellinWithServiceAnimal()
                .build();

        assertTrue(booking.isTravellingWithServiceAnimal());
    }

    @Test
    public void testCompleteFlightBooking() {
        FlightBooking booking = new FlightBookingBuilder(
                "Minneapolis", "London")
                .addBusinessClass()
                .addExtraBaggage()
                .addWindowSeat()
                .addSpecialMeal()
                .addSpecialAccommodation()
                .addTravellingWithKids()
                .addTravellinWithServiceAnimal()
                .build();

        assertTrue(booking.isBusinessClass());
        assertTrue(booking.isExtraBaggage());
        assertTrue(booking.isWindowSeat());
        assertTrue(booking.isSpecialMeal());
        assertTrue(booking.isSpecialAccommodation());
        assertTrue(booking.isTravellingWithKids());
        assertTrue(booking.isTravellingWithServiceAnimal());
    }

    @Test
    public void testUniqueFlightBookingIDs() {
        FlightBooking booking1 = new FlightBookingBuilder(
                "New York", "Chicago").build();

        FlightBooking booking2 = new FlightBookingBuilder(
                "Chicago", "Boston").build();

        assertNotEquals(
                booking1.getBookingID(),
                booking2.getBookingID());
    }

    @Test
    public void testFlightBookingToString() {
        FlightBooking booking = new FlightBookingBuilder(
                "Minneapolis", "Orlando")
                .addBusinessClass()
                .addExtraBaggage()
                .build();

        String result = booking.toString();

        assertTrue(result.contains("Minneapolis"));
        assertTrue(result.contains("Orlando"));
        assertTrue(result.contains("Business"));
        assertTrue(result.contains("Extra Baggage"));
    }
}
