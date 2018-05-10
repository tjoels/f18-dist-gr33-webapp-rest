package rest_services;

import Connector.Connector;
import galgeleg.lobby.Client;
import galgeleg.logik.LobbyInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Path("Login")
public class Login {

    Connector connector;

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String showMessage() {
        return "it works!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean VerifyUser(@FormParam("username") String username, @FormParam("password") String password)
            throws RemoteException, MalformedURLException, NotBoundException {

        LobbyInterface lobbyInterface = (LobbyInterface)
                Naming.lookup("rmi://" + connector.HOSTLOCAL + ":" + connector.PORT +
                        "/" + connector.ENDPOINT);

        System.out.println(username + " : " + password);

        if (!lobbyInterface.login(username, password)) {
            System.out.println("Login failed.");
            return false;
        }

        try {
            new Client(username, lobbyInterface);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;
    }
}
