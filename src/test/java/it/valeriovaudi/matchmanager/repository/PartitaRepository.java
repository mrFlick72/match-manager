package it.valeriovaudi.matchmanager.repository;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import it.valeriovaudi.matchmanager.repository.dao.Interface.PartitaDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class PartitaRepository {

    @Autowired
    private PartitaDAO partitaDAO;

    @Autowired
    private GiocatoreDAO giocatoreDAO;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void test() throws ParseException {

        Giocatore valval = giocatoreDAO.findByUserName("valval");
        System.out.println("partitaDAO.findAllAvaiableMatch(valval, new Date())");
        System.out.println(partitaDAO.findAllAvaiableMatch(valval, new Date()));

        System.out.println("partitaDAO.findAllMatchreserved(valval, new Date())");
        String date = "05/05/2013";

        System.out.println(partitaDAO.findAllMatchReserved(valval, simpleDateFormat.parse(date)));

    }


}
