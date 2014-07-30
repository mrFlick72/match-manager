package it.valeriovaudi.matchmanager.controller.team;

import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.repository.dao.Interface.SquadraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 09/03/13
 * Time: 19.15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes(value = {"squadre"})

public class GetTeamController {

    private SquadraDAO squadraDAO;

    @RequestMapping(value = "/getSquadre",method = RequestMethod.GET)
    public void getTeam(Model model) {
        List<Squadra> squadre = squadraDAO.findALL();

        model.addAttribute("squadre",squadre);

    }

    @Autowired
    public void setSquadraDAO(SquadraDAO squadraDAO) {
        this.squadraDAO = squadraDAO;
    }
}
