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
    //Green Test
    @Test
    @DisplayName("should clear the screen")
    void testPressClearKey() {

        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressClearKey();
        String expected = "0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

        System.out.println("ergebnis" + "=" + calc.readScreen());
    }
    //Red test
    @Test
    @DisplayName("should sum up two double figure digit numbers")
    void testTwoDigitNumbers() {

        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected = "44";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

        System.out.println("ergebnis" + "=" + calc.readScreen());
    }
    @Test
    @DisplayName("should multiply two times in a row ")
    void calculatorCanMultiplyTwoTimesInaRow() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        String expected = "27";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
        System.out.println("ergebnis" + "=" + calc.readScreen());
    }
}

