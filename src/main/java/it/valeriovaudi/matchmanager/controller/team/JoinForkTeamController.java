package it.valeriovaudi.matchmanager.controller.team;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.service.activiti.MatchServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 09/03/13
 * Time: 19.22
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes(value = {"giocatoriInSquadra","giocatoriDisponibili","referente"})
public class JoinForkTeamController {

    @RequestMapping(value = "joinInTeam", method = RequestMethod.POST)
    public String joinInTeam(@RequestParam(value = "codFiscale") String codiceFiscale,
                             @ModelAttribute("giocatoriDisponibili") List<Giocatore> giocatoriDisponibili ,
                             @ModelAttribute("giocatoriInSquadra")  List<Giocatore> giocatoriInSquadra,
                             @ModelAttribute("referente") Giocatore referente,
                             Model model) {
        if(giocatoriInSquadra.size() < MatchServiceImpl.LIMIT) {
            swap(codiceFiscale,giocatoriDisponibili,giocatoriInSquadra,referente);
        }

        model.addAttribute("giocatoriInSquadra",giocatoriInSquadra);
        model.addAttribute("giocatoriDisponibili",giocatoriDisponibili);

        return "registerSquadraForm";
    }

    @RequestMapping(value = "forkOutTeam", method = RequestMethod.POST)
    public String forkToTeam(@RequestParam(value = "codFiscale") String codiceFiscale,
                             @ModelAttribute("giocatoriDisponibili") List<Giocatore> giocatoriDisponibili ,
                             @ModelAttribute("giocatoriInSquadra")  List<Giocatore> giocatoriInSquadra,
                             @ModelAttribute("referente") Giocatore referente,
                             Model model) {
        swap(codiceFiscale,giocatoriInSquadra,giocatoriDisponibili,referente);

        model.addAttribute("giocatoriInSquadra",giocatoriInSquadra);
        model.addAttribute("giocatoriDisponibili",giocatoriDisponibili);

        return "registerSquadraForm";
    }

    private void swap(String codiceFiscale,List<Giocatore> giocatoriDa,List<Giocatore> giocatoriA,Giocatore referente) {
        for(Giocatore giocatoreAux :giocatoriDa) {
            if(giocatoreAux.getCodiceFiscale().equals(codiceFiscale) && !referente.getCodiceFiscale().equals(codiceFiscale)) {
                giocatoriDa.remove(giocatoreAux);
                giocatoriA.add(giocatoreAux);
                break;
            }
        }
    }
}
