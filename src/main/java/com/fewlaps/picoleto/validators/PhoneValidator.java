package com.fewlaps.picoleto.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    private static final String mobileLineRegex = "^(\\+34|0034|34)?[67]\\d{8}$";
    private static final String landLineRegex = "^(\\+34|0034|34)?[89]\\d{8}$";

    private Pattern mobilePattern = Pattern.compile(mobileLineRegex);
    private Pattern landLinePattern = Pattern.compile(landLineRegex);
    private String phoneNumber;

    private PhoneValidator(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static PhoneValidator withPhone(String phoneNumber) {
        return new PhoneValidator(phoneNumber);
    }

    public boolean isValid() {
        if (phoneNumber == null || phoneNumber.equals("")) {
            return false;
        }
        return isMobileLine() || isLaneLine();
    }

    public boolean isMobileLine() {
        Matcher matcher = mobilePattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public boolean isLaneLine() {
        Matcher matcher = landLinePattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
