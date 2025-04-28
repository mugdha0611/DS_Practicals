import java.rmi.*;

public class DivideServer {
public static void main(String args[]) {
try { 
//create remote object
DivideServerImpl divideServerImpl = new DivideServerImpl(); 
//bind the remote object
Naming.rebind("rmi://localhost/DivideServer", divideServerImpl);
}
catch (Exception e) {
System.out.println("Exception: "+ e);
}}}
