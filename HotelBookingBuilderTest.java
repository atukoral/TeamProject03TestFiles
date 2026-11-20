import org.junit.Test;
import static org.junit.Assert.*;

public class HotelBookingBuilderTest {

    @Test
    public void testBasicHotelBooking() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL101", "Single").build();

        assertEquals("HOTEL101", booking.getHotelId());
        assertEquals("Single", booking.getRoomType());
        assertFalse(booking.isBreakfastIncluded());
        assertFalse(booking.isWifiIncluded());
        assertFalse(booking.isSeaView());
        assertFalse(booking.isExtraBed());
        assertFalse(booking.isLateCheckout());
        assertFalse(booking.isTravellingWithPets());
        assertFalse(booking.isSpecialRequests());
    }

    @Test
    public void testBreakfastAndWifiOptions() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL102", "Double")
                .includeBreakfast()
                .includeWifi()
                .build();

        assertTrue(booking.isBreakfastIncluded());
        assertTrue(booking.isWifiIncluded());
        assertFalse(booking.isSeaView());
    }

    @Test
    public void testSeaViewAndExtraBedOptions() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL103", "Suite")
                .addSeaView()
                .addExtraBed()
                .build();

        assertTrue(booking.isSeaView());
        assertTrue(booking.isExtraBed());
    }

    @Test
    public void testLateCheckout() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL104", "Double")
                .allowLateCheckout()
                .build();

        assertTrue(booking.isLateCheckout());
    }

    @Test
    public void testTravellingWithPets() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL105", "Suite")
                .travellingWithPets()
                .build();

        assertTrue(booking.isTravellingWithPets());
    }

    @Test
    public void testSpecialRequests() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL106", "Single")
                .addSpecialRequests()
                .build();

        assertTrue(booking.isSpecialRequests());
    }

    @Test
    public void testCompleteHotelBooking() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL107", "Suite")
                .includeBreakfast()
                .includeWifi()
                .addSeaView()
                .addExtraBed()
                .allowLateCheckout()
                .travellingWithPets()
                .addSpecialRequests()
                .build();

        assertTrue(booking.isBreakfastIncluded());
        assertTrue(booking.isWifiIncluded());
        assertTrue(booking.isSeaView());
        assertTrue(booking.isExtraBed());
        assertTrue(booking.isLateCheckout());
        assertTrue(booking.isTravellingWithPets());
        assertTrue(booking.isSpecialRequests());
    }

    @Test
    public void testUniqueHotelBookingIDs() {
        HotelBooking booking1 = new HotelBookingBuilder(
                "HOTEL101", "Single").build();

        HotelBooking booking2 = new HotelBookingBuilder(
                "HOTEL102", "Double").build();

        assertNotEquals(
                booking1.getBookingID(),
                booking2.getBookingID());
    }

    @Test
    public void testHotelBookingToString() {
        HotelBooking booking = new HotelBookingBuilder(
                "HOTEL108", "Suite")
                .includeBreakfast()
                .addSeaView()
                .build();

        String result = booking.toString();

        assertTrue(result.contains("HOTEL108"));
        assertTrue(result.contains("Suite"));
        assertTrue(result.contains("Breakfast"));
        assertTrue(result.contains("Sea View"));
    }
}
