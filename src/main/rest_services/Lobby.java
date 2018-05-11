package rest_services;

import Connector.Connector;
import galgeleg.logik.LobbyInterface;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Path("Lobby")
public class Lobby {

    @POST
    @Path("/SendMessage/Message={message}")
    public void sendToAll(@PathParam("message") String message)
            throws RemoteException, MalformedURLException, NotBoundException {

        Connector connector = new Connector();

        LobbyInterface lobbyInterface = (LobbyInterface)
                Naming.lookup("rmi://" + connector.HOST + ":" + connector.PORT +
                        "/" + connector.ENDPOINT);

        String from = "test";

        lobbyInterface.sendToAll(message, from);
    }

    @POST
    @Path("/Play")
    public void playGame() throws RemoteException, MalformedURLException, NotBoundException {

        Connector connector = new Connector();

        LobbyInterface lobbyInterface = (LobbyInterface)
                Naming.lookup("rmi://" + connector.HOST + ":" + connector.PORT +
                        "/" + connector.ENDPOINT);

        String username = "test";

        lobbyInterface.joinGameQueue(username);
    }

}
