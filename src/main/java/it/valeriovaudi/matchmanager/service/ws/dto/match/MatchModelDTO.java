package it.valeriovaudi.matchmanager.service.ws.dto.match;

import it.valeriovaudi.matchmanager.service.ws.dto.team.TeamModelDTO;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/11/14
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatchModelDTO implements Serializable {

    private String data;
    private String ora;
    private String campo;

    private TeamModelDTO squadra1;
    private TeamModelDTO squadra2;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public TeamModelDTO getSquadra1() {
        return squadra1;
    }

    public void setSquadra1(TeamModelDTO squadra1) {
        this.squadra1 = squadra1;
    }

    public TeamModelDTO getSquadra2() {
        return squadra2;
    }

    public void setSquadra2(TeamModelDTO squadra2) {
        this.squadra2 = squadra2;
    }
}
