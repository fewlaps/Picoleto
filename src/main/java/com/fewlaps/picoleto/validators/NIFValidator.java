package com.fewlaps.picoleto.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NIFValidator {

    private static final String nifRegex = "(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])";
    private static final String validCharacters = "TRWAGMYFPDXBNJZSQVHLCKE";

    private Pattern pattern = Pattern.compile(nifRegex);
    private String document;

    private NIFValidator(String document) {
        this.document = document;
    }

    public static NIFValidator withDocument(String document) {
        return new NIFValidator(document);
    }

    public boolean isValid() {
        if (document == null || document.equals("")) {
            return false;
        }

        Matcher matcher = pattern.matcher(document);

        if (!matcher.matches()) {
            return false;
        }

        int nifNumber = Integer.parseInt(matcher.group(1));
        String nifLetter = matcher.group(2);

        int charIndex = nifNumber % 23;

        return nifLetter.equalsIgnoreCase(validCharacters.substring(charIndex, charIndex + 1));
    }
}