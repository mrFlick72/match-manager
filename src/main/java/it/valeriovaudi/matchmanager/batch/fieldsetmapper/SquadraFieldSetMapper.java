package it.valeriovaudi.matchmanager.batch.fieldsetmapper;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 9/14/14.
 */
public class SquadraFieldSetMapper implements FieldSetMapper<Squadra> {

    private GiocatoreDAO giocatoreDAO;

    /*
    * team name,referente,giocatori list
    * */
    @Override
    public Squadra mapFieldSet(FieldSet fieldSet) throws BindException {
        Squadra squadra = new Squadra();

        List<Giocatore> formazione = new ArrayList<>(5);

        squadra.setNome(fieldSet.readRawString(0));
        squadra.setReferente(giocatoreDAO.findByUserName(fieldSet.readRawString(1)));

        formazione.add(giocatoreDAO.findByUserName(fieldSet.readRawString(2)));
        formazione.add(giocatoreDAO.findByUserName(fieldSet.readRawString(3)));
        formazione.add(giocatoreDAO.findByUserName(fieldSet.readRawString(4)));
        formazione.add(giocatoreDAO.findByUserName(fieldSet.readRawString(5)));
        formazione.add(giocatoreDAO.findByUserName(fieldSet.readRawString(6)));

        squadra.setGiocatori(formazione);
        return squadra;
    }

    public void setGiocatoreDAO(GiocatoreDAO giocatoreDAO) {
        this.giocatoreDAO = giocatoreDAO;
    }
}
