package nikguscode.com.crmbot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class LocalTimeAndDateTest {
    @Test
    public void getCurrentTime() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LocalTimeAndDateTest");
        LocalTime localTime = LocalTime.now().withNano(0);
        logger.info(localTime.toString());
    }

    @Test
    public void getCurrentDateAndTime() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LocalTimeAndDateTest");
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        logger.info(localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy | HH:mm:ss")));
    }

    @Test
    public void divideTheResultingDateAndTime() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.LocalTimeAndDateTest");
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        String date = localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String time = localDateTime.toLocalTime().toString();
        logger.info(date + " | " + time);
    }
}
