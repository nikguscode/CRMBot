package nikguscode.com.crmbot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LogbackFunctionalityTest {
    @Test
    public void testError() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LogbackTest");
        logger.error("ERROR");
    }

    @Test
    public void testWarn() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LogbackTest");
        logger.warn("WARN");
    }

    @Test
    public void testInfo() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LogbackTest");
        logger.info("INFO");
    }

    @Test
    public void testDebug() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LogbackTest");
        logger.debug("DEBUG");
    }

    @Test
    public void testTrace() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LogbackTest");
        logger.trace("TRACE");
    }
}
