package rest_services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.rmi.RemoteException;

@Path("/Game")
public class Game {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String Response() {
        return "it works!";
    }

    @PUT
    @Path("/Guess/Text={text}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String PostLetter(@PathParam("text")String text) throws RemoteException {

//        game.guessLetter(text);
//        game.logStatus();

//        if (game.getGameOver()) {
            //ToDo leave game page and return to lobby.
//        }

//        return game.outputToClient();

        return "something";
    }

    @POST
    @Path("/Restart")
    public String Restart() throws RemoteException {
        //game.restart();
        //return game.visibleWord();
        return "hej";
    }
}