package com.fewlaps.picoleto.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportValidator {

    private static final String passportRegex = "((?i)[a-z]{3}[0-9]{6}[a-z]?$)";
    private Pattern pattern = Pattern.compile(passportRegex);

    private final String document;

    private PassportValidator(String document) { this.document = document; }

    public static PassportValidator withDocument(String document) {return new PassportValidator(document); }

    public boolean isValid() {
        if (document == null || document.equals("")) {
            return false;
        }

        Matcher matcher = pattern.matcher(document);

        return matcher.matches();
    }
}
