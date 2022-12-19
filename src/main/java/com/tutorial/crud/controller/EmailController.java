package com.tutorial.crud.controller;


import com.tutorial.crud.dto.EmailValuesDTO;
import com.tutorial.crud.security.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/email/send")
    public ResponseEntity<?> sendEmail() {
        emailService.sendEmail();
        return new ResponseEntity("Correo enviado con éxito", HttpStatus.OK);
    }

    @PostMapping("/email/send-html")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
        emailService.sendEmailTemplate(dto);
        return new ResponseEntity("Correo con plantilla enviado con éxito", HttpStatus.OK);
    }
}
