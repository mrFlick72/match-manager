package it.valeriovaudi.matchmanager.service.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/6/14
 * Time: 2:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Path(value = "/CommonDataRestService")
public interface CommonDataRestService {

    @GET
    @Path(value = "/getAvaiableData")
    @Produces("application/json")
    String getAvaiableData();

}
