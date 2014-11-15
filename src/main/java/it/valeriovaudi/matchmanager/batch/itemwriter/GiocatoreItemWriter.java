package it.valeriovaudi.matchmanager.batch.itemwriter;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.service.activiti.UserService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by root on 9/14/14.
 */
public class GiocatoreItemWriter implements ItemWriter<Giocatore> {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void write(List<? extends Giocatore> giocatores) throws Exception {
        for (Giocatore giocatore : giocatores) {
            userService.create(giocatore.getNome(),
                    giocatore.getCognome(),
                    giocatore.getCodiceFiscale(),
                    giocatore.getMail(),
                    giocatore.getUserName(),
                    giocatore.getPassword());

        }

    }
}
