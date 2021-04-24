package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {

    //fail
    @Test
    @DisplayName("should display result after addition with dot ")
    void calculatorCanDoAdditionWithDot()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        assertEquals("8.7", calc.readScreen());
        System.out.println(calc.readScreen());
    }
}

