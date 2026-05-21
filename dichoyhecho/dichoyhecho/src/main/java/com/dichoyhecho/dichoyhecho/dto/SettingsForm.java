package com.dichoyhecho.dichoyhecho.dto;

public class SettingsForm {
    private boolean emailNotifications;
    private boolean marketingUpdates;

    // Getters y Setters
    public boolean isEmailNotifications() {
        return emailNotifications;
    }

    public void setEmailNotifications(boolean emailNotifications) {
        this.emailNotifications = emailNotifications;
    }

    public boolean isMarketingUpdates() { return marketingUpdates; }
    public void setMarketingUpdates(boolean marketingUpdates) {
        this.marketingUpdates = marketingUpdates;
    }
}