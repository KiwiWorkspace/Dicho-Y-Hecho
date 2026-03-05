package com.dichoyhecho.dichoyhecho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarConfirmacion(String correo) {

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correo);
        mensaje.setSubject("Registro verificado pa (sigo probando)");
        mensaje.setText("Su registro se a realizado exitosamente (culpa de las propiedades no se ejecutan bien, pero a ti si te llega creo).");

        mailSender.send(mensaje);
    }
}