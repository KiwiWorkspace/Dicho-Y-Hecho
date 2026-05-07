package com.dichoyhecho.dichoyhecho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmation(String correo) {

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("dichoyhechoweb@gmail.com");
        mensaje.setTo(correo);
        mensaje.setSubject("Registration verified.");
        mensaje.setText("Your registration has been completed successfully ✅." + "");

        try {
            mailSender.send(mensaje);
            System.out.println("✅ Correo entregado al servidor de Google");
        } catch (Exception e) {
            System.err.println("❌ Error enviando correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}