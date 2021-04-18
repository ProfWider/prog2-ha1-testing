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
    @DisplayName("should display result after multiply one positive and one negative number")
    void calculatorCanDoMultiplyTwo() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        assertEquals("-50", calc.readScreen());
    }

    @Test
    @DisplayName("should display the number after using clear key")
    void calculatorCanShowNumberAfterUsingClearKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressClearKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        assertEquals("2", calc.readScreen());
    }

    @Test
    @DisplayName("should display result after using square root for a number")
    void calculatorCanDoSquareRoot() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("wurzel");
        assertEquals("2.0", calc.readScreen());
    }
}

