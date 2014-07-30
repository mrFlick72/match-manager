package it.valeriovaudi.matchmanager.service.activiti;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Partita;
import it.valeriovaudi.matchmanager.model.PartitaId;
import it.valeriovaudi.matchmanager.model.Squadra;
import it.valeriovaudi.matchmanager.repository.dao.Interface.PartitaDAO;
import it.valeriovaudi.matchmanager.repository.dao.Interface.SquadraDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService{

    public static final int LIMIT = 5;

	private static Logger log = Logger.getLogger(MatchServiceImpl.class);

	private SimpleDateFormat format;
    private SimpleDateFormat formatFromJavaDate;

    private PartitaDAO partitaDAO;
    private SquadraDAO squadraDAO;

    @PostConstruct
    public void init(){
        this.format = new SimpleDateFormat("dd/MM/yyyy");
        this.formatFromJavaDate = new SimpleDateFormat("yyyy-MM-dd");
    }
 
    public List<String> findReservedFootBallField(String hour, String date){
    	List<String> avaibleFootBallFields = new LinkedList<String>();
    	
    	try {
    		avaibleFootBallFields = partitaDAO.findAvaibleMatch(format.parse(date),hour);
    	} catch(ParseException parseException){
            log.error(parseException.getMessage());
        }
    	
    	return avaibleFootBallFields;

    }
    
    public Partita find(String campo, String ora, String giorno, Giocatore principal){
    	Partita match = null;
    	
    	try {
            match = partitaDAO.find(campo,ora,format.parse(giorno), principal);
    	} catch(ParseException parseException){
            log.error(parseException.getMessage());
        }
    	
    	return match;

    }

    @Transactional
    public Partita joinInMatch(String footballField,String hour,String giorno,Giocatore principal){

        Partita partita = null;

        try {
            if(giorno.contains("//")){
                partita = partitaDAO.findById(footballField, hour, formatFromJavaDate.parse(giorno));
            } else {
                partita = partitaDAO.findById(footballField, hour, format.parse(giorno));
            }

            if(partita.getSquadraSfidata() != null && partita.getSquadraSfidata().getGiocatori().size()!= LIMIT && !partita.getSquadraSfidata().getGiocatori().contains(principal)){
                partita.getSquadraSfidata().getGiocatori().add(principal);

                partitaDAO.update(partita);
            }

        } catch (Exception  exception){log.error(exception.getMessage());}

         return partita;
    }

	public Partita reservationMatch(String teamName,
					  				String date,
					  				String footballField,
					  				String hour) {
		Partita partita = new Partita();
        try {
        	Squadra byName = squadraDAO.findByName(teamName);

        	PartitaId partitaId = null;
        	partitaId = new PartitaId(footballField, format.parse(date), hour);

            partita.setPartitaId(partitaId);
            partita.setSquadraSfidante(byName);
            
            // creo la suqdra sfidata
            Squadra squadra = new Squadra();
            squadra.setNome(byName.getNome() + " Avversaria_"+Math.random());
            List<Giocatore> giocatori = new ArrayList<Giocatore>();
            squadra.setGiocatori(giocatori);
            squadraDAO.insert(squadra);
            partita.setSquadraSfidata(squadra);

            partitaDAO.insert(partita);
           
        } catch (Exception e){
        	partita = null;
        	
            log.error(e.getMessage());
        }
        
		return partita;
	}

    @Autowired
    public void setPartitaDAO(PartitaDAO partitaDAO) {
        this.partitaDAO = partitaDAO;
    }
    @Autowired
    public void setSquadraDAO(SquadraDAO squadraDAO) {
        this.squadraDAO = squadraDAO;
    }
}
