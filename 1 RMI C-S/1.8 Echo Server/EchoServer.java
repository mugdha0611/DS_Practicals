import java.rmi.Naming;

public class EchoServer {
    public static void main(String[] args) {
        try {
            EchoServerImpl obj = new EchoServerImpl();
            Naming.rebind("rmi://localhost/EchoService", obj);
            System.out.println("Echo Server Ready.");
        } catch (Exception e) {
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
