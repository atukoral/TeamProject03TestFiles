import org.junit.Test;
import static org.junit.Assert.*;

public class HotelBookingObserverTest {

	// Test adding an observer
    @Test
    public void testAddObserver() {
        Hotel hotel = new Hotel("H101", "Grand Hotel",
                "New York", 50);

        GuestNotification guest =
                new GuestNotification("John", "john@email.com");

        hotel.addObserver(guest);

        assertEquals(1, hotel.getObservers().size());
    }

    // Test removing an observer
    @Test
    public void testRemoveObserver() {
        Hotel hotel = new Hotel("H102", "Grand Hotel",
                "New York", 50);

        GuestNotification guest =
                new GuestNotification("John", "john@email.com");

        hotel.addObserver(guest);
        hotel.removeObserver(guest);

        assertEquals(0, hotel.getObservers().size());
    }

    // Test notifying a single observer
    @Test
    public void testNotifySingleObserver() {
        Hotel hotel = new Hotel("H103", "Grand Hotel",
                "New York", 50);

        GuestNotification guest =
                new GuestNotification("John", "john@email.com");

        hotel.addObserver(guest);
        hotel.notifyObservers("Rooms are now available");

        assertEquals("H103", guest.getLastHotelId());
        assertEquals("Rooms are now available",
                     guest.getLastMessage());
    }

    // Test notifying multiple observers
    @Test
    public void testNotifyMultipleObservers() {
        Hotel hotel = new Hotel("H104", "Beach Resort",
                "Miami", 100);

        GuestNotification guest1 =
                new GuestNotification("John", "john@email.com");

        GuestNotification guest2 =
                new GuestNotification("Mary", "mary@email.com");

        hotel.addObserver(guest1);
        hotel.addObserver(guest2);

        hotel.notifyObservers("Hotel is fully booked");

        assertEquals("Hotel is fully booked",
                     guest1.getLastMessage());

        assertEquals("Hotel is fully booked",
                     guest2.getLastMessage());
    }

    // Test that removed observers do not receive notifications
    @Test
    public void testRemovedObserverDoesNotReceiveNotification() {
        Hotel hotel = new Hotel("H105", "Grand Hotel",
                "New York", 50);

        GuestNotification guest =
                new GuestNotification("John", "john@email.com");

        hotel.addObserver(guest);
        hotel.removeObserver(guest);

        hotel.notifyObservers("Reservation cancelled");

        assertNull(guest.getLastMessage());
    }

    // Test remaining observers receive notifications
    @Test
    public void testNotificationAfterRemovingOneObserver() {
        Hotel hotel = new Hotel("H106", "Beach Resort",
                "Miami", 100);

        GuestNotification guest1 =
                new GuestNotification("John", "john@email.com");

        GuestNotification guest2 =
                new GuestNotification("Mary", "mary@email.com");

        hotel.addObserver(guest1);
        hotel.addObserver(guest2);

        hotel.removeObserver(guest1);
        hotel.notifyObservers("Room availability updated");

        assertNull(guest1.getLastMessage());

        assertEquals("Room availability updated",
                     guest2.getLastMessage());
    }

    // Test multiple notifications
    @Test
    public void testMultipleNotifications() {
        Hotel hotel = new Hotel("H107", "Grand Hotel",
                "New York", 50);

        GuestNotification guest =
                new GuestNotification("John", "john@email.com");

        hotel.addObserver(guest);

        hotel.notifyObservers("Rooms are fully booked");

        hotel.notifyObservers("A room has become available");

        assertEquals("A room has become available",
                     guest.getLastMessage());
    }

}
