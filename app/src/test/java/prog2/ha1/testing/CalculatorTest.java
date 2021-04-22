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

        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should display result after dividing two numbers")
    void testDividing() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);


    }
    @Test
    @DisplayName("should Display result unary Operation")
    void testUnary(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("sqrt");
        String expected ="3.0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Should clear Display when pressed CE-Key")
    void pressDotKey(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        String expected ="25.5";
        String actual = calc.readScreen();
        assertEquals(expected, actual);


    }

   // @Test
  //  @DisplayName("should display result after subtracting two numbers")
   // void testsubtraction(){
   //   Calculator calc = new Calculator();
  //   calc.pressDigitKey(8);
  //  calc.pressDigitKey(1);
  //  calc.pressDigitKey(0);
  //  calc.pressBinaryOperationKey("-");
  //  calc.pressDigitKey(4);
  //  calc.pressDigitKey(0);
  //  calc.pressDigitKey(0);
  //  calc.pressEqualsKey();

  //    String expected = "410";
  //    String actual = calc.readScreen();

  //  assertEquals(expected, actual);

  //  }
}






