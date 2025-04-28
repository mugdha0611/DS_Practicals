import java.rmi.Naming;

public class SubtractClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            SubtractServerIntf stub = (SubtractServerIntf) Naming.lookup("rmi://localhost/SubtractService");

            // Call the remote method
            int result = stub.subtract(10, 5);

            System.out.println("Subtraction result: " + result);
        } catch (Exception e) {
            System.out.println("Subtract Client failed: " + e);
        }
    }
}
