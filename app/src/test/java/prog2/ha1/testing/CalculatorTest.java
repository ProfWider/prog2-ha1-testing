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
    @DisplayName("should display one result after subtract two positive numbers.")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected,actual);

    }
    @Test
    @DisplayName("Second Subtraction Test")
    void testNegativeSubtraction(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();

        String expected = "-2";
        String actual = calc.readScreen();

        assertEquals(expected,actual);

    }
    @Test
    @DisplayName("should display 18.")
    void thirdTest(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "18";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("should display reciprocal as point number")
    //https://stackoverflow.com/questions/26458937/getting-the-reciprocal-in-a-number-exception-in-java
    // Rechenoperationen als Grundidee für Reziprokeberechnung genommen
    void testFractionDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("1/x");
        calc.pressEqualsKey();

        String expected = "0.25";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("should display percentage as point number")
    void testPercentageButton() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");
        calc.pressEqualsKey();

        String expected = ("0.05");
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display 4 percentage as point number")
    void testPercentagButtonTwo(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("%");
        calc.pressEqualsKey();

        String expected = "0.04";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("second multiplication test")
    void testFive(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "12";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }
}

