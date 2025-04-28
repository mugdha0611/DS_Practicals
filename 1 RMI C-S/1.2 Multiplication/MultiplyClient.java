import java.rmi.Naming;

public class MultiplyClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            MultiplyServerIntf stub = (MultiplyServerIntf) Naming.lookup("rmi://localhost/MultiplicationService");

            // Call the remote method
            int result = stub.multiply(10, 5);

            System.out.println("Multiplication result: " + result);
        } catch (Exception e) {
            System.out.println("Multiplication Client failed: " + e);
        }
    }
}
