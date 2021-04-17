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
    @DisplayName("Should clear all the values and display 0 at the end")
    void testpressClearKey()
    {
        Calculator calc = new Calculator();
        //Beispielwerte
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        calc.pressClearKey();
        String expected1 = "0"; //Screen
        double expected2 = 0.0; //LatestValue
        String expected3 = ""; //LatestOperation
        String actual1 = calc.readScreen();
        double actual2 = calc.readlv();
        String actual3 = calc.readlO();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    @DisplayName("Should put a point after the number and not allow for any more points")
    void testpressDotKey()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(9);
        calc.pressDotKey();
        calc.pressDigitKey(9);

        String expected = "7.99";

        String actual = calc.readScreen();

        assertEquals(expected, actual);




    }
}

