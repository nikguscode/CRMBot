package nikguscode.com.crmbot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest
public class FilePathTest {
    @Test
    public void testPath() {
        try {
            Files.createFile(Path.of("logs/messages/test.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkIfTheFileNameIsFree() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.FilePathTest");
        if(Files.exists(Path.of("logs/messages/test.txt"))) {
            logger.info("Файл успешно найден, перезапись невозможна");
        } else {
            logger.info("Файл не существует, запись возможна");
        }
    }
}
