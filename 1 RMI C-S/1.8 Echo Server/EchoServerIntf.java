import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoServerIntf extends Remote {
    String echo(String name) throws RemoteException;
}
