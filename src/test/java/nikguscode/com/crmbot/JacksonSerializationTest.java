package nikguscode.com.crmbot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JacksonSerializationTest {
    @Test
    public void mainTest() {
        Logger logger = LoggerFactory.getLogger("nikguscode.com.crmbot.JacksonSerializationTest");
        Book book = new Book("Обитаемый остров", "Стругацкий А.", 413);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String json = null;
        try {
            json = objectMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        logger.info(json);
    }
}

class Book {
    public String title;
    public String author;
    public int pages;
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
}
