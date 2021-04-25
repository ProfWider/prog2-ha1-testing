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
    @DisplayName("should subtract two numbers from eachother")
    void testSubtraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("sould display the squareroot of the number wich was inserted")

    void testSquareRoot(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);

        calc.pressUnaryOperationKey("sqroot");

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("should subtract two negative numbers from eachother so that the sign changes and it turns into addition")
    void testSubtractionOfNegativeNumbers(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        calc.pressEqualsKey();

        String expected  = "0";
        String actual =  calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should divide the number '1'  with the number that was put in by the user")
    void testDivisionFunctionByOne(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

