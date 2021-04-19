package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display correct number after pressing digit keys")
    void testDigitInput() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(2);

        String expected = "42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen
//test one
    @Test
    @DisplayName("should display result after multiplying a positive with a negative number")
    void calculatorCanDoFiveMultiplyingThree() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressNegativeKey();
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        assertEquals("-15", calc.readScreen());
    }

    //test case two
    @Test
    @DisplayName("should return a result for operations on digits greater 9")
    void calculatorOperationsOnDigitsGreaterNine() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(16);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(16);
        calc.pressEqualsKey();
        assertEquals("256", calc.readScreen());
    }

    //test case three
    @Test
    @DisplayName("should return a decimal number on display")
    void calculatorCanDoDecimal() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressDotKey();
        calc.pressDigitKey(3);
        assertEquals("5.3", calc.readScreen());
    }

}

