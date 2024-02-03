package nikguscode.com.crmbot.model.service.logger;

import lombok.extern.slf4j.Slf4j;
import nikguscode.com.crmbot.model.service.enums.TelegramType;
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
@PropertySource(value = "path.properties", encoding = "UTF-8")
public class FileLogger {
    private final String pathToMessageLogs;

    public FileLogger(@Value("${file-logger.path}") String pathToMessageLogs) {
        this.pathToMessageLogs = pathToMessageLogs;
    }

    public void updateLogs(String text, TelegramType dataType) {
        createFolderIfNotFounded(dataType);
        createFileIfNotFounded(dataType);

        Path filePath = Path.of(getFileName(dataType));

        try {
            if (!isFileEmpty(dataType)) {
                String fileContent = Files.readString(filePath);
                Files.write(filePath, fileContent.substring(0, fileContent.length() - 1).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                Files.writeString(filePath, ",\n", StandardOpenOption.APPEND);
            }

            Files.writeString(filePath, text, StandardOpenOption.APPEND);
            Files.writeString(filePath, "]", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    private boolean isFileEmpty(TelegramType dataType) {
        Path filePath = Path.of(getFileName(dataType));

        try {
            return Files.readString(filePath).length() == 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFileIfNotFounded(TelegramType dataType) {
        Path filePath = Path.of(getFileName(dataType));

        if (!Files.exists(filePath)) {
            try {
                Files.writeString(filePath, "[", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
                log.error("[Error when creating «{}» folder]", folderPath);
                throw new RuntimeException(e);
            }

            log.info("[Folder: «{}» has successful created]", folderPath);
        }
    }
}