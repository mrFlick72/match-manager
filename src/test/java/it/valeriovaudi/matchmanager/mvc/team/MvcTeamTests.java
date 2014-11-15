package it.valeriovaudi.matchmanager.mvc.team;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.mvc.MvcAbstractTests;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import it.valeriovaudi.matchmanager.repository.dao.Interface.SquadraDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by seminario on 6/2/14.
 */
public class MvcTeamTests extends MvcAbstractTests {

    @Autowired
    private SquadraDAO squadraDAO;

    @Autowired
    private GiocatoreDAO giocatoreDAO;

    @Test
    public void getTeamTest() throws Exception {

        List<Squadra> all = squadraDAO.findALL();
        Assert.assertNotNull(all);

        List<Squadra>  squadre = (List<Squadra>) mockMvc.perform(get("/getSquadre"))
                                                        .andExpect(status().isOk())
                                                        .andExpect(view().name("getSquadre"))
                                                        .andReturn().getRequest().getAttribute("squadre");

        Assert.assertNotNull(squadre);
        Assert.assertEquals(squadre.size(),all.size());
    }


    @Test
    public void initRegisterSquadraFormTest() throws Exception {

        Giocatore referente = getReferente();

        List<Giocatore> giocatoriDisponibili =   giocatoreDAO.findALL();
        List<Giocatore> giocatoriInSquadra = new ArrayList<Giocatore>();
        giocatoriInSquadra.add(referente);

        giocatoriDisponibili.remove(referente);

        mockMvc.perform(get("/registerSquadraForm")
                        .sessionAttr("referente", referente))
                            .andExpect(status().isOk())
                            .andExpect(view().name("registerSquadraForm"))
                            .andExpect(model().attributeExists("giocatoriInSquadra", "giocatoriDisponibili"))
                            .andExpect(model().attribute("giocatoriInSquadra", giocatoriInSquadra))
                            .andExpect(model().attribute("giocatoriDisponibili", giocatoriDisponibili));

    }

    @Test
    public void teamRegisterTest() throws Exception {

        Giocatore referente = getReferente();


        mockMvc.perform(post("/teamRegister")
                            .param("teamNameIn","teamNameTest")
                            .sessionAttr("referente", referente)
                            .sessionAttr("giocatoriInSquadra", getSquadra()))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("registerSquadraForm"));
    }


    private Giocatore getReferente(){
        String userNameIn = "valval";

        Giocatore byCodiceFiscale = giocatoreDAO.findByCodiceFiscale(userNameIn);

        return byCodiceFiscale;
    }

    private List<Giocatore> getSquadra(){
        Giocatore referente = getReferente();

        List<Giocatore> team = new ArrayList<Giocatore>();

        team.add(referente);
        team.add(giocatoreDAO.findByUserName("fiocca"));
        team.add(giocatoreDAO.findByUserName("giova"));
        team.add(giocatoreDAO.findByUserName("lucio"));
        team.add(giocatoreDAO.findByUserName("corr"));

        return team;
    }
}
