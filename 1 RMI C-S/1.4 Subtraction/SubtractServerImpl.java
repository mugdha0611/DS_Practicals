import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class SubtractServerImpl extends UnicastRemoteObject implements SubtractServerIntf {
    public SubtractServerImpl() throws RemoteException {
        super();
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
}