package rest_services;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

@Path("/game")
public class GameService  {
// http://localhost:8080/rest/game/test

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        StringBuilder sb = new StringBuilder();
        sb.append("#### ").append(getClass().getSimpleName()).append(" REST Test ####\n");
        sb.append("If you see this, the REST GameService seems to be working! :) ¯\\_(ツ)_/¯");
        return Response.ok().entity(sb.toString()).build();
    }


}