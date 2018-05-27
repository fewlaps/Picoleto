package com.fewlaps.picoleto;

import com.fewlaps.picoleto.validators.NIEValidator;
import com.fewlaps.picoleto.validators.NIFValidator;

public class Picoleto {

    public static final int INVALID_DOCUMENT = -1;
    public static final int TYPE_NIF = 1;
    public static final int TYPE_NIE = 2;

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
        } else if (document.toUpperCase().startsWith("X") || document.toUpperCase().startsWith("Y") || document.toUpperCase().startsWith("Z")) {
            return NIEValidator.withDocument(document).isValid();
        } else {
            return false;
        }
    }
}