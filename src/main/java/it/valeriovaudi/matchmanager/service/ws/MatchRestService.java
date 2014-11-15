package it.valeriovaudi.matchmanager.service.ws;

import it.valeriovaudi.matchmanager.service.ws.dto.match.MatchModelDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/6/14
 * Time: 2:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Path(value = "/MatchRestService")
public interface MatchRestService {

    @GET
    @Path(value = "/setReservationFootballFields")
    @Produces("application/json")
    String setReservationFootballFields(@QueryParam("userNamePlayer") String userNamePlayer,
                                        @QueryParam("date") String date,
                                        @QueryParam("hour") String hour,
                                        @QueryParam("footballfield") String footballfield,
                                        @QueryParam("teamName") String teamName);

    @GET
    @Path(value = "/getAllAviableFootballFields")
    @Produces("application/json")
    String getAllAviableFootballFields(@QueryParam("data") String date, @QueryParam("ora") String hour);

    @GET
    @Path(value = "/getAvaiableMatch")
    @Produces("application/json")
    List<MatchModelDTO> getAvaiableMatch(@QueryParam("userNamePlayer") String userNamePlayer,
                                         @QueryParam("data") String data,
                                         @QueryParam("ora") String ora);


    @GET
    @Path(value = "/setReservationMatch")
    @Produces("application/json")
    String setReservationMatch(@QueryParam("userNamePlayer") String userNamePlayer,
                               @QueryParam("data") String date,
                               @QueryParam("ora") String hour,
                               @QueryParam("campo") String footBallField);


    @GET
    @Path(value = "/getAllAvaiableMatch")
    @Produces("application/json")
    String getAllAvaiableMatch(@QueryParam("userNamePlayer") String userNamePlayer,
                               @QueryParam("data") String date);


    @GET
    @Path(value = "/getAllMatchRserved")
    @Produces("application/json")
    String getAllMatchReserved(@QueryParam("userNamePlayer") String userNamePlayer,
                               @QueryParam("data") String date);

}
