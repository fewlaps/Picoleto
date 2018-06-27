package com.fewlaps.picoleto.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeValidator {

    private static final String codeRegex = "(0[0-9]|[1-4][0-9]|5[0-2])+([0-9]{3})";

    private Pattern pattern=Pattern.compile(codeRegex);
    private  String zipCode;

    private ZipCodeValidator(String zipCode) {this.zipCode=zipCode;}

    public static ZipCodeValidator withZipCode(String zipCode){return new ZipCodeValidator(zipCode);}

    public boolean isValid() {
        if (zipCode == null || zipCode.equals("")) {
            return false;
        }

        Matcher matcher = pattern.matcher(zipCode);

        if (!matcher.matches()) {
            return false;
        }

       return matcher.matches();
    }
}
