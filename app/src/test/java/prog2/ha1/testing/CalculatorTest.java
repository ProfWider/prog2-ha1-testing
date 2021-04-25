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

    // positiver Test
    @Test
    @DisplayName("should display result after subtracting two positive numbers")
    void testPositiveSubtraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    // 2 negative Tests
    @Test
    @DisplayName("should display percentage")
     void negativeTestOne(){
         Calculator calc = new Calculator();

         calc.pressDigitKey(9);
         calc.pressUnaryOperationKey("%");
         //calc.pressDigitKey();
         calc.pressEqualsKey();

         String expected = "0.09";
         String actual = calc.readScreen();

         assertEquals(expected, actual);
     }

    @Test
    @DisplayName("should display results after '1/x'")
    void negativeTestTwo(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressUnaryOperationKey("1/x");
        //calc.pressDigitKey();
        calc.pressEqualsKey();

        String expected = "0.125";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

