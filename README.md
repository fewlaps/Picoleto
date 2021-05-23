# Picoleto 
[![Build Status](https://travis-ci.org/Fewlaps/Picoleto.svg?branch=master)](https://travis-ci.org/Fewlaps/Picoleto)
[![Coverage Status](https://coveralls.io/repos/github/Fewlaps/Picoleto/badge.svg)](https://coveralls.io/github/Fewlaps/Picoleto)

<img src="icon.png" width="20%"/>

Picoleto is the gentleman that will validate your Spanish documents:

* Identity 
              
   * NIF

   * NIE 

   * Passport

* Phones

   * MobileLine
   * LandLine

* ZipCodes

## How does it works?

Give him a document number, and he will tell you which kind of document it is and if it is a valid or a fake one!

Now You can do the same with phones and zipcodes!

Validate a Document,Phone or ZipCode:

```java
String document = "71573454F";
boolean documentValid = Picoleto.withDocument(document).isValid();

String phone = "616333383";
boolean phoneValid = Picoleto.withPhone(phone).isValid();

String zipCode = "17750";
boolean zipCodeValid = Picoleto.withZipCode(zipCode).isValid();
```

Want to know the document type?

```java
String document = "71573454F";
int documentType = Picoleto.withDocument(document).getType();

if (documentType == Picoleto.TYPE_NIF) {
    //TODO Your NIF stuff
} else if (documentType == Picoleto.TYPE_NIE) {
    //TODO Your NIE stuff
} else if (documentType == Picoleto.TYPE_PASSPORT) {
    //TODO Your PASSPORT stuff
} else if (documentType == Picoleto.INVALID_DOCUMENT) {
    //TODO don't try to fool the picoleto!!
}
```

If you want know the type of phone

```java
String phone = "616333383";
int phoneType = Picoleto.withPhone(phone).getType();

if (phoneType == Picoleto.TYPE_MOBILE_LINE) {
    //TODO Your Mobile line stuff
} else if (phoneType == Picoleto.TYPE_LANE_LINE) {
    //TODO Your Land line stuff
} else if (phoneType == Picoleto.INVALID_PHONE_NUMBER) {
    //TODO Not a Spanish line
}
```
## Download

- Grab via gradle:

```groovy
repositories { jcenter() }

implementation 'com.fewlaps.picoleto:picoleto:1.2.0'
```

- Grab via Maven:

```
<dependency>
  <groupId>com.fewlaps.picoleto</groupId>
  <artifactId>picoleto</artifactId>
  <version>1.2.0</version>
  <type>pom</type>
</dependency>
```

Or check [bintray](https://bintray.com/fewlaps/maven/picoleto/) to get the latest jar file
