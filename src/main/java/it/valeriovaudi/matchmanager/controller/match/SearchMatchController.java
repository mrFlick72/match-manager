package it.valeriovaudi.matchmanager.controller.match;

import it.valeriovaudi.matchmanager.model.Partita;
import it.valeriovaudi.matchmanager.service.activiti.ActivitiEngineService;
import it.valeriovaudi.matchmanager.support.MatchUtility;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes(value = {"squadreByReferente","hours","referente","footballField","match","processInstance","processInstanceCreateNewMatch"})
public class SearchMatchController {

    private MatchUtility utility;
    private ActivitiEngineService activitiEngineService;

    private static Logger log = Logger.getLogger(SearchMatchController.class);


    @RequestMapping(value = "searchMatch", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("processInstance") String processInstance,
                         @RequestParam("date") String date,
                         @RequestParam("footballField") String footBallField,
                         @RequestParam("hour") String hour) {

        Partita match = null;

        if(activitiEngineService.curretTaskDefinitionKey(processInstance).equals("searchUserTask")) {
            match = compileSearchMatchForm(processInstance,  footBallField, hour,  date);
        } else if(activitiEngineService.curretTaskDefinitionKey(processInstance).equals("newSearchUserTask")){

            utility.newSearch(processInstance);

            match = compileSearchMatchForm(processInstance,  footBallField, hour,  date);
        }

        if(match!=null) {
            model.addAttribute("match", match);
        }

        return "joinInMatch";
    }


    private Partita compileSearchMatchForm(String processInstance, String footBallField,String hour, String date) {
        Partita result = null;

        Map<String,Object> paramiters = new HashMap<String, Object>();

        paramiters.put("footballField", footBallField);
        paramiters.put("hour", hour);
        paramiters.put("date", date);

        activitiEngineService.completeLastTask(processInstance, paramiters);

        try {
        	result = (Partita) activitiEngineService.getLastProcessVariable(processInstance,"match");
        } catch(Exception exception){
            log.error(exception.getMessage());
        }

        return result;
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
