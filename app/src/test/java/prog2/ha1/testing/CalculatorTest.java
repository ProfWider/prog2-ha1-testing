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

    @Test
    @DisplayName("should clear all latest values and inputs by pressing the CE button")
    void testClearAllValues() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display square root of two positive numbers")
    void testPositiveDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressUnaryOperationKey("sqrt");

        String expected = "2,44948974";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //TODO hier weitere Tests erstellen
}

