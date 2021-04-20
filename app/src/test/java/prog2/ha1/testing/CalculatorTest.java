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
    @DisplayName("should display result after multiplicating positive numbers")
    void testPositiveMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "18";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after calculating percentage of a number")
    void testPercentage() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");

        String expected = "0.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after calculating 1/x")
    void testFractions() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.02";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    @Test
    @DisplayName("should display result after adding one negative number to a positive")
    void testNegativeAddition() {
        Calculator calc = new Calculator();

        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "-6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    */

    @Test
    @DisplayName("should display result after calculating numbers with dots")
    void testNumbersWithCommas() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        //assertEquals("4", calc.readScreen());
        calc.pressDotKey();
        calc.pressDigitKey(5);
        //assertEquals("5", calc.readScreen());
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        //assertEquals("4", calc.readScreen());
        calc.pressDotKey();
        calc.pressDigitKey(6);
        //assertEquals("5", calc.readScreen());
        calc.pressEqualsKey();

        String expected = "9.1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

