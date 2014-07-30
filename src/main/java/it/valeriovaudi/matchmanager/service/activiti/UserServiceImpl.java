package it.valeriovaudi.matchmanager.service.activiti;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Valerio
 * Date: 24/02/13
 * Time: 12.42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService{

	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
    private IdentityService identityService;
    private GiocatoreDAO giocatoreDAO;
    
   public boolean create(String nome, String cognome, String codiceFiscale,String mail, String user, String password) {
  
	   boolean result = false;
	   try {
		    Giocatore giocatore = new Giocatore();

		    giocatore.setNome(nome);
		    giocatore.setCognome(cognome);
		    giocatore.setCodiceFiscale(codiceFiscale);
		    giocatore.setUserName(user);
		    giocatore.setPassword(password);
		    giocatore.setMail(mail);

		    giocatoreDAO.insert(giocatore);

		    create(giocatore);
		    
		    result = true;
	   } catch(Exception exception) {
		   log.error(exception);
	   }
	   return result;
 
}
    private void create(Giocatore giocatore) {

        User user = identityService.newUser(giocatore.getUserName());

        user.setFirstName(giocatore.getNome());
        user.setLastName(giocatore.getCognome());
        user.setEmail(giocatore.getMail());
        user.setPassword(giocatore.getPassword());
        identityService.saveUser(user);

    }

    @Autowired
    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    @Autowired
    public void setGiocatoreDAO(GiocatoreDAO giocatoreDAO) {
        this.giocatoreDAO = giocatoreDAO;
    }
}
