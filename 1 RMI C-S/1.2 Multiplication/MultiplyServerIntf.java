import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultiplyServerIntf extends Remote {
    public int multiply(int a, int b) throws RemoteException;
}
