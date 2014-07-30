package it.valeriovaudi.matchmanager.controller.logInOut;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 16/02/13
 * Time: 20.13
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes(value = {"referente"})
public class LogInLogOutController {

    private GiocatoreDAO giocatoreDAO;

    @RequestMapping(value = "logIn",method = RequestMethod.POST)
    public String logIn(@RequestParam("userNameIn") String user,
    				    @RequestParam("passwordIn") String pass,
    				    Model model) {

        Giocatore referente = giocatoreDAO.findByUserName(user);

        if(referente!= null && referente.getPassword().equals(pass)) {
             model.addAttribute("referente",referente);
        }
        return "/index";
    }

    @RequestMapping(value = "logOut",method = RequestMethod.POST)
    public String logOut(SessionStatus sessionStatus) throws IOException {
        sessionStatus.setComplete();
    	return "redirect:index";
    }

    @Autowired
    public void setGiocatoreDAO(GiocatoreDAO giocatoreDAO) {
        this.giocatoreDAO = giocatoreDAO;
    }
}
