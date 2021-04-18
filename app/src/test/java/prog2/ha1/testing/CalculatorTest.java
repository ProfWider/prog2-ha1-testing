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
        //Teilaufgabe 1 - Grüner Test
    @Test
    @DisplayName("should display result after subtracting two positive numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


        //Teilaufgabe 2 - 2 x Roter Test
    @Test
    @DisplayName("should display result after dividing the number by 100")
    void testPercentage() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressUnaryOperationKey("%");
        //calc.pressDigitKey();
        calc.pressEqualsKey();

        String expected = "0.08";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after the root of the number got calculated")
    void testRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("V");
       // calc.pressDigitKey();
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

