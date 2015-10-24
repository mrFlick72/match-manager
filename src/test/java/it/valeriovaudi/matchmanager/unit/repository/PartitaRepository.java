package it.valeriovaudi.matchmanager.unit.repository;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import it.valeriovaudi.matchmanager.repository.dao.Interface.PartitaDAO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 5/16/14
 * Time: 5:08 AM
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("embedded")
@Transactional
@DirtiesContext
public class PartitaRepository {
    private Logger logger = Logger.getLogger(PartitaRepository.class);
    
    @Autowired
    private PartitaDAO partitaDAO;

    @Autowired
    private GiocatoreDAO giocatoreDAO;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void test() throws ParseException {
        Giocatore valval = giocatoreDAO.findByUserName("valval");
        logger.info("partitaDAO.findAllAvaiableMatch(valval, new Date())");
        logger.info(partitaDAO.findAllAvaiableMatch(valval, new Date()));

        logger.info("partitaDAO.findAllMatchreserved(valval, new Date())");
        String date = "05/05/2013";

        logger.info(partitaDAO.findAllMatchReserved(valval, simpleDateFormat.parse(date)));
    }
}
