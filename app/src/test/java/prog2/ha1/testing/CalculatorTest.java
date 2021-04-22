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

    //Teilaufgabe 1 - gruener Test
    @Test
    @DisplayName("should display negativ number")
    void testDiplayNegativNumber() {
        Calculator calc = new Calculator();


        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        String expected = "-2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2 : neuer roter Test
    @Test
    @DisplayName("New Button for OperationKey")
    void calculatorOperationKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressUnaryOperationKey("1/x");
        String expected = "0.3333333333333333";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2 : neuer roter Test
    @Test
    @DisplayName("Test: should display decimal number after double using pressDotKey")
    void calculatorCanDisplayAllDecimalnumbers() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();
        String expected = "1.522";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

