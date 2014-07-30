package it.valeriovaudi.matchmanager.controller.player;

import it.valeriovaudi.matchmanager.service.activiti.ActivitiEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 07/02/13
 * Time: 13.04
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class PlayerController {

    private ActivitiEngineService activitiEngineService;

    @RequestMapping(value = "registerForm", method = RequestMethod.GET)
    public void initGiocatoreFormRegister(SessionStatus sessionStatus){sessionStatus.setComplete();}

    @RequestMapping(value = "giocatoreInsert", method = RequestMethod.POST)
    public String registerGiocatorebyForm(@RequestParam(value = "firstNameIn") String nome,
                                          @RequestParam(value = "lastNameIn") String cognome,
                                          @RequestParam(value = "fiscalCodeIn") String codiceFiscale,
                                          @RequestParam(value = "mailIn") String mail,
                                          @RequestParam(value = "userNameIn") String user,
                                          @RequestParam(value = "passwordIn") String password) {
    	
    	Map<String,Object> var = new HashMap<String,Object>();
    	
    	var.put("firstName", nome);
    	var.put("lastName", cognome);
    	var.put("fiscalCode", codiceFiscale);
    	var.put("mail", mail);
    	var.put("userName", user);
    	var.put("password", password);
    	
        activitiEngineService.startProcess("giocatoreRegisterProcess",var);

        return "redirect:index";
    }

    @Autowired
    public void setActivitiEngineService(ActivitiEngineService activitiEngineService) {
        this.activitiEngineService = activitiEngineService;
    }
}
