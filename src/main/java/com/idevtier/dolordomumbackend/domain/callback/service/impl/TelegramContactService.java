package com.idevtier.dolordomumbackend.domain.callback.service.impl;

import com.idevtier.dolordomumbackend.domain.callback.model.input.ContactMessageRequestModel;
import com.idevtier.dolordomumbackend.domain.callback.service.ContactService;
import com.idevtier.dolordomumbackend.telegram.boudnaries.TelegramMessageSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TelegramContactService implements ContactService {

    private final TelegramMessageSender telegramMessageSender;

    @Override
    public void handleContactMessage(ContactMessageRequestModel requestModel) {
        telegramMessageSender.send(convertToString(requestModel));
    }

    private String convertToString(ContactMessageRequestModel requestModel) {
        return "From: " + requestModel.fullname() + "\n"
                + "E-mail: " + requestModel.email() + "\n"
                + "Phone: " + requestModel.phone() + "\n\n"
                + "Message: " + requestModel.message();
    }
}
