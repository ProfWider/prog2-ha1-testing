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
    @Test
    @DisplayName("should reset all values")
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        calc.pressClearKey();

        String expectedScreen = "0";
        String expectedLatestOperation = "";
        double expectedLatestValue = 0.0;

        String actualScreen = calc.readScreen();
        String actualLatestOperation = calc.getLatestOperation();
        double actualLatestValue = calc.getLatestValue();

        assertEquals(expectedScreen, actualScreen);
        assertEquals(expectedLatestOperation, actualLatestOperation);
        assertEquals(expectedLatestValue, actualLatestValue);
    }

    @Test
    @DisplayName ("should show negative number when pressing negative key first")
    void testNegativeKey() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(3);

        String expected = "-3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName ("should show Error, if division with zero")
    void divisionWithZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}
