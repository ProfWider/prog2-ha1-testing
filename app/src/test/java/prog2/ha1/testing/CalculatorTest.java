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
    @DisplayName("should display negative number after pressing the negative key")
    void testNegativeKey(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressNegativeKey();

        String expected = "-4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display correct result after taking the square root of a positive number")
    void testPressUnaryOperationKey(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("square root");

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should display only the first dot when the dot key is pressed multiple times")
    void testMultipleDots(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(4);
        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(4);

        String expected = "4.444";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

