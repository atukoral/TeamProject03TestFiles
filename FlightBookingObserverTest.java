import org.junit.Test;
import static org.junit.Assert.*;

public class FlightBookingObserverTest {
     // Test adding an observer
    @Test
    public void testAddObserver() {
        Flight flight = new Flight("F101", "JFK", "LAX", 100);

        PassengerNotification passenger =
                new PassengerNotification("John", "john@email.com");

        flight.addObserver(passenger);

        assertEquals(1, flight.getObservers().size());
    }

    // Test removing an observer
    @Test
    public void testRemoveObserver() {
        Flight flight = new Flight("F102", "JFK", "LAX", 100);

        PassengerNotification passenger =
                new PassengerNotification("John", "john@email.com");

        flight.addObserver(passenger);
        flight.removeObserver(passenger);

        assertEquals(0, flight.getObservers().size());
    }

    // Test notifying a single observer
    @Test
    public void testNotifySingleObserver() {
        Flight flight = new Flight("F103", "JFK", "LAX", 100);

        PassengerNotification passenger =
                new PassengerNotification("John", "john@email.com");

        flight.addObserver(passenger);
        flight.notifyObservers("Flight delayed by 2 hours");

        assertEquals("F103", passenger.getLastFlightId());
        assertEquals("Flight delayed by 2 hours",
                     passenger.getLastMessage());
    }

    // Test notifying multiple observers
    @Test
    public void testNotifyMultipleObservers() {
        Flight flight = new Flight("F104", "JFK", "LAX", 100);

        PassengerNotification passenger1 =
                new PassengerNotification("John", "john@email.com");

        PassengerNotification passenger2 =
                new PassengerNotification("Mary", "mary@email.com");

        flight.addObserver(passenger1);
        flight.addObserver(passenger2);

        flight.notifyObservers("Flight is boarding");

        assertEquals("Flight is boarding",
                     passenger1.getLastMessage());

        assertEquals("Flight is boarding",
                     passenger2.getLastMessage());
    }

    // Test that removed observers do not receive notifications
    @Test
    public void testRemovedObserverDoesNotReceiveNotification() {
        Flight flight = new Flight("F105", "JFK", "LAX", 100);

        PassengerNotification passenger =
                new PassengerNotification("John", "john@email.com");

        flight.addObserver(passenger);
        flight.removeObserver(passenger);

        flight.notifyObservers("Flight cancelled");

        assertNull(passenger.getLastMessage());
    }

    // Test that remaining observers still receive notifications
    @Test
    public void testNotificationAfterRemovingOneObserver() {
        Flight flight = new Flight("F106", "JFK", "LAX", 100);

        PassengerNotification passenger1 =
                new PassengerNotification("John", "john@email.com");

        PassengerNotification passenger2 =
                new PassengerNotification("Mary", "mary@email.com");

        flight.addObserver(passenger1);
        flight.addObserver(passenger2);

        flight.removeObserver(passenger1);
        flight.notifyObservers("Flight is delayed");

        assertNull(passenger1.getLastMessage());

        assertEquals("Flight is delayed",
                     passenger2.getLastMessage());
    }

    // Test notification updates when called multiple times
    @Test
    public void testMultipleNotifications() {
        Flight flight = new Flight("F107", "JFK", "LAX", 100);

        PassengerNotification passenger =
                new PassengerNotification("John", "john@email.com");

        flight.addObserver(passenger);

        flight.notifyObservers("Flight delayed");

        flight.notifyObservers("New departure time: 5 PM");

        assertEquals("New departure time: 5 PM",
                     passenger.getLastMessage());
    }

}
