package it.valeriovaudi.matchmanager.unit.mvc.player;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.unit.mvc.MvcAbstractTests;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by seminario on 6/2/14.
 */
public class PlayerMvcTests extends MvcAbstractTests{

    @Autowired
    private GiocatoreDAO giocatoreDAO;

    @Test
    public void initGiocatoreFormRegisterTest() throws Exception {
        boolean result = mockMvc.perform(get("/registerForm"))
                                .andExpect(status().isOk())
                                .andExpect(view().name("registerForm"))
                                .andReturn().getRequest().getSession().getAttributeNames().hasMoreElements();

        Assert.assertFalse(result);
    }

    @Test
    public void registerGiocatorebyFormTest() throws Exception {
        String nome="Valerio Test";
        String cognome="Vaudi test";
        String codiceFiscale="ASDF564HBCDFRE56";
        String mail="valerio.test1@bo.com";
        String user="valTest1";
        String password="valTest1";

        mockMvc.perform(post("/giocatoreInsert")
                            .param("firstNameIn", nome)
                            .param("lastNameIn", cognome)
                            .param("fiscalCodeIn", codiceFiscale)
                            .param("mailIn", mail)
                            .param("userNameIn", user)
                            .param("passwordIn", password))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("index"));

        Giocatore byUserName = giocatoreDAO.findByUserName(user);

        Assert.assertNotNull(byUserName);

        Assert.assertEquals(nome,byUserName.getNome());
        Assert.assertEquals(cognome,byUserName.getCognome());
        Assert.assertEquals(codiceFiscale,byUserName.getCodiceFiscale());
        Assert.assertEquals(mail,byUserName.getMail());
        Assert.assertEquals(user,byUserName.getUserName());
        Assert.assertEquals(password,byUserName.getPassword());
    }
}
