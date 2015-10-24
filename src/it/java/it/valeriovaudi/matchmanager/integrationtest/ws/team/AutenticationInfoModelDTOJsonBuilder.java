package it.valeriovaudi.matchmanager.integrationtest.ws.team;

import it.valeriovaudi.matchmanager.service.ws.dto.team.AutenticationInfoModelDTO;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.json.Json;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/6/14
 * Time: 4:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class AutenticationInfoModelDTOJsonBuilder {

    public String autenticationInfoModelDTOJsonBuilder(@Multipart(value = "authenticationToken", type = "application/json") AutenticationInfoModelDTO autenticationInfoModelDTO) {

        return Json.createObjectBuilder()
                    .add("userName",autenticationInfoModelDTO.getUserName())
                    .add("password",autenticationInfoModelDTO.getPassword())
                    .build()
                    .toString();
    }

}
