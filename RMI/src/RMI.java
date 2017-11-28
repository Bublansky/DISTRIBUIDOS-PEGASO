import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote
{
    public static final int connexionPort = 1399;
    public static final String connectionServer = "PEGASO";
    public String getData(String text) throws RemoteException;
}