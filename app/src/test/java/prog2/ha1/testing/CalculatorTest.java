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


    // first green test with multiply function 
    @Test
    @DisplayName("should display result after multiplying two positive numbers")
        // green test other functionality tested
    void calculatorCanDoMulti() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        assertEquals("15", calc.readScreen());
    }
    /*
    @Test
    @DisplayName("executable with none of the given operations")
        // 1st red test
        // 1st green test
    void calculatorCanDoAddTwoFloating() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressEqualsKey();
        assertEquals("0", calc.readScreen());
    }

    @Test
    @DisplayName("should display result after dividing by a floating number")
        // 2nd red test
    void calculatorCanDoDivByFloating() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        assertEquals("2", calc.readScreen());
    } */
}

