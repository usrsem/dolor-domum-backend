package com.idevtier.dolordomumbackend.domain.callback.service;

import com.idevtier.dolordomumbackend.domain.callback.model.input.ContactMessageRequestModel;

public interface ContactService {
    void handleContactMessage(ContactMessageRequestModel requestModel);
}
