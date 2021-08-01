package com.tutorial.crud.emailpassword.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.emailpassword.dto.EmailValuesDTO;
import com.tutorial.crud.emailpassword.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/email-password")
@CrossOrigin
public class EmailController {

    @Autowired
    EmailService emailService;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
        dto.setMailFrom(mailFrom);
        dto.setSubject("Cambio de Contraseña");
        dto.setUserName("Juan");
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        emailService.sendEmail(dto);
        return new ResponseEntity(new Mensaje("Te hemos enviado un correo"), HttpStatus.OK);
    }

}
