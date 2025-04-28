import java.rmi.Naming;
import java.util.Scanner;

public class DivideClient {
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter First Number: ");
            double num1 = sc.nextDouble();
            System.out.println("Enter second number: ");
            double num2 = sc.nextDouble();

            // Lookup the remote object
            DivideServerIntf stub = (DivideServerIntf) Naming.lookup("rmi://localhost/AddService");

            // Call the remote method
            double result = stub.divideNumbers(num1, num2);

            System.out.println("Result of Division: " + result);
        } catch (Exception e) {
            System.out.println("Client Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
