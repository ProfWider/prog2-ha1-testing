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
    @DisplayName("should display result after adding two positive numbers")
    void testSubtracion() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should operate the root function")
    void WurzelausNummer() {

        var calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("v");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();


        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should operate the percent function")
    void ProzentFunction() {

        var calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("%");
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "0.05";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after multiplicate two positive numbers")
    void testMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should operate the percent function")
    void ProzentFunctionn() {

        var calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("%%");
        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("%%");
        calc.pressEqualsKey();

        String expected = "0.16";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Display out the 1/x Operation")

    void XFunktion(){

        var calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressUnaryOperationKey("1/x");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "0.3333333333333333";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

}



