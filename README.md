# Roman Number Converter

A simple Java project to convert between Roman numerals and decimal numbers.

---

## Features

- Convert decimal numbers (1 to 3999) to Roman numerals.
- Convert valid Roman numerals to decimal numbers.
- Input validation with clear error messages.

---

## Usage

- Use the `RomanConverter` class for conversion:
  - `getRomanFromNumber(int number)`: returns the Roman numeral string.
  - `getNumberFromRoman(String roman)`: returns the decimal integer.

- `RomanNumber` class represents a Roman numeral with both formats and supports comparison.

---

## Example

```java
RomanNumber roman = new RomanNumber("IV");
System.out.println(roman.getValue()); // Outputs: 4
System.out.println(roman.getRoman()); // Outputs: IV
```

---

## Requirements

- Java 8 or higher

---

## Author

Mark Ballereau  
[GitHub](https://github.com/markblre) | [LinkedIn](https://www.linkedin.com/in/markblre)
