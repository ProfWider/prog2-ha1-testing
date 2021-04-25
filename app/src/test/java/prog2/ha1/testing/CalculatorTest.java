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
    @DisplayName("should display result after subtraction of two positive numbers")
    void testSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "-1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after subtraction of two negative numbers")
    void testNegativeAddition() {
        Calculator calc = new Calculator();

        calc.pressBinaryOperationKey("-");
        calc.pressNegativeKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressBinaryOperationKey("-");
        calc.pressNegativeKey(6);
        calc.pressEqualsKey();

        String expected = "-8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display current number after pressing equals key")
    void testcurrentnumber() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

/*    @Test
    @DisplayName("calculate the square root")
    void testsquareroot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressUnaryOperationKey("Wurzel");

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
*/

}


