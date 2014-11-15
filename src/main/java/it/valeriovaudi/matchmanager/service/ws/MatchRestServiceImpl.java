package it.valeriovaudi.matchmanager.service.ws;

import it.valeriovaudi.matchmanager.model.Giocatore;
import it.valeriovaudi.matchmanager.model.Partita;
import it.valeriovaudi.matchmanager.repository.dao.Interface.GiocatoreDAO;
import it.valeriovaudi.matchmanager.repository.dao.Interface.PartitaDAO;
import it.valeriovaudi.matchmanager.service.activiti.ActivitiEngineService;
import it.valeriovaudi.matchmanager.service.activiti.MatchService;
import it.valeriovaudi.matchmanager.service.ws.dto.match.MatchModelDTO;
import it.valeriovaudi.matchmanager.support.MatchUtility;
import it.valeriovaudi.matchmanager.support.factory.JsonSingleResoltFactory;
import it.valeriovaudi.matchmanager.support.factory.ModelDTOFactory;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/11/14
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class MatchRestServiceImpl implements MatchRestService {

    private GiocatoreDAO giocatoreDAO;

    private PartitaDAO partitaDAO;
    private MatchService matchService;

    private MatchUtility matchUtility;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Logger logger = Logger.getLogger(MatchRestServiceImpl.class);

    private ActivitiEngineService activitiEngineService;

    private ModelDTOFactory<Partita,MatchModelDTO> partitaFactory;

    private JsonSingleResoltFactory jsonSingleResoltFactory;

    @Override
    public String setReservationFootballFields(String userNamePlayer, String date, String hour, String footballfield, String teamName) {
        String processInstance = new JSONObject(startJoinMatchProces(userNamePlayer,"createMatch")).get("processInstance").toString();

        boolean result;

        Map<String,Object> paramiters = new HashMap<String, Object>();

        paramiters.put("hour", hour);
        paramiters.put("date", date);

        result = activitiEngineService.completeLastTask(processInstance, paramiters);

        paramiters = new HashMap<String, Object>();
        paramiters.put("choiceOrSearch", "choice");
        result = activitiEngineService.completeLastTask(processInstance,paramiters);

        paramiters = new HashMap<String, Object>();
        paramiters.put("footBallField", footballfield);
        result = activitiEngineService.completeLastTask(processInstance, paramiters);

        paramiters = new HashMap<String, Object>();
        paramiters.put("teamName",teamName);
        result = activitiEngineService.completeLastTask(processInstance, paramiters);

        return jsonSingleResoltFactory.getJsonSingleResoltFactory("result",result);
    }

    @Override
    public String getAllAviableFootballFields(String date, String hour) {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        try {
            List<String> avaibleFootballFields = matchUtility.getAvaibleFootballFields(partitaDAO.findAvaibleMatch(simpleDateFormat.parse(date), hour));

            for (String avaibleFootballField : avaibleFootballFields) {
                arrayBuilder.add(avaibleFootballField);

            }
            objectBuilder.add("footballFields",arrayBuilder.build());
        } catch (ParseException e) {
            logger.error(e);
        }
        return objectBuilder.build().toString();
    }

    private String startJoinMatchProces(String userNamePlayer,String processId) {
        Giocatore referente = giocatoreDAO.findByUserName(userNamePlayer);
        return jsonSingleResoltFactory.getJsonSingleResoltFactory("processInstance",activitiEngineService.initProcess(processId,"processInstance",referente,null));
    }

    @Override
    public List<MatchModelDTO> getAvaiableMatch(String userNamePlayer, String data, String ora) {
        List<MatchModelDTO> matchModelDTOs = new ArrayList<MatchModelDTO>();
        MatchModelDTO matchModelDTO;

        Giocatore userName = giocatoreDAO.findByUserName(userNamePlayer);

        List<String> avaibleFootBallField = matchService.findReservedFootBallField(ora, data);

        for (String aux : avaibleFootBallField) {

            matchModelDTO = partitaFactory.getObject(matchService.find(aux, ora, data, userName));

            if(matchModelDTO!= null)  {
                matchModelDTOs.add(matchModelDTO);
            }
        }
        return matchModelDTOs;
    }

    @Override
    public String setReservationMatch(String userNamePlayer,
                                      String date,
                                      String hour,
                                      String footBallField) {
        String processInstance = new JSONObject(startJoinMatchProces(userNamePlayer,"joinInMatchProcess")).get("processInstance").toString();

        boolean result;

        Map<String,Object> paramitersTask = new HashMap<String,Object>();
        paramitersTask.put("footballField", footBallField);
        paramitersTask.put("hour", hour);
        paramitersTask.put("date", date);


        result=activitiEngineService.completeLastTask(processInstance, paramitersTask);

        paramitersTask = new HashMap<String,Object>();
        // completo il task choice settando choice a choice
        paramitersTask.put("choiceOrSearch", "choice");
        result=activitiEngineService.completeLastTask(processInstance, paramitersTask);

        return jsonSingleResoltFactory.getJsonSingleResoltFactory("result",result);
    }

    @Override
    public String getAllAvaiableMatch(String userNamePlayer, String date) {
        return createJsonArrayForService("getAllAvaiableMatch",userNamePlayer,date);

    }

    @Override
    public String getAllMatchReserved(String userNamePlayer, String date) {
        return createJsonArrayForService("getAllMatchReserved",userNamePlayer,date);
    }

    private String createJsonArrayForService(String functionName, String userNamePlayer, String date){
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Giocatore principal = giocatoreDAO.findByUserName(userNamePlayer);
        if(principal!=null){
            try {
                List<Partita> partitaList = new ArrayList<Partita>();
                if(functionName.equals("getAllMatchReserved")){
                    partitaList = partitaDAO.findAllMatchReserved(principal, simpleDateFormat.parse(date));
                } else if(functionName.equals("getAllAvaiableMatch")){
                    partitaList = partitaDAO.findAllAvaiableMatch(principal, simpleDateFormat.parse(date));
                }

                for (Partita partita : partitaList) {
                    arrayBuilder.add(Json.createObjectBuilder()
                            .add("footballField", partita.getPartitaId().getCampoId())
                            .add("hour", partita.getPartitaId().getOra())
                            .add("date", simpleDateFormat.format(partita.getPartitaId().getGiorno())));
                }


            } catch (ParseException e) {
                logger.error(e);
            }
        }
        return arrayBuilder.build().toString();
    }

    public void setActivitiEngineService(ActivitiEngineService activitiEngineService) {
        this.activitiEngineService = activitiEngineService;
    }

    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }


    public void setGiocatoreDAO(GiocatoreDAO giocatoreDAO) {
        this.giocatoreDAO = giocatoreDAO;
    }

    public void setPartitaFactory(ModelDTOFactory<Partita, MatchModelDTO> partitaFactory) {
        this.partitaFactory = partitaFactory;
    }

    public void setJsonSingleResoltFactory(JsonSingleResoltFactory jsonSingleResoltFactory) {
        this.jsonSingleResoltFactory = jsonSingleResoltFactory;
    }

    public void setPartitaDAO(PartitaDAO partitaDAO) {
        this.partitaDAO = partitaDAO;
    }

    public void setMatchUtility(MatchUtility matchUtility) {
        this.matchUtility = matchUtility;
    }
}
