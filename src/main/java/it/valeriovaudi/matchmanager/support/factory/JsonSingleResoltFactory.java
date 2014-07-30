package it.valeriovaudi.matchmanager.support.factory;

import javax.json.Json;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/19/14
 * Time: 6:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class JsonSingleResoltFactory extends AbstractModelDTOFactory{

    private String jsonKey;


    public String getJsonSingleResoltFactory(String jsonKey,Object input) {
        this.jsonKey=jsonKey;
        return (String) getObject(input);
    }

    @Override
    public Object doGetObject(Object input) {

        return Json.createObjectBuilder()
                        .add(jsonKey,String.valueOf(input))
                        .build()
                        .toString();
    }
}
