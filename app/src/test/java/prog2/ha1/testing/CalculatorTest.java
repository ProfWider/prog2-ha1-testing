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


    // 1. neuer grüner Test
    @Test
    @DisplayName("should display result after subtracting two positive numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    // 2. neuer grüner Test
    @Test
    @DisplayName("should display cleared screen")
    void testClearedScreen(){

        Calculator calc = new Calculator ();

        calc.pressDigitKey(8);
        calc.pressClearKey();


        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }



    // 1. roter Test

    @Test
    @DisplayName("should display error when dividing with 0")
    void testDivisionNull(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "ERROR";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }







    // 2. roter Test
    @Test
    @DisplayName("should display the  % factor")
    void testProcentFactor (){

        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("%");

        String expected = "0.42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }






}

