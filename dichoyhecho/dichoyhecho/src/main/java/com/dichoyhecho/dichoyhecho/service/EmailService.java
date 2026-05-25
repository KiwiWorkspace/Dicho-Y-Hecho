package com.dichoyhecho.dichoyhecho.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.MessageInterpolator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendConfirmation(String destino, String nombre) throws MessagingException {

        Context context = new Context();


        context.setVariable("nombre", nombre);

        context.setVariable(
                "link",
                "http://localhost:8081/login"
        );


        String html = templateEngine.process(
                "email/welcome",
                context
        );

        MimeMessage message =
                mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(
                        message,
                        true,
                        "UTF-8"
                );
        helper.setTo(destino);

        helper.setSubject(
                "Bienvenido a Dicho y Hecho"
        );

        helper.setText(html, true);

        mailSender.send(message);

        try {
            mailSender.send(message);
            System.out.println("✅ Correo entregado al servidor de Google");
        } catch (Exception e) {
            System.err.println("❌ Error enviando correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}