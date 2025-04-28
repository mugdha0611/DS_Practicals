import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {

    public AddServerImpl() throws RemoteException {
        super();
    }

    public double addNumbers(double a, double b) throws RemoteException {
        return a + b;
    }
}
