package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.SettingsForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String viewSettings(Model model, HttpSession session) {
        SettingsForm form = new SettingsForm();

        Boolean emailSession = (Boolean) session.getAttribute("sessionEmailNotifications");
        Boolean marketingSession = (Boolean) session.getAttribute("sessionMarketingUpdates");


        if (emailSession == null) {
            emailSession = true;
            session.setAttribute("sessionEmailNotifications", emailSession);
        }
        if (marketingSession == null) {
            marketingSession = false;
            session.setAttribute("sessionMarketingUpdates", marketingSession);
        }

        form.setEmailNotifications(emailSession);
        form.setMarketingUpdates(marketingSession);

        model.addAttribute("settingsForm", form);
        return "settings";
    }

    @PostMapping("/settings/save")
    public String saveSettings(@ModelAttribute("settingsForm") SettingsForm form, HttpSession session) {

        //Seleccion del usuario (web)
        boolean emailSelected = form.isEmailNotifications();
        boolean marketingSelected = form.isMarketingUpdates();

        session.setAttribute("sessionEmailNotifications", emailSelected);
        session.setAttribute("sessionMarketingUpdates", marketingSelected);

        System.out.println("Email Notifications guardado como: " + emailSelected);
        System.out.println("Marketing Updates guardado como: " + marketingSelected);

        return "redirect:/settings?success";
    }
}