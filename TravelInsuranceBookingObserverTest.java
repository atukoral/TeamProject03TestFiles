import org.junit.Test;
import static org.junit.Assert.*;

public class TravelInsuranceBookingObserverTest {

    // Test adding an observer
    @Test
    public void testAddObserver() {
        InsurancePolicy policy = new InsurancePolicy(
                "P101", "Basic Policy", 10000, true);
		String lastMessage = "";
        PolicyholderNotification customer =
                new PolicyholderNotification("John", "john@email.com", policy,lastMessage);

        policy.addObserver(customer);

        assertEquals(1, policy.getObservers().size());
    }

    // Test removing an observer
    @Test
    public void testRemoveObserver() {
        InsurancePolicy policy = new InsurancePolicy(
                "P102", "Premium Policy", 20000, true);
		String lastMessage = "";
        PolicyholderNotification customer =
                new PolicyholderNotification("John", "john@email.com",policy,lastMessage);

        policy.addObserver(customer);
        policy.removeObserver(customer);

        assertEquals(0, policy.getObservers().size());
    }

    // Test notifying a single observer
    @Test
    public void testNotifySingleObserver() {
        InsurancePolicy policy = new InsurancePolicy(
                "P103", "Basic Policy", 10000, true);
		String lastMessage = "";
        PolicyholderNotification customer =
                new PolicyholderNotification("John", "john@email.com",policy,lastMessage);

        policy.addObserver(customer);
        policy.notifyObservers("Policy is no longer available");

        assertEquals("P103", customer.getLastPolicyId());

        assertEquals("Policy is no longer available",
                     customer.getLastMessage());
    }

    // Test notifying multiple observers
    @Test
    public void testNotifyMultipleObservers() {
        InsurancePolicy policy = new InsurancePolicy(
                "P104", "Premium Policy", 20000, true);
		String lastMessage = "";
        PolicyholderNotification customer1 =
                new PolicyholderNotification("John", "john@email.com",policy,lastMessage);

        PolicyholderNotification customer2 =
                new PolicyholderNotification("Mary", "mary@email.com",policy,lastMessage);

        policy.addObserver(customer1);
        policy.addObserver(customer2);

        policy.notifyObservers("Coverage amount has changed");

        assertEquals("Coverage amount has changed",
                     customer1.getLastMessage());

        assertEquals("Coverage amount has changed",
                     customer2.getLastMessage());
    }

    // Test removed observers do not receive notifications
    @Test
    public void testRemovedObserverDoesNotReceiveNotification() {
        InsurancePolicy policy = new InsurancePolicy(
                "P105", "Basic Policy", 10000, true);
		String lastMessage = "";
        PolicyholderNotification customer =
                new PolicyholderNotification("John", "john@email.com",policy,lastMessage);

        policy.addObserver(customer);
        policy.removeObserver(customer);

        policy.notifyObservers("Policy discontinued");

        assertNull(customer.getLastMessage());
    }

    // Test remaining observers receive notifications
    @Test
    public void testNotificationAfterRemovingOneObserver() {
        InsurancePolicy policy = new InsurancePolicy(
                "P106", "Premium Policy", 20000, true);

        PolicyholderNotification customer1 =
                new PolicyholderNotification("John", "john@email.com");

        PolicyholderNotification customer2 =
                new PolicyholderNotification("Mary", "mary@email.com");

        policy.addObserver(customer1);
        policy.addObserver(customer2);

        policy.removeObserver(customer1);

        policy.notifyObservers("Policy coverage updated");

        assertNull(customer1.getLastMessage());

        assertEquals("Policy coverage updated",
                     customer2.getLastMessage());
    }

    // Test multiple notifications
    @Test
    public void testMultipleNotifications() {
        InsurancePolicy policy = new InsurancePolicy(
                "P107", "Basic Policy", 10000, true);

        PolicyholderNotification customer =
                new PolicyholderNotification("John", "john@email.com");

        policy.addObserver(customer);

        policy.notifyObservers("Policy coverage increased");

        policy.notifyObservers("Policy is discontinued");

        assertEquals("Policy is discontinued",
                     customer.getLastMessage());
    }



}

