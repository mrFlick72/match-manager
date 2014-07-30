package it.valeriovaudi.matchmanager.support;

import it.valeriovaudi.matchmanager.service.activiti.ActivitiEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 09/03/13
 * Time: 19.37
 * To change this template use File | Settings | File Templates.
 */
public class MatchUtilityImpl implements MatchUtility{


    private Properties campi;

    private ActivitiEngineService activitiEngineService;

    public void setCampi(Properties campi) {
        this.campi = campi;
    }

    public void setActivitiEngineService(ActivitiEngineService activitiEngineService) {
        this.activitiEngineService = activitiEngineService;
    }

    public List<String> getAvaibleFootballFields(List<String> reservedFootBallFields) {
        String[] aux = getCampi();
        List<String> result = new ArrayList<String>();

        for (String innerAux: aux)
        {
          if(!reservedFootBallFields.contains(innerAux)){
              result.add(innerAux);
          }
        }
        return result;
    }

    public String[] getCampi() {
        return campi.getProperty("campiId").split(",");
    }

    public String[] getOre() {
        return campi.getProperty("hoursId").split(",");
    }

    public void hourInit(Model model) {
        model.addAttribute("hours",getOre());
    }

    public void footballFieldsInit(Model model){
        model.addAttribute("campi",getCampi());
    }

    public void minimaliInit(Model model) {
        footballFieldsInit(model);
        hourInit(model);
    }

    public void newSearch(String processInstance) {
        Map<String,Object> paramiters = new HashMap<String, Object>();

        paramiters.put("choiceOrSearch", "search");
        activitiEngineService.completeLastTask(processInstance, paramiters);
    }

}
