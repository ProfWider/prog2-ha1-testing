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

    /*
     *
     * Ein grüner Test.
     * Dieser Test testet die Divison von zwei Komma-Zahlen
     *
     * */

    @Test
    @DisplayName("should display result after dividing comma numbers")
    void TestCommaDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
     *
     * Erster roter Test.
     * Dieser Test testet die Multiplikation von mehreren Faktoren
     *
     * */

    @Test
    @DisplayName("should display result after multiplication several factors")
    void TestNegativeDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);

        calc.pressEqualsKey();


        String expected = "8000";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    /*
     *
     * Zweiter roter Test.
     * Dieser Test testet die Prozentrechnung.
     *
     * */
    @Test
    @DisplayName("should display result after percentage")
    void TestPercentage(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);

        calc.pressUnaryOperationKey("%");


        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }







}



