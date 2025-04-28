import java.rmi.Naming;
import java.util.Scanner;

public class AddClient{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter First Number: ");
            double num1 = sc.nextDouble();
            System.out.println("Enter second number: ");
            double num2 = sc.nextDouble();

            AddServerIntf stub = (AddServerIntf) Naming.lookup("rmi://localhost/AddService");
            double result = stub.addNumbers(num1, num2);

            System.out.println("Result of Addition: " + result);
        } catch (Exception e) {
            System.out.println("Client Exception: " + e.getMessage());
            e.printStackTrace();
        
        }
    }
}