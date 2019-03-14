package ma.superyass.notebookserver.rest.controller;

import ma.superyass.notebookserver.rest.dtos.ExecuteInputDTO;
import ma.superyass.notebookserver.rest.dtos.ResultDTO;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author A-Y.boutahar
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExecuteControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void generaleStatement() throws Exception {

        ResultDTO result = this.testRestTemplate.postForObject("http://localhost:" + port + "/execute",
                new ExecuteInputDTO("%python print 1+1"), ResultDTO.class);

        assertThat(result, notNullValue());
        assertThat(result.getResult(), is("2"));
    }
    
    @Test
    public void varAssignment() throws Exception {

        ResultDTO result = this.testRestTemplate.postForObject("http://localhost:" + port + "/execute",
                new ExecuteInputDTO("%python a = 1"), ResultDTO.class);

        assertThat(result, notNullValue());
        assertThat(result.getResult(), is(""));
    }

}
