import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class DivideServerImpl extends UnicastRemoteObject implements DivideServerIntf {
    public DivideServerImpl() throws RemoteException {
        super();
    }

    @Override
    public double divideNumbers(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Cannot divide by zero.");
        }
        return a / b;
    }
}
