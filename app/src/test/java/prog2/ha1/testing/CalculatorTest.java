package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest
{

    @Test
    @DisplayName("should display correct number after pressing digit keys")
    void testDigitInput()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(2);

        String expected = "42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive numbers")
    void testPositiveAddition()
    {
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
    void testTeilaufgabe1()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "25";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should erase the calculator screen to zero")
    void testClearKey()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display a dot on the calculator screen")
    void testDotKey()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressDotKey();
        calc.pressDigitKey(1);

        String expected = "9.1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should turn a digit into a negative number")
    void testNegativeKey()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressNegativeKey();

        String expected = "-6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("unary operators should work properly")
    void testTeilaufgabe2a()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("root");

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("you should be able to calculate with multiple operators")
    void testTeilaufgabe2b()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);

        String expected = "30";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

