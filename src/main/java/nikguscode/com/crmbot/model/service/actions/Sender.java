package nikguscode.com.crmbot.model.service.actions;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public interface Sender {
    BotApiMethod<?> send(Update update);
}
