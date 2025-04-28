import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AddServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(2000); // Start RMI registry
            AddServerImpl obj = new AddServerImpl();
            Naming.rebind("AddService", obj);
            System.out.println("Addition Server is Ready...");
        } catch (Exception e) {
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
