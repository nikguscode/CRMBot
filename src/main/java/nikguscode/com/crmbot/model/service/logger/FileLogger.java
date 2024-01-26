package nikguscode.com.crmbot.model.service.logger;

import lombok.extern.slf4j.Slf4j;
import nikguscode.com.crmbot.model.service.TelegramType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@PropertySource("path.properties")
public class FileLogger {
    private final String pathToMessageLogs;

    public FileLogger(@Value("${file-logger.path}") String pathToMessageLogs) {
        this.pathToMessageLogs = pathToMessageLogs;
    }

    public void updateLogs(String text, TelegramType dataType) {
        createFolderIfNotFounded(dataType);

        try {
            Files.writeString(Path.of(getFileName(dataType)), text, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            if (Files.size(Path.of(getFileName(dataType))) > 0) {
                Files.writeString(Path.of(getFileName(dataType)), ",\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFolderIfNotFounded(TelegramType dataType) {
        Path folderPath = Path.of(
                new StringBuffer()
                        .append(pathToMessageLogs)
                        .append("/")
                        .append(dataType.toString().toLowerCase())
                        .toString()
        );

        if (!Files.exists(folderPath)) {
            try {
                Files.createDirectories(folderPath);
            } catch (IOException e) {
                log.error("[Ошибка при создании папки: «{}»]", folderPath);
                throw new RuntimeException(e);
            }

            log.info("[Папка: «{}» успешно создана]", folderPath);
        }
    }

    private String getFileName(TelegramType dataType) {
        // return = path/telegramType/telegramType_dd.MM.yyyy
        // example = logs/messages/text_28.05.2023.json
        return new StringBuffer(pathToMessageLogs)
                .append("/")
                .append(dataType.toString().toLowerCase())
                .append("/")
                .append(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .append(".json")
                .toString();
    }
}