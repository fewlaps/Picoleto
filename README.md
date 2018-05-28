# Picoleto 
[![Build Status](https://travis-ci.org/Fewlaps/Picoleto.svg?branch=master)](https://travis-ci.org/Fewlaps/Picoleto)
[![Coverage Status](https://coveralls.io/repos/github/Fewlaps/Picoleto/badge.svg)](https://coveralls.io/github/Fewlaps/Picoleto)
[ ![Download](https://api.bintray.com/packages/fewlaps/maven/picoleto/images/download.svg) ](https://bintray.com/fewlaps/maven/picoleto/_latestVersion)

<img src="icon.png" width="20%"/>

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

- Grab via gradle:

```groovy
repositories { jcenter() }
    
implementation 'com.fewlaps.picoleto:picoleto:1.0.0'
```

- Grab via Maven:

```
<dependency>
  <groupId>com.fewlaps.picoleto</groupId>
  <artifactId>picoleto</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

Or check [bintray](https://bintray.com/fewlaps/maven/picoleto/) to get the latest jar file
