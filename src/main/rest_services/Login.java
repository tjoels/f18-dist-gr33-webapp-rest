package rest_services;

import Connector.Connector;
import galgeleg.logik.LobbyInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Path("Login")
public class Login {

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String showMessage() {
        System.out.println("Login accessed");
        return "it works!";
    }

    @POST
    @Path("/Username={username}&Password={password}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean VerifyUser(@PathParam("username") String username, @PathParam("password") String password)
            throws RemoteException, MalformedURLException, NotBoundException {

        Connector connector = new Connector();

        LobbyInterface lobbyInterface = (LobbyInterface)
                Naming.lookup("rmi://" + connector.HOST + ":" + connector.PORT +
                        "/" + connector.ENDPOINT + "");

        if (!lobbyInterface.login(username, password)) {
            System.out.println("Login failed.");
            return false;
        }

        return true;
    }
}
