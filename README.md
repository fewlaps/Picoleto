# Picoleto 
[![Build Status](https://travis-ci.org/Fewlaps/Picoleto.svg?branch=master)](https://travis-ci.org/Fewlaps/Picoleto)

Picoleto is the gentleman that will validate your Spanish identity documents.

Give him a document number, and he will tell you which kind of document it is and if it is a valid or a fake one!

## How does it works?

Validate a document:

```java
String document = "71573454F";
boolean isValid = Picoleto.withDocument(document).isValid());
```

Want to know the document type?

```java
String document = "71573454F";
int documentType = Picoleto.withDocument(document).getDocumentType();

if (documentType == Picoleto.TYPE_NIF) {
    //TODO Your NIF stuff
} else if (documentType == Picoleto.TYPE_NIE) {
    //TODO Your NIE stuff
} else if (documentType == Picoleto.INVALID_DOCUMENT) {
    //TODO don't try to fool the picoleto!!
}
```

## Download

Grab via gradle:

```groovy
repositories { jcenter() }
    
compile 'com.fewlaps.picoleto:picoleto:1.0.0'
```
