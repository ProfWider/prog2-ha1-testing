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
    @DisplayName("das Ergebnis von 3 mal 2 macht 6 ")
    void testPositiveAA() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("das Ergebnis von 30 mal 20 macht 600 ")
    void test2Zahlen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(30);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(20);
        calc.pressEqualsKey();

        String expected = "600";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("das Ergebnis von Wurzel 144 ist 12")
    void test3Root() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(144);
        calc.pressUnaryOperationKey("root");
        String expected = "12";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}


