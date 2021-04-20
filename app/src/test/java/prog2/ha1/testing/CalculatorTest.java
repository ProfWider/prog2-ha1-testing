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

    // Grüner Test
    @Test
    @DisplayName("should display a dot between two numbers")
    void testDotInput() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(2);

        String expected = "4.2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // 2. Grüner Test
    @Test
    @DisplayName("should display a negative number")
    void testNegativeKey() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    // 1. Roter Test
    @Test
    @DisplayName("should display correct number after percentage calculation")
    void testPercentageCalculation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");

        String expected = "7";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    // 2. Roter Test
    @Test
    @DisplayName("should display correct number")
    void testDoubleAddition() {
        Calculator calc = new Calculator();


        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();


        String expected = "4.4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

