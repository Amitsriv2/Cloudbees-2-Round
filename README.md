This README includes information about the Train Ticket System, its features, and how to run the application.

---

# Train Ticket System

The Train Ticket System is a simple Java application that allows users to purchase train tickets, view receipts, manage users, and perform CRUD operations for users.

## Features

- **Purchase Ticket API:** Users can submit a purchase for a train ticket. Details included in the receipt are From, To, User, and the price paid.

- **View Receipt API:** Users can view the details of the receipt for a given email address.

- **View Users by Section API:** Users can view the list of users and their allocated seats based on the requested section (Section A or Section B).

- **Remove User API:** Users can be removed from the train based on their email address.

- **Modify User Seat API:** Users' seats can be modified by providing their email address and the new section.

- **User CRUD Operations:** The application also includes basic CRUD operations for managing users. Users can be added, viewed, and removed.

## How to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/TrainTicketSystem.git
   cd TrainTicketSystem
   ```

2. **Compile and Run:**
   ```bash
   javac TrainTicketSystem.java
   java TrainTicketSystem
   ```

3. **Sample Usage:**
   - The main method in `TrainTicketSystem` contains sample usage of the provided APIs and CRUD operations. You can modify this section or use it as a reference.

## Additional Notes

- The application is designed as a console-based program, and the seat assignment logic is simplified for demonstration purposes. You may want to implement a more sophisticated seat assignment logic based on your requirements.

- The code includes separate classes for `User`, `UserController`, and `Ticket` for better organization and separation of concerns.

Feel free to modify, extend, and adapt the code according to your needs.

---

This README provides a brief overview of the Train Ticket System, how to run it, and additional notes for consideration. 
