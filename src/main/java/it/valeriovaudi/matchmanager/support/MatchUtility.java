package it.valeriovaudi.matchmanager.support;

import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 5/24/14
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MatchUtility {

     String[] getCampi();
     String[] getOre();

     void hourInit(Model model);
     void footballFieldsInit(Model model);
     void minimaliInit(Model model);

     void newSearch(String processInstance);

    List<String> getAvaibleFootballFields(List<String> reservedFootBallFields);
}
