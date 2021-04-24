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
    @DisplayName("should display result after multiply two positive numbers")
    void testPositiveMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "45";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after take procent of one positive number")
    void testPositiveProcent(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("%");

        String expected = "0.09";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after take multiply of a dot numbers")
    void testDotAddition(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(9);
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "8.955";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

