package server.logic.rmi;

import brugerautorisation.data.Bruger;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface IGameLobby extends Remote {
    void logIn(String username, String password) throws RemoteException;
    void logOut(String username) throws RemoteException;

    IGameLogic getGameLogicInstance(String username) throws RemoteException;
    List<String> getAllCurrentUserNames() throws RemoteException;
    int getUserAmount() throws RemoteException;
    Bruger getLoggedInUser(String username) throws RemoteException;

    boolean isLoggedIn(String username) throws RemoteException;
    Bruger getUserWithHighestHighscore() throws RemoteException;

    void setUserHighscore(String username, String highscore) throws RemoteException;
    String getUserHighscore(String username) throws RemoteException;
    Map<String, Integer> getAllLoggedInUsersScore() throws RemoteException;
    Map<String, Integer> getAllUsersHighscore() throws RemoteException;

    void sendUserEmail(String username, String password, String subject, String msg) throws RemoteException;
    void sendForgotPasswordEmail(String username, String msg) throws RemoteException;
    void changeUserPassword(String username, String oldPassword, String newPassword) throws RemoteException;
}