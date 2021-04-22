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
    @DisplayName("should display result after division comma number")
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
}

    /*
     *
     * Erster roter Test.
     * Dieser Test testet die Divison von zwei negativen Zahlen
     *
     * */


    @Test
    @DisplayName("should display result after negative division ")
    void TestNegativeDivision() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("/");
        calc.pressNegativeKey();
        calc.pressDigitKey(2);


        String expected = "-10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
     *
     * Zweiter roter Test.
     * Dieser Test testet die Subtraktion von zwei negativen Komma-Zahlen
     *
     * */


    @Test
    @DisplayName("should display result after divison two negativ Komma Zahlen")
    void TestNegativeSubtraction(){
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);

        calc.pressBinaryOperationKey("-");

        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);


        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
     *
     * Dritter roter Test.
     * Dieser Test testet die Addition von zwei Zahlen ohne ein Rechenzeichen
     *
     * */


    @Test
    @DisplayName("should display result after add without operation key")
    void TestAddWithoutOperationsKey(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("/");
        calc.pressEqualsKey();


        String expected = "55";

        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}



