package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {

    //fail
    @Test
    @DisplayName("should display number negative")
    void calculatorCanDoNegative()
    {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressNegativeKey();
        assertEquals("-3", calc.readScreen());
        System.out.println(calc.readScreen());
    }

}

