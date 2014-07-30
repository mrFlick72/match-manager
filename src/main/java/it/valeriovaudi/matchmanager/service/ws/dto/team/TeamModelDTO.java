package it.valeriovaudi.matchmanager.service.ws.dto.team;

import it.valeriovaudi.matchmanager.service.ws.dto.player.PlayerModelDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/11/14
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamModelDTO implements Serializable {

    private String teamName;

    private List<PlayerModelDTO> giocatori;

    public List<PlayerModelDTO> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<PlayerModelDTO> giocatori) {
        this.giocatori = giocatori;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
