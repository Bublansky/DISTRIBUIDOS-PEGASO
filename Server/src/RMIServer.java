import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMI
{
    
    
    public RMIServer() throws RemoteException
    {
        super();
    }
    
    @Override
    public String getData(String text) throws RemoteException
    {
        text = "Hello " + text;
        return text;
    }
    
    public static void main(String args[])
    {
        try
        {
            Registry reg = LocateRegistry.createRegistry(RMI.connexionPort);
            reg.rebind(RMI.connectionServer, new RMIServer());
            System.out.println("Server '" + RMI.connectionServer 
                    + "' started at port " + RMI.connexionPort);
        }
        catch(RemoteException e)
        {
            System.out.println(e);
        }
    }
}