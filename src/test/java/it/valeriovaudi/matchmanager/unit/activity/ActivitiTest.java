package it.valeriovaudi.matchmanager.unit.activity;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by seminario on 7/15/14.
 */
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("embedded")
@Transactional
@DirtiesContext
public class ActivitiTest {
    private Logger logger = Logger.getLogger(ActivitiTest.class);

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

        logger.info(finished.list().size());
        logger.info(unfinished.list().size());

        for (HistoricActivityInstance historicActivityInstance : finished.list()) {
            logger.info("************************************************");

            logger.info(historicActivityInstance.getActivityName());
            logger.info(historicActivityInstance.getAssignee());
            logger.info(historicActivityInstance.getProcessInstanceId());
            logger.info(historicActivityInstance.getProcessDefinitionId());
            logger.info(historicActivityInstance.getTaskId());
            logger.info(historicActivityInstance.getId());

            logger.info("************************************************");
        }

        logger.info("************************************************");

        for (HistoricActivityInstance historicActivityInstance : unfinished.list()) {
            logger.info("************************************************");

            logger.info(historicActivityInstance.getActivityName());
            logger.info(historicActivityInstance.getAssignee());
            logger.info(historicActivityInstance.getProcessInstanceId());
            logger.info(historicActivityInstance.getProcessDefinitionId());
            logger.info(historicActivityInstance.getTaskId());
            logger.info(historicActivityInstance.getId());

            logger.info("************************************************");
        }
    }
}
