package it.valeriovaudi.matchmanager.service.ws;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import it.valeriovaudi.matchmanager.repository.dao.Interface.SquadraDAO;
import it.valeriovaudi.matchmanager.service.ws.dto.team.AutenticationInfoModelDTO;
import it.valeriovaudi.matchmanager.support.factory.JsonSingleResoltFactory;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/6/14
 * Time: 2:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class TeamRestServiceImpl implements TeamRestService{

    private SquadraDAO squadraDAO;
    private GiocatoreDAO giocatoreDAO;
    private JsonSingleResoltFactory jsonSingleResoltFactory;

    @Override
    public String playerIsRegister(AutenticationInfoModelDTO userAuthenticationInfo) {
        Giocatore userName = giocatoreDAO.findByUserName(userAuthenticationInfo.getUserName());

        boolean result = userName==null ? false :(userAuthenticationInfo.getPassword().equals(userName.getPassword()) ? true : false);
        return  jsonSingleResoltFactory.getJsonSingleResoltFactory("result",result);
    }

    @Override
    public String getAllTeamName(String userNamePlayer) {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        Giocatore byUserName = giocatoreDAO.findByUserName(userNamePlayer);
        List<Squadra> byReferente = squadraDAO.findByReferente(byUserName);

        for (Squadra squadra : byReferente) {
            arrayBuilder.add(squadra.getNome());
        }
        objectBuilder.add("teams",arrayBuilder.build());

        return objectBuilder.build().toString();
    }


    public void setGiocatoreDAO(GiocatoreDAO giocatoreDAO) {
        this.giocatoreDAO = giocatoreDAO;
    }

    public void setJsonSingleResoltFactory(JsonSingleResoltFactory jsonSingleResoltFactory) {
        this.jsonSingleResoltFactory = jsonSingleResoltFactory;
    }

    public void setSquadraDAO(SquadraDAO squadraDAO) {
        this.squadraDAO = squadraDAO;
    }
}
