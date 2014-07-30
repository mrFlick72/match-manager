package it.valeriovaudi.matchmanager.service.activiti;

import it.valeriovaudi.matchmanager.model.Giocatore;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.ui.Model;

import java.util.Map;

public interface ActivitiEngineService {

	 ProcessInstance startProcess(String processKey,Map<String,Object> var);
	 boolean completeLastTask(String processInstanceId,Map<String,Object> paramiters);
	 Object getLastProcessVariable(String processInstanceId,String variableName);
	 String curretTaskDefinitionKey(String processInstanceId);
	 String initProcess(String processName,String processSessionVariable, Giocatore referente,Model model);
}
