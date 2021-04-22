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

    //green Test

    @Test
    @DisplayName("should display result after subtracting two positive numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        //Test Eingaben
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        //Erwartetetes Ergebnis
        String expected = "3";
        String actual = calc.readScreen();

        //Vergleich
        assertEquals(expected, actual);


    }




}

