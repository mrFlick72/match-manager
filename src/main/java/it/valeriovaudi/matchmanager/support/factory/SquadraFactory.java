package it.valeriovaudi.matchmanager.support.factory;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.service.ws.dto.player.PlayerModelDTO;
import it.valeriovaudi.matchmanager.service.ws.dto.team.TeamModelDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/12/14
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class SquadraFactory extends AbstractModelDTOFactory<Squadra,TeamModelDTO> {

    private GiocatoreFactory giocatoreFactory;


    @Override
    public TeamModelDTO doGetObject(Squadra input) {
        TeamModelDTO teamModelDTO = new TeamModelDTO();

        if(input!= null) {
            List<PlayerModelDTO> playerModelDTOList = new ArrayList<PlayerModelDTO>();

            teamModelDTO.setTeamName(input.getNome());

            for (Giocatore giocatore : input.getGiocatori()) {
                playerModelDTOList.add(giocatoreFactory.getObject(giocatore));
            }

            teamModelDTO.setGiocatori(playerModelDTOList);

        }

        return teamModelDTO;
    }

    public void setGiocatoreFactory(GiocatoreFactory giocatoreFactory) {
        this.giocatoreFactory = giocatoreFactory;
    }

}
