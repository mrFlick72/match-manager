package it.valeriovaudi.matchmanager.controller.match;


import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Partita;
import it.valeriovaudi.matchmanager.service.activiti.ActivitiEngineService;
import it.valeriovaudi.matchmanager.support.MatchUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes(value = {"campi","hours","referente","match","processInstance"})
public class JoinInMatchController {

    private MatchUtility utility;
    private ActivitiEngineService activitiEngineService;

    @RequestMapping(value = "joinInMatch", method = RequestMethod.GET)
    public void shearchFormInit(Model model,@ModelAttribute("referente") Giocatore referente) {
        utility.minimaliInit(model);
        model.addAttribute("referente", referente);
        model.addAttribute("match", new Partita());

        activitiEngineService.initProcess("joinInMatchProcess","processInstance",referente,model);
    }


    @RequestMapping(value = "palyerJoinInMatch", method = RequestMethod.POST)
    public String  joinInMatch(Model model,
                              @ModelAttribute(value = "match") Partita partita,
    						  @ModelAttribute(value = "referente") Giocatore referente,
    						  @ModelAttribute(value = "processInstance") String processInstance) {

        utility.minimaliInit(model);
        
        Map<String,Object> paramiters = new HashMap<String, Object>();
        
        // completo il task choice settando choice a choice
        paramiters.put("choiceOrSearch", "choice");
        activitiEngineService.completeLastTask(processInstance, paramiters);

        model.addAttribute("referente",referente);
        model.addAttribute("match", new Partita());

        return "redirect:index";
    }

    @Autowired
    public void setUtility(MatchUtility utility) {
        this.utility = utility;
    }

    @Autowired
    public void setActivitiEngineService(ActivitiEngineService activitiEngineService) {
        this.activitiEngineService = activitiEngineService;
    }
}
