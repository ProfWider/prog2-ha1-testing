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
    @DisplayName("should display result after multiplying two positive numbers")
    void testPositiveMultiplying() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after adding two nigative numbers")
    void testNegativeAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(-2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(-2);
        calc.pressEqualsKey();

        String expected = "-4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after division two positive numbers")
    void testAddingNegativeNumbers() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "0.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after converting to percent (dividing 100)")
    void testPercentDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");
        //calc.pressEqualsKey();

        String expected = "0.05";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after Dividing the numbber one on Variable)")
    void testOneDvisionVariable() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("1/x");


        String expected = "0.2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after calculating the square roots of a numbber")
    void testWurzelZiehen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("Wurzel");


        String expected = "3.0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
//

    @Test
    @DisplayName("should reset the konsole")
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressClearKey();


        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should switch result Positive to Negative ")
    void testSwitchtoNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressNegativeKey("+/-");

        String expected = "-9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


}

