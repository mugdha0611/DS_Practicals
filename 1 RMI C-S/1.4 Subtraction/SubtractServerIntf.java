import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubtractServerIntf extends Remote {
    public int subtract(int a, int b) throws RemoteException;
}