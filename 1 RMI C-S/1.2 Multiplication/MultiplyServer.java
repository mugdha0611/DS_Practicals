import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MultiplyServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            MultiplyServerImpl multiplication = new MultiplyServerImpl();

            // Create RMI registry
            LocateRegistry.createRegistry(2000);

            // Bind the remote object to the registry
            Naming.rebind("rmi://localhost/MultiplicationService", multiplication);

            System.out.println("Multiplication Server is running...");
        } catch (Exception e) {
            System.out.println("Multiplication Server failed: " + e);
        }
    }
}
