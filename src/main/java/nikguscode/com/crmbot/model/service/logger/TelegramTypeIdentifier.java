package nikguscode.com.crmbot.model.service.logger;

import lombok.Getter;
import nikguscode.com.crmbot.controller.TelegramTypeHandler;
import nikguscode.com.crmbot.model.service.TelegramType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Getter
public class TelegramTypeIdentifier {
    private final TelegramTypeHandler dataExtractor;

    @Autowired
    public TelegramTypeIdentifier(TelegramTypeHandler dataExtractor) {
        this.dataExtractor = dataExtractor;
    }

    public void sendTelegramType(Update update) {
        TelegramType typeOfUpdate = getTypeOfUpdate(update);
        dataExtractor.selectExtractor(update, typeOfUpdate);
    }

    private TelegramType getTypeOfUpdate(Update update) {
        if (update.hasMessage()) {
            return getMessageType(update);
        } else if (update.hasCallbackQuery()) {
            return TelegramType.CALLBACK;
        } else if (update.hasPoll()) {
            return TelegramType.POLL;
        } else if (update.hasPreCheckoutQuery()) {
            return TelegramType.PRE_CHECKOUT_QUERY;
        } else if (update.hasChannelPost()) {
            return TelegramType.CHANNEL_POST;
        } else if (update.hasChatJoinRequest()) {
            return TelegramType.CHAT_JOIN_REQUEST;
        } else if (update.hasChatMember()) {
            return TelegramType.CHAT_MEMBER;
        } else if (update.hasChosenInlineQuery()) {
            return TelegramType.CHOOSE_INLINE_QUERY;
        } else if (update.hasEditedChannelPost()) {
            return TelegramType.EDITED_CHANNEL_POST;
        } else if (update.hasEditedMessage()) {
            return TelegramType.EDITED_MESSAGE;
        } else if (update.hasInlineQuery()) {
            return TelegramType.INLINE_QUERY;
        } else if (update.hasPollAnswer()) {
            return TelegramType.POLL_ANSWER;
        } else if (update.hasShippingQuery()) {
            return TelegramType.SHIPPING_QUERY;
        } else {
            return TelegramType.UNKNOWN_UPDATE;
        }
    }
    
    private TelegramType getMessageType(Update update) {
        if (update.getMessage().hasText()) {
            return getMessageWithTextType(update);
        } else if (update.getMessage().hasPhoto()) {
            return TelegramType.PHOTO;
        } else if (update.getMessage().hasVoice()) {
            return TelegramType.VOICE;
        } else if (update.getMessage().hasAnimation()) {
            return TelegramType.ANIMATION;
        } else if (update.getMessage().hasContact()) {
            return TelegramType.CONTACT;
        } else if (update.getMessage().hasDice()) {
            return TelegramType.DICE;
        } else if (update.getMessage().hasAudio()) {
            return TelegramType.AUDIO;
        } else if (update.getMessage().hasDocument()) {
            return TelegramType.DOCUMENT;
        } else if (update.getMessage().hasEntities()) {
            return TelegramType.ENTITIES;
        } else if (update.getMessage().hasInvoice()) {
            return TelegramType.INVOICE;
        } else if (update.getMessage().hasPassportData()) {
            return TelegramType.PASSPORT_DATA;
        } else if (update.getMessage().hasLocation()) {
            return TelegramType.LOCATION;
        } else if (update.getMessage().hasPoll()) {
            return TelegramType.POLL_WITH_TEXT;
        } else if (update.getMessage().hasReplyMarkup()) {
            return TelegramType.REPLY_MARKUP;
        } else if (update.getMessage().hasSticker()) {
            return TelegramType.STICKER;
        } else if (update.getMessage().hasSuccessfulPayment()) {
            return TelegramType.SUCCESSFUL_PAYMENT;
        } else if (update.getMessage().hasViaBot()) {
            return TelegramType.VIA_BOT;
        } else if (update.getMessage().hasVideo()) {
            return TelegramType.VIDEO;
        } else if (update.getMessage().hasVideoNote()) {
            return TelegramType.VIDEO_NOTE;
        } else {
            return TelegramType.UNKNOWN_MESSAGE;
        }
    }

    private TelegramType getMessageWithTextType(Update update) {
        return update.getMessage().getText().startsWith("/") ? TelegramType.COMMAND : TelegramType.TEXT;
    }
}
