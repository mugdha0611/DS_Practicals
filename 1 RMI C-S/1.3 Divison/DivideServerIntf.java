import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DivideServerIntf extends Remote {
    public double divideNumbers(double a, double b) throws RemoteException;
}
