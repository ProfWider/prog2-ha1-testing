package prog2.ha1.testing;

import org.junit.jupiter.api.AfterAll;
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

    /**
     * HA Teilaufgabe 1: Schreiben Sie einen neuen zusätzlichen Test, der eine bisher nicht getestete Funktionalität abdeckt, die bereits funktioniert und der daher direkt grün wird.
     */
    @Test
    @DisplayName("should display result after subtracting two positive numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    /**
     * HA Teilaufgabe 2: Schreiben Sie zwei weitere zusätzliche Tests, die zwei unterschiedliche Implementierungslücken bzw. Fehler aufdecken (und in jedem Fall zwei unterschiedliche Methoden-Aufruf-Kombinationen testen) und somit fehlschlagen.
     */
    @Test
    @DisplayName("should display negative number")
    void testNegativeNumber() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(2);

        String expected = "-2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display percentage in decimal number")
    void testPercentButton() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");

        String expected = "0.75";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}
