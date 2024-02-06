package nikguscode.com.crmbot.view.boards;

import nikguscode.com.crmbot.view.boardsConfiguration.RoleSelectionBoardConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleSelectionBoard extends Board {
    @Autowired
    private RoleSelectionBoardConfiguration configuration;

    @Override
    protected ArrayList<InlineKeyboardButton> setButtons() {
        return new ArrayList<>(List.of(
                InlineKeyboardButton.builder()
                        .text(configuration.getManagerBoard())
                        .callbackData(configuration.getManagerBoardCallback()).build(),
                InlineKeyboardButton.builder()
                        .text(configuration.getAdministratorBoard())
                        .callbackData(configuration.getAdministratorBoardCallback()).build()
        ));
    }
}
