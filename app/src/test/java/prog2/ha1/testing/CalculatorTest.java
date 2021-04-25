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
    @DisplayName("should display 0 after pressing clear Key")
    void calculatorCanClearScreen() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressClearKey();
        assertEquals("0",calc.readScreen());
    }

    @Test
    @DisplayName("should display result after multiplying two numbers bigger than 9, and one of them is negative")
    void calculatorCanDoMultiplyWithAllNumber() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(20);
        calc.pressBinaryOperationKey("x");
        calc.pressNegativeKey();
        calc.pressDigitKey(-20);
        calc.pressEqualsKey();
        assertEquals("400", calc.readScreen());
    }

    @Test
    @DisplayName("should display the correct number after adding two numbers, " +
            "one of them with 1/x , diese Methode testet die Methode pressUnaryOperationKey")
    void calculatorCanUsePressUnaryOperationKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(20);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(10);
        calc.pressUnaryOperationKey("1/x");


        assertEquals("20.1",calc.readScreen());
    }



}

