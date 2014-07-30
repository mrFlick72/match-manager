package it.valeriovaudi.matchmanager.mvc.logIn;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.mvc.MvcAbstractTests;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by seminario on 6/1/14.
 */
public class logInOutMvcTests extends MvcAbstractTests{


    @Autowired
    private GiocatoreDAO giocatoreDAO;

    @Test
    public void logInTest() throws Exception {

        String userNameIn = "valval";
        String passwordIn = "valval";

        Giocatore byCodiceFiscale = giocatoreDAO.findByCodiceFiscale(userNameIn);

        mockMvc.perform(post("/logIn")
                        .param("userNameIn", userNameIn)
                        .param("passwordIn", passwordIn))
                .andExpect(status().isOk())
                .andExpect(view().name("/index"))
                .andExpect(model().attribute("referente", byCodiceFiscale));

    }

    @Test
    public void logOutTest() throws Exception {

        String userNameIn = "valval";

        Giocatore byCodiceFiscale = giocatoreDAO.findByCodiceFiscale(userNameIn);


         mockMvc.perform(post("/logOut").sessionAttr("referente", byCodiceFiscale))
                                    .andExpect(status().isFound())
                                    .andExpect(redirectedUrl("index"))
                                    .andExpect(new ResultMatcher() {
                                        @Override
                                        public void match(MvcResult result) throws Exception {
                                            boolean referente = result.getRequest().getSession().getAttributeNames().hasMoreElements();
                                            Assert.assertFalse(referente);

                                        }
                                    });


    }
}
