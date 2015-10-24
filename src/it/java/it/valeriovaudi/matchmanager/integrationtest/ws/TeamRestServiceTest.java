package it.valeriovaudi.matchmanager.integrationtest.ws;

import it.valeriovaudi.matchmanager.integrationtest.ws.team.AutenticationInfoModelDTOJsonBuilder;
import it.valeriovaudi.matchmanager.service.ws.dto.team.AutenticationInfoModelDTO;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/6/14
 * Time: 4:36 AM
 * To change this template use File | Settings | File Templates.
 */

public class TeamRestServiceTest {
    private Logger logger = Logger.getLogger(TeamRestServiceTest.class);

    private AutenticationInfoModelDTOJsonBuilder autenticationInfoModelDTOJsonBuilder;
    @Before
    public void setUp() throws Exception {
        autenticationInfoModelDTOJsonBuilder = new AutenticationInfoModelDTOJsonBuilder();

    }

    private static final String  playerIsRegisterTestURL = "http://localhost:8080/service/rest/TeamRestService/playerIsRegister";

    public int commonHttpClientPostImpl(String url,  Object body)throws IOException {
        int status = -1;

        CloseableHttpClient client = createHttp();

        HttpPost httpPost = new HttpPost(url);

        HttpEntity httpEntity = new StringEntity(body.toString());
        httpPost.addHeader("content-type", "application/json");


        httpPost.setEntity(httpEntity);

        CloseableHttpResponse execute = client.execute(httpPost);

        status = execute.getStatusLine().getStatusCode();

        logResponse(execute.getEntity());

        logger.info("Web Script esito: " + status);
        return status;
    }

    public int commonHttpClientPostImpl(String url, Map<String,Object> bodyParamiter)throws IOException {

        int status = -1;

        CloseableHttpClient client = createHttp();

        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        HttpPost httpPost = new HttpPost(url);

        String stringPart;

        int index = 0;
        for (Map.Entry<String, Object> stringObjectsEntry : bodyParamiter.entrySet()) {

            stringPart = String.valueOf(stringObjectsEntry.getValue());

            multipartEntityBuilder.addPart(stringObjectsEntry.getKey(),new StringBody(stringPart, ContentType.APPLICATION_JSON));

            index++;
        }

        httpPost.setEntity(multipartEntityBuilder.build());

        CloseableHttpResponse execute = client.execute(httpPost);

        status = execute.getStatusLine().getStatusCode();

        logResponse(execute.getEntity());

        logger.info("Web Script esito: " + status);
        return status;
    }

    private String logResponse(HttpEntity httpEntity) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        InputStream content = httpEntity.getContent();
        if(content !=null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));

            String line;
            line = bufferedReader.readLine();

            while (line!=null){
                stringBuilder.append(line);
                logger.info(line);
                line = bufferedReader.readLine();
            }

        }else {
            logger.error("responseBodyAsStream is null");
        }

        return stringBuilder.toString();
    }

    private CloseableHttpClient createHttp() {
        return HttpClients.createDefault();
    }

//    @Test
    public void getAllAvaiableMatchTest() throws IOException {
        Map<String,Object> bodyParamiter = new HashMap<String, Object>();


        AutenticationInfoModelDTO autenticationInfoModelDTO = new AutenticationInfoModelDTO();

        autenticationInfoModelDTO.setUserName("valval");
        autenticationInfoModelDTO.setPassword("valval1");

        bodyParamiter.put("authenticationToken",autenticationInfoModelDTOJsonBuilder.autenticationInfoModelDTOJsonBuilder(autenticationInfoModelDTO));

        int i = commonHttpClientPostImpl(playerIsRegisterTestURL, autenticationInfoModelDTOJsonBuilder.autenticationInfoModelDTOJsonBuilder(autenticationInfoModelDTO));

        logger.info(i);
    }


//    @Test
    public void playerIsRegisterTest() throws IOException {
        Map<String,Object> bodyParamiter = new HashMap<String, Object>();

        AutenticationInfoModelDTO autenticationInfoModelDTO = new AutenticationInfoModelDTO();

        autenticationInfoModelDTO.setUserName("valval");
        autenticationInfoModelDTO.setPassword("valval1");

        bodyParamiter.put("authenticationToken", autenticationInfoModelDTOJsonBuilder.autenticationInfoModelDTOJsonBuilder(autenticationInfoModelDTO));

        int i = commonHttpClientPostImpl(playerIsRegisterTestURL, autenticationInfoModelDTOJsonBuilder.autenticationInfoModelDTOJsonBuilder(autenticationInfoModelDTO));

        logger.info(i);
    }

}
