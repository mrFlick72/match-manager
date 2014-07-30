package it.valeriovaudi.matchmanager.mvc;

import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by seminario on 6/2/14.
 */

@ContextConfiguration(locations = {"classpath:spring-config.xml", "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@WebAppConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
public class MvcAbstractTests {

    protected MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

}
