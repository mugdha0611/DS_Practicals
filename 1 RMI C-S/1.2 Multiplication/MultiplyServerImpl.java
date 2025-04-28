import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MultiplyServerImpl extends UnicastRemoteObject implements MultiplyServerIntf {
    public MultiplyServerImpl() throws RemoteException {
        super();
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }
}
