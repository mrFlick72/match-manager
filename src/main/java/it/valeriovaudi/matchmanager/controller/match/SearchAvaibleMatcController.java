package it.valeriovaudi.matchmanager.controller.match;

import it.valeriovaudi.matchmanager.service.activiti.ActivitiEngineService;
import it.valeriovaudi.matchmanager.support.MatchUtility;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 26/03/13
 * Time: 9.24
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes(value = {"footballField","referente","processInstanceCreateNewMatch"})
public class SearchAvaibleMatcController {

    private MatchUtility utility;
    private ActivitiEngineService activitiEngineService;

    private static Logger log = Logger.getLogger(SearchAvaibleMatcController.class);

    @RequestMapping(value = "searchAvaibleMatch",method = RequestMethod.POST)
    public String searchAvaibleMatch(@ModelAttribute("processInstanceCreateNewMatch") String processInstance,
                                     @RequestParam("date") String date,
                                     @RequestParam("selectedHour") String hour,
                                     Model model) {

        List<String> avaibleFootBallFields  = new ArrayList<String>();
        if(activitiEngineService.curretTaskDefinitionKey(processInstance).equals("searchUserTask")) {
            avaibleFootBallFields = compileSearchAvaibleMatchForm(processInstance, hour,  date);
        } else if(activitiEngineService.curretTaskDefinitionKey(processInstance).equals("newSearchUserTask")) {
            utility.newSearch(processInstance);
            avaibleFootBallFields = compileSearchAvaibleMatchForm(processInstance, hour,  date);
        }

        model.addAttribute("avaibleFootBallFields",utility.getAvaibleFootballFields(avaibleFootBallFields));
        model.addAttribute("hourRequest",hour);
        model.addAttribute("dateRequest",date);

        return "registerMathcForm";
    }


    private List<String> compileSearchAvaibleMatchForm(String processInstance,String hour, String date) {
        List<String> result = new ArrayList<String>();

        Map<String,Object> paramiters = new HashMap<String, Object>();

        paramiters.put("hour", hour);
        paramiters.put("date", date);

        activitiEngineService.completeLastTask(processInstance, paramiters);

        try {
            result = (List<String>) activitiEngineService.getLastProcessVariable(processInstance,"footBallFields");
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
