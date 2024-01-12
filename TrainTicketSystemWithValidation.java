import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TrainTicketSystem {
    private static Map<String, Ticket> ticketDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Sample usage of the APIs
        purchaseTicket("London", "France", "John Doe", "john.doe@example.com", 20, "A");
        viewReceipt("john.doe@example.com");
        viewUsersBySection("A");
        removeUser("john.doe@example.com");
        modifyUserSeat("jane.smith@example.com", "B");
        viewUsersBySection("B");
    }

    // API to submit a purchase for a ticket
    public static void purchaseTicket(String from, String to, String userName, String email, int price, String section) {
        if (validateInput(from, to, userName, email, price, section)) {
            Ticket ticket = new Ticket(from, to, userName, email, price, section);
            ticket.assignSeat();
            ticketDatabase.put(email, ticket);
            System.out.println("Ticket purchased successfully.");
        } else {
            System.out.println("Invalid input. Please check your input and try again.");
        }
    }

    // API to view the details of the receipt for a user
    public static void viewReceipt(String email) {
        Ticket ticket = ticketDatabase.get(email);
        if (ticket != null) {
            System.out.println("Receipt Details:");
            System.out.println("From: " + ticket.getFrom());
            System.out.println("To: " + ticket.getTo());
            System.out.println("User: " + ticket.getUserName());
            System.out.println("Price Paid: $" + ticket.getPrice());
            System.out.println("Seat: " + ticket.getSeat());
        } else {
            System.out.println("Ticket not found for the given email.");
        }
    }

    // API to view users and seats by section
    public static void viewUsersBySection(String section) {
        System.out.println("Users in Section " + section + ":");
        for (Ticket ticket : ticketDatabase.values()) {
            if (ticket.getSection().equals(section)) {
                System.out.println(ticket.getUserName() + " - Seat " + ticket.getSeat());
            }
        }
    }

    // API to remove a user from the train
    public static void removeUser(String email) {
        if (email != null && ticketDatabase.containsKey(email)) {
            ticketDatabase.remove(email);
            System.out.println("User with email " + email + " removed from the train.");
        } else {
            System.out.println("User not found for the given email.");
        }
    }

    // API to modify a user's seat
    public static void modifyUserSeat(String email, String newSection) {
        if (email != null && ticketDatabase.containsKey(email)) {
            Ticket ticket = ticketDatabase.get(email);
            ticket.setSection(newSection);
            ticket.assignSeat(); // Reassign seat in the new section
            System.out.println("Seat for user with email " + email + " modified to Section " + newSection + " - Seat " + ticket.getSeat());
        } else {
            System.out.println("User not found for the given email.");
        }
    }

    // Validate input for ticket purchase
    private static boolean validateInput(String from, String to, String userName, String email, int price, String section) {
        if (from != null && to != null && userName != null && isValidEmail(email) && price > 0 && (section.equals("A") || section.equals("B"))) {
            return true;
        } else {
            return false;
        }
    }

    // Validate email address
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }

    static class Ticket {
        private String from;
        private String to;
        private String userName;
        private String email;
        private int price;
        private String section;
        private int seat;

        public Ticket(String from, String to, String userName, String email, int price, String section) {
            this.from = from;
            this.to = to;
            this.userName = userName;
            this.email = email;
            this.price = price;
            this.section = section;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public String getUserName() {
            return userName;
        }

        public int getPrice() {
            return price;
        }

        public String getSection() {
            return section;
        }

        public int getSeat() {
            return seat;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public void assignSeat() {
            // Simplified seat assignment logic, you might want to implement a more sophisticated logic
            seat = (int) (Math.random() * 100) + 1;
        }
    }
}
