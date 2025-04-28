import java.rmi.Naming;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            EchoServerIntf stub = (EchoServerIntf) Naming.lookup("rmi://localhost/EchoService");
            String response = stub.echo(name);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Client Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
