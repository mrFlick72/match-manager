package it.valeriovaudi.matchmanager.service.activiti;


import it.valeriovaudi.matchmanager.model.Giocatore;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivitiEngineServiceImpl implements ActivitiEngineService{

    private RuntimeService runtimeService;
    private HistoryService historyService;
    private TaskService taskService;

    private static Logger log = Logger.getLogger(ActivitiEngineServiceImpl.class);


	public ProcessInstance startProcess(String processKey,Map<String,Object> var) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey,var);
        
		return processInstance;
	}
	
	public boolean completeLastTask(String processInstanceId,Map<String,Object> paramiters) {
		TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(processInstanceId);
		int actualPosition = taskQuery.list().size() -1;
		Task task = taskQuery.list().get(actualPosition);
		String taskId = task.getId();
		taskService.complete(taskId, paramiters);

		return true;
	}
	
	
	public Object getLastProcessVariable(String processInstanceId,String variableName) {
		Object result = null;
		try {
			List<HistoricVariableInstance> variables = historyService.createHistoricVariableInstanceQuery()
						  .variableName(variableName)
						  .processInstanceId(processInstanceId)
						  .list();
			int actualPosition = variables.size() - 1;
			
			HistoricVariableInstance lastVariable = variables.get(actualPosition);
			
			result =  lastVariable.getValue();
			
		} catch(Exception exception) {
            log.error("Eccezione: " + exception.getMessage());
		}
		return result;
	
	}
	
	public String curretTaskDefinitionKey(String processInstanceId) {
		String taskName = "";
		try {
			TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(processInstanceId);
			
			int actualPosition = taskQuery.list().size() -1;
			Task task = taskQuery.list().get(actualPosition);
			taskName = task.getTaskDefinitionKey();
			
		}
        catch(Exception exception) {
            log.error("Eccezione: " + exception.getMessage());
		}

		return taskName;
	}
	
    public String initProcess(String processName,String processSessionVariable, Giocatore referente,Model model) {
        Map<String,Object> var = new HashMap<String, Object>();
        var.put("principal", referente);

        // starto il processo con ownership del principal che effettua il log-in
        ProcessInstance processInstance = startProcess(processName, var);
        if(model!=null) {
            model.addAttribute(processSessionVariable,processInstance.getProcessInstanceId());
        }

        return processInstance.getProcessInstanceId();
    }

    @Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }
    @Autowired
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
