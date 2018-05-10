package rest_services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Path("/Game")
public class Game {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String ScreenUpdater() throws RemoteException, NotBoundException, MalformedURLException {
        String output = "it works!";

        return output;
    }

    @POST
    @Path("/Guess={letter}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void GuessLetter(@PathParam("letter")String text) {

    }

    @POST
    @Path("/Restart")
    public void Restart() {

    }
}