package org.youCater.utils;

public class SharedContextAttributeManager {

    private boolean emailNotSent = true;

    public boolean isEmailNotSent() {
        return emailNotSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailNotSent = !emailSent;
    }
}
