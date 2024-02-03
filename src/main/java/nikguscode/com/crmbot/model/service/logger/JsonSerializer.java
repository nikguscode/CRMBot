package nikguscode.com.crmbot.model.service.logger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonSerializer {
    @Autowired
    private FileLogger fileLogger;

    public void serializeToJsonFormat(UpdateData data) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            String json = objectMapper.writeValueAsString(data);
            fileLogger.updateLogs(json, data.getDataType());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
