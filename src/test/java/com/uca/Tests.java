package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {

    @Test
    public void testCreationWithValue(){
        RomanNumber romanNumber = new RomanNumber(10);

        assertThat(romanNumber.getRoman(), equalTo("X"));
        assertThat(romanNumber.getValue(), equalTo(10));
    }

    @Test
    public void testCreationWithRoman(){
        RomanNumber romanNumber = new RomanNumber("X");

        assertThat(romanNumber.getRoman(), equalTo("X"));
        assertThat(romanNumber.getValue(), equalTo(10));
    }

    @Test
    public void testCreationWithValueAndRoman(){
        RomanNumber romanNumber = new RomanNumber(10, "X");

        assertThat(romanNumber.getRoman(), equalTo("X"));
        assertThat(romanNumber.getValue(), equalTo(10));
    }

    @Test
    public void testSettersValueAndRoman(){
        RomanNumber romanNumber = new RomanNumber();

        romanNumber.setRoman("X");
        assertThat(romanNumber.getRoman(), equalTo("X"));
        assertThat(romanNumber.getValue(), equalTo(10));


        romanNumber.setValue(20);
        assertThat(romanNumber.getRoman(), equalTo("XX"));
        assertThat(romanNumber.getValue(), equalTo(20));
    }

    @Test
    public void testValidity(){
        for (int i = 1; i < 4000; i++) {
            assertThat(RomanConverter.getNumberFromRoman(RomanConverter.getRomanFromNumber(i)), equalTo(i));
        }
    }

    @Test
    public void testDecimalToRoman(){
        assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(RomanConverter.getRomanFromNumber(10), equalTo("X"));
        assertThat(RomanConverter.getRomanFromNumber(42), equalTo("XLII"));
        assertThat(RomanConverter.getRomanFromNumber(123), equalTo("CXXIII"));
        assertThat(RomanConverter.getRomanFromNumber(256), equalTo("CCLVI"));
        assertThat(RomanConverter.getRomanFromNumber(548), equalTo("DXLVIII"));
        assertThat(RomanConverter.getRomanFromNumber(784), equalTo("DCCLXXXIV"));
        assertThat(RomanConverter.getRomanFromNumber(900), equalTo("CM"));
        assertThat(RomanConverter.getRomanFromNumber(3999), equalTo("MMMCMXCIX"));
    }

    @Test
    public void testRomanToDecimal(){
        assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(4));
        assertThat(RomanConverter.getNumberFromRoman("X"), equalTo(10));
        assertThat(RomanConverter.getNumberFromRoman("XLII"), equalTo(42));
        assertThat(RomanConverter.getNumberFromRoman("CXXIII"), equalTo(123));
        assertThat(RomanConverter.getNumberFromRoman("CCLVI"), equalTo(256));
        assertThat(RomanConverter.getNumberFromRoman("DXLVIII"), equalTo(548));
        assertThat(RomanConverter.getNumberFromRoman("DCCLXXXIV"), equalTo(784));
        assertThat(RomanConverter.getNumberFromRoman("CM"), equalTo(900));
        assertThat(RomanConverter.getNumberFromRoman("MMMCMXCIX"), equalTo(3999));
    }

    @Test
    public void testFailure(){
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));

        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("0X")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XXXXXXXXX")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XVXV")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testConverter(){
        RomanNumber twenty = new RomanNumber("XX");

        assertThat(twenty.floatValue(), equalTo(20.0f));
        assertThat(twenty.doubleValue(), equalTo(20.0));
        assertThat(twenty.intValue(), equalTo(20));
        assertThat(twenty.longValue(), equalTo(20L));
        assertThat(twenty.toString(), equalTo("The roman number XX is equal to 20 in decimal."));
    }

    @Test
    public void testComparison(){
        RomanNumber ten = new RomanNumber("X");
        RomanNumber twenty = new RomanNumber("XX");
        RomanNumber twentyBis = new RomanNumber("XX");
        RomanNumber hundred = new RomanNumber("C");

        assertThat(twenty.compareTo(twentyBis), equalTo(0));
        assertThat(twenty.compareTo(hundred), equalTo(-1));
        assertThat(twenty.compareTo(ten), equalTo(1));

        assertThat(twenty.compareTo(20), equalTo(0));
        assertThat(twenty.compareTo(100), equalTo(-1));
        assertThat(twenty.compareTo(10), equalTo(1));

        assertThat(twenty.compareTo(20.0f), equalTo(0));
        assertThat(twenty.compareTo(100.0f), equalTo(-1));
        assertThat(twenty.compareTo(10.0f), equalTo(1));

        assertThat(twenty.compareTo(20.0), equalTo(0));
        assertThat(twenty.compareTo(100.0), equalTo(-1));
        assertThat(twenty.compareTo(10.0), equalTo(1));

        assertThat(twenty.compareTo(20L), equalTo(0));
        assertThat(twenty.compareTo(100L), equalTo(-1));
        assertThat(twenty.compareTo(10L), equalTo(1));
    }

    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
