package it.valeriovaudi.matchmanager.support.factory;

import it.valeriovaudi.matchmanager.model.Partita;
import it.valeriovaudi.matchmanager.model.PartitaId;
import it.valeriovaudi.matchmanager.service.ws.dto.match.MatchModelDTO;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/12/14
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class PartitaFactory extends AbstractModelDTOFactory<Partita,MatchModelDTO> {

    private SquadraFactory squadraFactory;


    public void setSquadraFactory(SquadraFactory squadraFactory) {
        this.squadraFactory = squadraFactory;
    }

    @Override
    public MatchModelDTO doGetObject(Partita input) {
            MatchModelDTO matchModelDTO = new MatchModelDTO();

            PartitaId partitaId = input.getPartitaId();

            matchModelDTO.setCampo(partitaId.getCampoId());
            matchModelDTO.setData(simpleDateFormat.format(partitaId.getGiorno()));
            matchModelDTO.setOra(partitaId.getOra());

            matchModelDTO.setSquadra1(squadraFactory.getObject(input.getSquadraSfidante()));
            matchModelDTO.setSquadra2(squadraFactory.getObject(input.getSquadraSfidata()));


            return matchModelDTO;
     }

}
