package com.idevtier.dolordomumbackend.domain.callback.controller;

import com.idevtier.dolordomumbackend.domain.callback.model.input.ContactMessageRequestModel;
import com.idevtier.dolordomumbackend.domain.callback.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contact")
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void lendContactMessage(@RequestBody ContactMessageRequestModel requestModel) {
        contactService.handleContactMessage(requestModel);
    }
}
