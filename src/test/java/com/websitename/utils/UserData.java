package com.websitename.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.time.Instant;
import java.util.Map;

public class UserData {
    private final Map<String, Object> data;

    @SuppressWarnings("unchecked")
    public UserData() {
        Yaml yaml = new Yaml();
        InputStream in = getClass().getClassLoader().getResourceAsStream("data/user.yml");
        if (in == null) throw new IllegalStateException("data/user.yml not found in resources");
        this.data = yaml.load(in);
    }

    // --- TEMP REGISTRATION ---
    public String getTempEmail() {
        Map<String, String> temp = (Map<String, String>) data.get("tempRegistration");
        String template = temp.get("emailTemplate");
        return String.format(template, Instant.now().toEpochMilli());
    }

    public String getTempPassword() {
        Map<String, String> temp = (Map<String, String>) data.get("tempRegistration");
        return temp.get("password");
    }

    // --- PRODUCTION ---
    public String getProdEmail() {
        Map<String, String> prod = (Map<String, String>) data.get("productionRegistration");
        return prod.get("email");
    }

    public String getProdPassword() {
        Map<String, String> prod = (Map<String, String>) data.get("productionRegistration");
        return prod.get("password");
    }

    // --- LOGIN ---
    public String getValidEmail() {
        Map<String, Object> login = (Map<String, Object>) data.get("login");
        Map<String, String> valid = (Map<String, String>) login.get("valid");
        return valid.get("email");
    }

    public String getValidPassword() {
        Map<String, Object> login = (Map<String, Object>) data.get("login");
        Map<String, String> valid = (Map<String, String>) login.get("valid");
        return valid.get("password");
    }

    public String getInvalidPassword() {
        Map<String, Object> login = (Map<String, Object>) data.get("login");
        Map<String, String> invalid = (Map<String, String>) login.get("invalidPassword");
        return invalid.get("password");
    }

    public String getInvalidEmail() {
        Map<String, Object> login = (Map<String, Object>) data.get("login");
        Map<String, String> invalid = (Map<String, String>) login.get("invalidEmail");
        return invalid.get("email");
    }
}

