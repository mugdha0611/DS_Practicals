import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddServerIntf extends Remote {
    public double addNumbers(double a, double b) throws RemoteException;
}
