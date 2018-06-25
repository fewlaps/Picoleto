package com.fewlaps.picoleto;

import com.fewlaps.picoleto.validators.NIEValidator;
import com.fewlaps.picoleto.validators.NIFValidator;
import com.fewlaps.picoleto.validators.PassportValidator;
import com.fewlaps.picoleto.validators.PhoneValidator;
import com.fewlaps.picoleto.validators.ZipCodeValidator;

public class Picoleto {

    public static final int INVALID_INPUT = -1;
    public static final int INVALID_DOCUMENT = -2;
    public static final int INVALID_PHONE_NUMBER = -3;
    public static final int INVALID_ZIP_CODE = -4;

    public static final int TYPE_NIF = 1;
    public static final int TYPE_NIE = 2;
    public static final int TYPE_PASSPORT = 3;

    public static final int TYPE_MOBILE_LINE = 4;
    public static final int TYPE_LANE_LINE  = 5;

    public static final int TYPE_ZIP_CODE = 6;

    private static final int INPUT_DOCUMENT = 101;
    private static final int INPUT_PHONE = 102;
    private static final int INPUT_ZIP_CODE = 103;

    private String input;
    private int inputType;

    private Picoleto(String input, int inputType) {
        this.input = input;
        this.inputType = inputType;
    }

    public static Picoleto withDocument(String document) {
        return new Picoleto(document, INPUT_DOCUMENT);
    }

    public static Picoleto withPhone(String phone) {
        return new Picoleto(phone, INPUT_PHONE);
    }

    public static Picoleto withZipCode(String zipCode){return new Picoleto(zipCode, INPUT_ZIP_CODE); }

    public int getType() {
        if (input == null || input.equals("")) {
            return INVALID_INPUT;
        }

        if (inputType == INPUT_DOCUMENT) {
            if (NIFValidator.withDocument(input).isValid()) {
                return TYPE_NIF;
            } else if (PassportValidator.withDocument(input).isValid()) {
                return TYPE_PASSPORT;
            } else if (NIEValidator.withDocument(input).isValid()) {
                return TYPE_NIE;
            } else {
                return INVALID_DOCUMENT;
            }
        } else if (inputType == INPUT_PHONE) {
            if (PhoneValidator.withPhone(input).isMobileLine()) {
                return TYPE_MOBILE_LINE;
            } else if (PhoneValidator.withPhone(input).isLaneLine()) {
                return TYPE_LANE_LINE;
            } else {
                return INVALID_PHONE_NUMBER;
            }
        } else if (inputType == INPUT_ZIP_CODE) {
            if (ZipCodeValidator.withZipCode(input).isValid()) {
                return TYPE_ZIP_CODE;
            }else {
                return INVALID_ZIP_CODE;
            }
        }

        return INVALID_INPUT;
    }

    public boolean isValid() {
        if (input == null || input.equals("")) {
            return false;
        }

        if (inputType == INPUT_DOCUMENT) {
            if (Character.isDigit(input.charAt(0))) {
                return NIFValidator.withDocument(input).isValid();
            } else if (input.length() > 3 && Character.isAlphabetic(input.charAt(0)) && Character.isAlphabetic(input.charAt(1)) && Character.isAlphabetic(input.charAt(2))) {
                return PassportValidator.withDocument(input).isValid();
            } else if (input.toUpperCase().startsWith("X") || input.toUpperCase().startsWith("Y") || input.toUpperCase().startsWith("Z")) {
                return NIEValidator.withDocument(input).isValid();
            } else {
                return false;
            }
        } else if (inputType == INPUT_PHONE) {
            return PhoneValidator.withPhone(input).isValid();
        } else if (inputType == INPUT_ZIP_CODE) {
            return ZipCodeValidator.withZipCode(input).isValid();
        }

        return false;
    }
}