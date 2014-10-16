package it.valeriovaudi.matchmanager.activity;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by seminario on 7/15/14.
 */
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("embedded")
public class ActivitiTest {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private TaskService taskService;


    @Test
    public void test(){
        HistoricActivityInstanceQuery finished = historyService.createHistoricActivityInstanceQuery().finished();

        HistoricActivityInstanceQuery unfinished = historyService.createHistoricActivityInstanceQuery().unfinished();

        System.out.println(finished.list().size());
        System.out.println(unfinished.list().size());

        for (HistoricActivityInstance historicActivityInstance : finished.list()) {
            System.out.println("************************************************");

            System.out.println(historicActivityInstance.getActivityName());
            System.out.println(historicActivityInstance.getAssignee());
            System.out.println(historicActivityInstance.getProcessInstanceId());
            System.out.println(historicActivityInstance.getProcessDefinitionId());
            System.out.println(historicActivityInstance.getTaskId());
            System.out.println(historicActivityInstance.getId());

            System.out.println("************************************************");
        }

        System.out.println("************************************************");

        for (HistoricActivityInstance historicActivityInstance : unfinished.list()) {
            System.out.println("************************************************");

            System.out.println(historicActivityInstance.getActivityName());
            System.out.println(historicActivityInstance.getAssignee());
            System.out.println(historicActivityInstance.getProcessInstanceId());
            System.out.println(historicActivityInstance.getProcessDefinitionId());
            System.out.println(historicActivityInstance.getTaskId());
            System.out.println(historicActivityInstance.getId());

            System.out.println("************************************************");
        }
    }
}
