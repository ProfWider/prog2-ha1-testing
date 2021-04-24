package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display correct number after pressing digit keys") // Displayanzeige
    void testDigitInput() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(2);

        String expected = "42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive numbers") // Addition
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
    // Teilaufgabe 1

    @Test
    @DisplayName("should display result after subtracting two positive numbers") // Subtraktion
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // Teilaufgabe 2

    @Test
    @DisplayName("should display result after calculating percentage of numbers") // Prozentzeichen
    void testPercentage() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("%");
        calc.pressEqualsKey();

        String expected = "0.66";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive decimal numbers")
    void testDecimal() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        assertEquals("8", calc.readScreen());
        calc.pressDotKey();
        calc.pressDigitKey(1);
        assertEquals("8.1", calc.readScreen());
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        assertEquals("1", calc.readScreen());
        calc.pressDotKey();
        calc.pressDigitKey(2);
        assertEquals("1.2", calc.readScreen());
        calc.pressEqualsKey();

        String expected = "9.3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}