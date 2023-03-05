package com.tutorial.crud.emailpassword.service;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.emailpassword.dto.ChangePasswordDTO;
import com.tutorial.crud.emailpassword.dto.EmailValuesDTO;
import com.tutorial.crud.exceptions.CustomException;
import com.tutorial.crud.security.entity.Usuario;
import com.tutorial.crud.security.repository.UsuarioRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Value("${mail.urlFront}")
    private String urlFront;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String mailFrom;

    private static final String subject = "Cambio de Contraseña";

    public Mensaje sendEmailTemplate(EmailValuesDTO dto){
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuarioOrEmail(dto.getMailTo(), dto.getMailTo());
        if(!usuarioOpt.isPresent())
            throw new CustomException(HttpStatus.NOT_FOUND, "ese usuario no existe");
        Usuario usuario = usuarioOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(usuario.getEmail());
        dto.setSubject(subject);
        dto.setUserName(usuario.getNombreUsuario());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        usuario.setTokenPassword(tokenPassword);
        usuarioRepository.save(usuario);
        sendEmail(dto);
        return new Mensaje("Te hemos enviado un correo");
    }

    public Mensaje changePassword(ChangePasswordDTO dto){
        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "Las contraseñas no coinciden");
        Optional<Usuario> usuarioOpt = usuarioRepository.findByTokenPassword(dto.getTokenPassword());
        if(!usuarioOpt.isPresent())
            throw new CustomException(HttpStatus.NOT_FOUND, "ese usuario no existe");
        Usuario usuario = usuarioOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        usuario.setPassword(newPassword);
        usuario.setTokenPassword(null);
        usuarioRepository.save(usuario);
        return new Mensaje("Contraseña actualizada");
    }


    public void sendEmail(EmailValuesDTO dto) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("userName", dto.getUserName());
            model.put("url", urlFront + dto.getTokenPassword());
            context.setVariables(model);
            String htmlText = templateEngine.process("email-template", context);
            helper.setFrom(dto.getMailFrom());
            helper.setTo(dto.getMailTo());
            helper.setSubject(dto.getSubject());
            helper.setText(htmlText, true);

            javaMailSender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }
}
