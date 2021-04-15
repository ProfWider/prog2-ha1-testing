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
    @DisplayName("Should remove second zero")
    void testRedundantZero() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(0);
        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    // Test lücken
    @Test
    @DisplayName("Test Dot")
    void testDotDot() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(1);
        String expected = "1.11";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test + mit double stellen")
    void testDoubleStellenOperation() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDigitKey(1);
        calc.pressEqualsKey();
        String expected = "22";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

