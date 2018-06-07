package mx.unam.dgpe.sample.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import io.vertx.core.AbstractVerticle;
import static mx.unam.dgpe.sample.controller.RestUtil.*;

public class TestMyController extends AbstractVerticle {
    private static final Logger logger = Logger.getLogger(TestMyController.class);
    
    @Test
    public void ok() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=123");

        logger.info(result);
        assertTrue("con 123",result.contains("false"));

    }
    @Test
    public void ok1() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=bvg");
        logger.info(result);
        assertTrue("con bvg",result.contains("false"));

    }
    @Test
    public void ok2() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=klora");
        assertTrue("con klora",result.contains("false"));
        logger.info(result);

    }
    @Test
    public void ok3() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=a");
        logger.info(result);
        assertTrue("con a",result.contains("false"));

    }
    @Test
    public void ok4() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=asdads");
        logger.info(result);
        assertTrue("con asdads",result.contains("false"));

    }
    @Test
    public void ok5() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=111111");
        logger.info(result);
        assertTrue("con 111111",result.contains("true"));

    }
    @Test
    public void ok6() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=abcabc");
        logger.info(result);
        assertTrue("con ",result.contains("true"));

    }
    @Test
    public void ok7() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=aa");
        logger.info(result);
        assertTrue("con aa",result.contains("true"));

    }
    @Test
    public void ok8() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=holaholahola");
        logger.info(result);
        assertTrue("con holahola",result.contains("true"));

    }
    @Test
    public void ok9() throws Exception {
        String result = sendGet("http://127.0.0.1:8081/api/tercero?mode=123123");
        logger.info(result);
        assertTrue("con 123123",result.contains("true"));

    }

}
