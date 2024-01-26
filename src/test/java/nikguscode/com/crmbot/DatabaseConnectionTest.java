package nikguscode.com.crmbot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.fail;

@SpringBootTest
@Slf4j
public class DatabaseConnectionTest {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    @Test
    public void testDatabaseConnection() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            assertNotNull("Connection should not be null", connection);
        } catch (SQLException e) {
            log.error("Connection failed: {}", e.getMessage());
            fail("Connection failed: " + e.getMessage());
        }
    }
}
