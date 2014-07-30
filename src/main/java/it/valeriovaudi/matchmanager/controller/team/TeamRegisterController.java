package it.valeriovaudi.matchmanager.controller.team;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import it.valeriovaudi.matchmanager.repository.dao.Interface.SquadraDAO;
import it.valeriovaudi.matchmanager.service.activiti.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"giocatoriInSquadra","referente","giocatoriDisponibili"})
public class TeamRegisterController {

    private GiocatoreDAO giocatoreDAO;
    private SquadraDAO squadraDAO;

    @RequestMapping(value = "/registerSquadraForm", method = RequestMethod.GET)
    public void initRegisterSquadraForm(Model model,@ModelAttribute("referente") Giocatore referente) {

        List<Giocatore> giocatoriInSquadra = new ArrayList<Giocatore>();
        List<Giocatore> giocatoriDisponibili =   giocatoreDAO.findALL();

        if(giocatoriDisponibili.size() > 0) {
            giocatoriDisponibili.remove(referente);
            giocatoriInSquadra.add(referente);
        }

        model.addAttribute("giocatoriInSquadra",giocatoriInSquadra);
        model.addAttribute("giocatoriDisponibili",giocatoriDisponibili);
    }

    @RequestMapping(value = "teamRegister",method = RequestMethod.POST)
    public String teamRegister(@RequestParam(value = "teamNameIn") String teamName,
                               @ModelAttribute("giocatoriInSquadra")  List<Giocatore> giocatoriInSquadra,
                               @ModelAttribute("referente") Giocatore referente) {
    	
        if(giocatoriInSquadra.size() == MatchServiceImpl.LIMIT && !teamName.trim().equals("")) {
            Squadra squadra = new Squadra();

            squadra.setNome(teamName);
            squadra.setGiocatori(giocatoriInSquadra);
            squadra.setReferente(referente);

            squadraDAO.insert(squadra);
        }

        return "redirect:registerSquadraForm";
    }

    @Autowired
    public void setGiocatoreDAO(GiocatoreDAO giocatoreDAO) {
        this.giocatoreDAO = giocatoreDAO;
    }

    @Autowired
    public void setSquadraDAO(SquadraDAO squadraDAO) {
        this.squadraDAO = squadraDAO;
    }
}
