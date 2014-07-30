package it.valeriovaudi.matchmanager.support.factory;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.service.ws.dto.player.PlayerModelDTO;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/12/14
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class GiocatoreFactory extends AbstractModelDTOFactory<Giocatore,PlayerModelDTO> {

    @Override
    public PlayerModelDTO doGetObject(Giocatore input) {
        PlayerModelDTO playerModelDTO = new PlayerModelDTO();

        playerModelDTO.setNome(input.getNome());
        playerModelDTO.setCognome(input.getCognome());


        return playerModelDTO;
    }
}
