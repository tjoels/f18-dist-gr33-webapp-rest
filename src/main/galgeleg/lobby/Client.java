package galgeleg.lobby;

import galgeleg.logik.ClientInterface;
import galgeleg.logik.GalgeInterface;
import galgeleg.logik.LobbyInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements Remote, ClientInterface {

    private final LobbyInterface chatServer;
    private String name;

    public Client(String name, LobbyInterface chatServer) throws RemoteException {
        this.name = name;
        this.chatServer = chatServer;
        this.chatServer.registrer(name, this);
        this.chatServer.sendToAll("Just Connected", this.name);
    }

    public void getMessage(String message) {
        System.out.println(message);
    }

    public void startGame(GalgeInterface galgeInterface) {

    }
}