import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBHelper.createTable(); // Ensure table exists
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Generate Fibonacci Series (by term)");
            System.out.println("2. Generate Fibonacci Series (by max value)");
            System.out.println("3. Add Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Delete Expense");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of terms: ");
                    int n = sc.nextInt();
                    FibonacciGenerator.generateUpToTerm(n);
                    break;
                case 2:
                    System.out.print("Enter max value: ");
                    int max = sc.nextInt();
                    FibonacciGenerator.generateUpToValue(max);
                    break;
                case 3:
                    ExpenseManager.addExpense();
                    break;
                case 4:
                    ExpenseManager.viewExpenses();
                    break;
                case 5:
                    ExpenseManager.deleteExpense();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
