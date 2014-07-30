package it.valeriovaudi.matchmanager.controller.match;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.service.activiti.ActivitiEngineService;
import it.valeriovaudi.matchmanager.support.MatchUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 09/03/13
 * Time: 19.35
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes(value = {"hours","footballField","referente","processInstanceCreateNewMatch","squadreByReferente"})
public class ReservationMatchController {

    private ActivitiEngineService activitiEngineService;
    private MatchUtility utility;


    @RequestMapping(value = "registerMathcForm",method = RequestMethod.GET)
    public void searchAvaibleMatchInitForm(Model model,@ModelAttribute("referente") Giocatore referente) {
        String id =  activitiEngineService.initProcess("createMatch","processInstanceCreateNewMatch",referente,model);
        model.addAttribute("squadreByReferente",activitiEngineService.getLastProcessVariable(id,"teams"));

        utility.hourInit(model);
    }
    @RequestMapping(value = "reservationMatch",method = RequestMethod.POST)
    public String choiceTeam(@ModelAttribute("processInstanceCreateNewMatch") String processId,
    						 @RequestParam String teamName,
                             @RequestParam String footballField) {
    
    	Map<String,Object> paramitersTask1 = new HashMap<String,Object>();
    	paramitersTask1.put("choiceOrSearch", "choice");
    	activitiEngineService.completeLastTask(processId,paramitersTask1);
    	
    	Map<String,Object> paramitersTask2 = new HashMap<String,Object>();
    	paramitersTask2.put("footBallField", footballField);
    	activitiEngineService.completeLastTask(processId, paramitersTask2);

    	Map<String,Object> paramitersTask3 = new HashMap<String,Object>();
    	paramitersTask3.put("teamName",teamName);
    	activitiEngineService.completeLastTask(processId, paramitersTask3);
    	
        return "redirect:/index";
    }

    @Autowired
    public void setActivitiEngineService(ActivitiEngineService activitiEngineService) {
        this.activitiEngineService = activitiEngineService;
    }

    @Autowired
    public void setUtility(MatchUtility utility) {
        this.utility = utility;
    }
}
