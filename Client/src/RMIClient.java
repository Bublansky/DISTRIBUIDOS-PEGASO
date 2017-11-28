
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhone
 */
public class RMIClient 
{
    public static void main(String args[]) throws NotBoundException
    {
        RMIClient client = new RMIClient();
        client.connectServer();
    }

    private void connectServer() throws NotBoundException 
    {
        try
        {
            Registry reg = LocateRegistry.getRegistry("192.168.0.103", RMI.connexionPort);
            RMI rmi = (RMI) reg.lookup(RMI.connectionServer);
            System.out.println("Connected to server '"
                    + RMI.connectionServer + "' at port " + RMI.connexionPort);
            String text = rmi.getData("--> RMI message <--");
            System.out.println("Message received: " + text);
        }
        catch(RemoteException e)
        {
            System.out.println(e);
        }
    }
}
