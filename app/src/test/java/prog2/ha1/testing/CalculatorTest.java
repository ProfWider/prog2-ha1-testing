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
    @DisplayName("should display 1 from the division of two equal numbers")
    void testDivisonTwoEqualNumbers() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();
        String expected = "1";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display 7 for the sqrt of 49 (Two Digits)")
    void testSqrt() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(49);
        calc.pressUnaryOperationKey("sqr");
        String expected = "7.0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display 0.1 for the 1/10")
    void testOneDivideByX() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");
        String expected = "0.2";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

