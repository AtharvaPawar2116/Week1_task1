import java.sql.*;
import java.util.Scanner;

public class ExpenseManager {
    private static Scanner sc = new Scanner(System.in);

    public static void addExpense() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        String sql = "INSERT INTO expenses (amount, category, description, date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, category);
            pstmt.setString(3, description);
            pstmt.setString(4, date);
            pstmt.executeUpdate();
            System.out.println("Expense added.");
        } catch (SQLException e) {
            System.out.println("Add failed: " + e.getMessage());
        }
    }

    public static void viewExpenses() {
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DBHelper.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | Amount | Category | Description | Date");
            while (rs.next()) {
                System.out.printf("%d | %.2f | %s | %s | %s\n",
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getString("date"));
            }
        } catch (SQLException e) {
            System.out.println("View failed: " + e.getMessage());
        }
    }

    public static void deleteExpense() {
        System.out.print("Enter expense ID to delete: ");
        int id = sc.nextInt();
        String sql = "DELETE FROM expenses WHERE id = ?";

        try (Connection conn = DBHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Expense deleted.");
            } else {
                System.out.println("Expense not found.");
            }
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}
