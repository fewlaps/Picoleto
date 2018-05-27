package com.fewlaps.picoleto.validators;

public class NIEValidator {

    private String document;

    private NIEValidator(String document) {
        this.document = document;
    }

    public static NIEValidator withDocument(String document) {
        return new NIEValidator(document);
    }

    public boolean isValid() {
        if (document == null || document.equals("")) {
            return false;
        }

        String nif = document.substring(1);
        if (document.toUpperCase().startsWith("X")) {
            nif = "0" + nif;
        } else if (document.toUpperCase().startsWith("Y")) {
            nif = "1" + nif;
        } else if (document.toUpperCase().startsWith("Z")) {
            nif = "2" + nif;
        }

        return NIFValidator.withDocument(nif).isValid();
    }
}
