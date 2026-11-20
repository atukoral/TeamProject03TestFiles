public class SingletonTest {

    public static void main(String[] args) {

        // =====================================
        // 1. TEST FLIGHT DATABASE SINGLETON
        // =====================================

        System.out.println("===== FLIGHT DATABASE TEST =====");

        FlightDatabase fd1 = FlightDatabase.getInstance();
        FlightDatabase fd2 = FlightDatabase.getInstance();

        // Check Singleton
        System.out.println("Same FlightDatabase object? " + (fd1 == fd2));

        // Check initial records
        System.out.println("Initial flights: " + fd1.getAllFlights().size());

        // Display all flights
        System.out.println("\nAll Flights:");
        for (Flight f : fd1.getAllFlights()) {
            System.out.println(f);
        }

        // Search for a flight
        System.out.println("\nSearch Flight F101:");
        System.out.println(fd1.getFlightById("F101"));

        // Add a new flight
        fd1.addFlight(new Flight("F106", "London", "Tokyo", 300));
        System.out.println("\nFlights after adding F106: " + fd1.getAllFlights().size());

        // Remove a flight
        fd1.removeFlight("F106");
        System.out.println("Flights after removing F106: " + fd1.getAllFlights().size());

        // Disconnect and create a new instance
        fd1.disconnect();
        FlightDatabase fd3 = FlightDatabase.getInstance();
        System.out.println("New FlightDatabase instance? " + (fd1 != fd3));


        // =====================================
        // 2. TEST HOTEL DATABASE SINGLETON
        // =====================================

        System.out.println("\n===== HOTEL DATABASE TEST =====");

        HotelDatabase hd1 = HotelDatabase.getInstance();
        HotelDatabase hd2 = HotelDatabase.getInstance();

        // Check Singleton
        System.out.println("Same HotelDatabase object? " + (hd1 == hd2));

        // Check initial records
        System.out.println("Initial hotels: " + hd1.getAllHotels().size());

        // Display all hotels
        System.out.println("\nAll Hotels:");
        for (Hotel h : hd1.getAllHotels()) {
            System.out.println(h);
        }

        // Search for a hotel
        System.out.println("\nSearch Hotel H101:");
        System.out.println(hd1.getHotelById("H101"));

        // Add a new hotel
        hd1.addHotel(new Hotel("H106", "Ocean View", "Miami", 200));
        System.out.println("\nHotels after adding H106: " + hd1.getAllHotels().size());

        // Remove a hotel
        hd1.removeHotel("H106");
        System.out.println("Hotels after removing H106: " + hd1.getAllHotels().size());

        // Disconnect and create a new instance
        hd1.disconnect();
        HotelDatabase hd3 = HotelDatabase.getInstance();
        System.out.println("New HotelDatabase instance? " + (hd1 != hd3));


        // =====================================
        // 3. TEST INSURANCE DATABASE SINGLETON
        // =====================================

        System.out.println("\n===== INSURANCE DATABASE TEST =====");

        InsuranceDatabase id1 = InsuranceDatabase.getInstance();
        InsuranceDatabase id2 = InsuranceDatabase.getInstance();

        // Check Singleton
        System.out.println("Same InsuranceDatabase object? " + (id1 == id2));

        // Check initial records
        System.out.println("Initial policies: " + id1.getAllPolicies().size());

        // Display all policies
        System.out.println("\nAll Insurance Policies:");
        for (InsurancePolicy p : id1.getAllPolicies()) {
            System.out.println(p);
        }

        // Search for a policy
        System.out.println("\nSearch Policy I101:");
        System.out.println(id1.getPolicyById("I101"));

        // Add a new policy
        id1.addPolicy(new InsurancePolicy("I106", "Premium Coverage", 10000, true));
        System.out.println("\nPolicies after adding I106: " + id1.getAllPolicies().size());

        // Remove a policy
        id1.removePolicy("I106");
        System.out.println("Policies after removing I106: " + id1.getAllPolicies().size());

        // Disconnect and create a new instance
        id1.disconnect();
        InsuranceDatabase id3 = InsuranceDatabase.getInstance();
        System.out.println("New InsuranceDatabase instance? " + (id1 != id3));


        // =====================================
        // END OF TESTS
        // =====================================

        System.out.println("\n===== ALL TESTS COMPLETED =====");
    }
}
