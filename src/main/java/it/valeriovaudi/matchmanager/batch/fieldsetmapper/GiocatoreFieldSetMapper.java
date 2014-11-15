package it.valeriovaudi.matchmanager.batch.fieldsetmapper;

import it.valeriovaudi.matchmanager.model.Giocatore;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by root on 9/14/14.
 */
public class GiocatoreFieldSetMapper implements FieldSetMapper<Giocatore>{

    /*
    * Valerio,Vaudi,valval,valval,valerio.vaudi@gmail.com,valval
*/
    @Override
    public Giocatore mapFieldSet(FieldSet fieldSet) throws BindException {
        Giocatore giocatore = new Giocatore();

        giocatore.setNome(fieldSet.readRawString(0));
        giocatore.setCognome(fieldSet.readRawString(1));
        giocatore.setCodiceFiscale(fieldSet.readRawString(2));
        giocatore.setUserName(fieldSet.readRawString(3));
        giocatore.setMail(fieldSet.readRawString(4));
        giocatore.setPassword(fieldSet.readRawString(5));

        return giocatore;
    }

}
