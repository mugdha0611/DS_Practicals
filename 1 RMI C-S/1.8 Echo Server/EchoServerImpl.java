import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class EchoServerImpl extends UnicastRemoteObject implements EchoServerIntf {
    protected EchoServerImpl() throws RemoteException {
        super();
    }

    public String echo(String name) throws RemoteException {
        return "Hello " + name;
    }
}
