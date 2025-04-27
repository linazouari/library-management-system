import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Borrower");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    addBorrower(library, scanner);
                    break;
                case 3:
                    borrowBook(library, scanner);
                    break;
                case 4:
                    returnBook(library, scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose between 1 and 5.");
            }
        }
    }

    private static void addBook(LibraryService library, Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        
        Book book = new EBook(title, author, isbn);

        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void addBorrower(LibraryService library, Scanner scanner) {
        System.out.print("Enter borrower name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter borrower student ID: ");
        String studentId = scanner.nextLine();
        
        Borrower borrower = new Borrower(name, studentId);
        library.addBorrower(borrower);
        System.out.println("Borrower added successfully.");
    }

    private static void borrowBook(LibraryService library, Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        
        library.borrowBook(isbn, studentId);
    }

    private static void returnBook(LibraryService library, Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        
        library.returnBook(isbn, studentId);
    }
}
