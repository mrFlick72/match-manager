package it.valeriovaudi.matchmanager.service.ws;

import it.valeriovaudi.matchmanager.service.ws.dto.team.AutenticationInfoModelDTO;

import javax.ws.rs.*;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/6/14
 * Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 */
@Path(value = "/TeamRestService")
public interface TeamRestService {

/*    @Path("/playerIsRegister")
    @POST
    @Produces(value = "application/json")
    @Consumes("multipart/form-data")
    JsonSingleResult playerIsRegister(@Multipart(value = "authenticationToken", type = "application/json")  AutenticationInfoModelDTO userAuthenticationInfo);*/

    @Path("/playerIsRegister")
    @POST
    @Produces(value = "application/json")
    @Consumes(value = "application/json")
    String playerIsRegister(AutenticationInfoModelDTO userAuthenticationInfo);


    @Path("/getAllTeamName")
    @GET
    @Produces(value = "application/json")
    String getAllTeamName(@QueryParam("userNamePlayer") String userNamePlayer);
}
