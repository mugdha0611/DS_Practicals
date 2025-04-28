import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SubtractServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            SubtractServerImpl subtract = new SubtractServerImpl();

            // Create RMI registry
            LocateRegistry.createRegistry(2000);

            // Bind the remote object to the registry
            Naming.rebind("rmi://localhost/SubtractService", subtract);

            System.out.println("Subtract Server is running...");
        } catch (Exception e) {
            System.out.println("Subtract Server failed: " + e);
        }
    }
}
