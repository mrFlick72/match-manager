package it.valeriovaudi.matchmanager.service.ws;

import it.valeriovaudi.matchmanager.support.MatchUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.json.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 5/1/14
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommonDataRestServiceImpl implements CommonDataRestService {

    private MatchUtility matchUtility;

    @Override
    public String getAvaiableData() {

        String[] campi = matchUtility.getCampi();
        String[] ore = matchUtility.getOre();

        JsonObject build = Json.createObjectBuilder().
                add("footballFields", createJsonArrayByStringArray(campi)).
                add("hours", createJsonArrayByStringArray(ore)).
                build();

        return build.toString();
    }

    private JsonArray createJsonArrayByStringArray(String[] input){

        JsonArrayBuilder objectBuilder = Json.createArrayBuilder();

        for (String s : input) {
            objectBuilder.add(s);
        }

        return objectBuilder.build();

    }

    public void setMatchUtility(MatchUtility matchUtility) {
        this.matchUtility = matchUtility;
    }
}
