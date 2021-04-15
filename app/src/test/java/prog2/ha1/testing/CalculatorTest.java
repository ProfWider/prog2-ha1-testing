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

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should call and display a remembered value")
    void testCallRememberedValue() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressMplusKey();
        calc.pressClearKey();
        calc.pressMRKey();

        String expected = "8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should erase the remembered value")
    void testEraseRememberedValue() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressMplusKey();
        calc.pressClearKey();
        calc.pressMCKey();
        calc.pressMRKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

