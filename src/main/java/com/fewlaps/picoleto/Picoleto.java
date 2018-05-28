package com.fewlaps.picoleto;

import com.fewlaps.picoleto.validators.NIEValidator;
import com.fewlaps.picoleto.validators.NIFValidator;
import com.fewlaps.picoleto.validators.PassportValidator;

public class Picoleto {

    public static final int INVALID_DOCUMENT = -1;
    public static final int TYPE_NIF = 1;
    public static final int TYPE_NIE = 2;
    public static final int TYPE_PASSPORT = 3;

    private String document;

    private Picoleto(String document) {
        this.document = document;
    }

    public static Picoleto withDocument(String document) {
        return new Picoleto(document);
    }

    public int getDocumentType() {
        if (document == null || document.equals("")) {
            return INVALID_DOCUMENT;
        }

        if (NIFValidator.withDocument(document).isValid()) {
            return TYPE_NIF;
        } else if (PassportValidator.withDocument(document).isValid()) {
            return TYPE_PASSPORT;
        } else if (NIEValidator.withDocument(document).isValid()) {
            return TYPE_NIE;
        } else {
            return INVALID_DOCUMENT;
        }
    }

    public boolean isValid() {
        if (document == null || document.equals("")) {
            return false;
        }

        if (Character.isDigit(document.charAt(0))) {
            return NIFValidator.withDocument(document).isValid();
        } else if (document.length() > 3 && Character.isAlphabetic(document.charAt(0)) && Character.isAlphabetic(document.charAt(1)) && Character.isAlphabetic(document.charAt(2))) {
            return PassportValidator.withDocument(document).isValid();
        } else if (document.toUpperCase().startsWith("X") || document.toUpperCase().startsWith("Y") || document.toUpperCase().startsWith("Z")) {
            return NIEValidator.withDocument(document).isValid();
        } else {
            return false;
        }
    }
}