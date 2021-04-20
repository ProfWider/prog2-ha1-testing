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
    @DisplayName("should display result after subtracting two numbers")
    void testSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should display result after dividing a number by X")
    void testDividingByX() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display the percentage of the number")
    void testPercentage() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("sum up 3 numbers")
    void testBinaryKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}
