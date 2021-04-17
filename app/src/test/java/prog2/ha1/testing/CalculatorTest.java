package prog2.ha1.testing;

import org.checkerframework.checker.units.qual.C;
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
    @DisplayName("should display result after subtract two positive number: 3-7")
    void testSubtraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(7);
        calc.pressEqualsKey();

        String actual = calc.readScreen();
        String expected = "-4";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after square root one positive number")
    void testSquareRoot(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("√");

        String actual = calc.readScreen();
        String expected = "3";
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("continually do another binary operation without pressing equal key (to save result to screen)")
    void testContinuePressing(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("√");
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();

        String actual = calc.readScreen();
        String expected = "7";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("press continually from the previous test without pressing equal key (to save result to screen)")
    void testContinuePressing1(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("√");
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String actual = calc.readScreen();
        String expected = "10";
        assertEquals(expected, actual);
    }




}

