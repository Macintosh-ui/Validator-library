# Java Validator Library

***

## Specs:
* String validation
* Number validation
* Map validation

***

### Requirements:
+ Java 21
  
***

### How to use:
* Import library into your project
* Add dependecy
#### Creating schemas:
* Create object of class Validator
* validator.String to String validation
* validator.number to Number validation
* validator.map to Map validation
  
***

##### String methods
* .required() to null check
* .minLength(int length) to String length check
* .contains(String substring) to search if String contains substring

##### Number methods
* .required() to null check
* .positive() to check if the value is positive
* .rang(int min, int max) to check if value > min and value < max

##### Map methods
* .required() to null check
* .sizeOf(int size) to check if value size > size
* .shape(Map<String, BaseSchema<String>> map) to integrated check
  
***

### Hexlet tests and linter status:
[![Actions Status](https://github.com/Macintosh-ui/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Macintosh-ui/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/789ab51f0619824e14d5/maintainability)](https://codeclimate.com/github/Macintosh-ui/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/789ab51f0619824e14d5/test_coverage)](https://codeclimate.com/github/Macintosh-ui/java-project-78/test_coverage)
[![Java CI](https://github.com/Macintosh-ui/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/Macintosh-ui/java-project-78/actions/workflows/main.yml)

