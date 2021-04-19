package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    //bugfix test case three - calculatorCanDoDecimal
    private String screen = "";

    private double latestValue;

    private String latestOperation = "";

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

    //bugfix test case two - calculatorOperationsOnDigitsGreaterNine
    public void pressDigitKey(int digit) {
        if(digit > 99 || digit < 0) throw new IllegalArgumentException();

        if(latestOperation.isEmpty()) {
            screen = screen + digit;
        } else {
            latestValue = Double.parseDouble(screen);
            screen = Integer.toString(digit);
        }
    }

    public void pressClearKey() { // die Taste CE
        screen = "0";
        latestOperation = "";
        latestValue = 0.0;
    }

    public void pressBinaryOperationKey(String operation)  { // also die Tasten /,x,-,+
        latestOperation = operation;
    }

    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x

    }

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if(!screen.endsWith(".")) screen = screen + ".";
    }

    public void pressNegativeKey() { // die +/- Taste
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    public void pressEqualsKey() {
        double result;
        switch (latestOperation) {
            case "+":
                result = latestValue + Double.parseDouble(screen);
                break;
            case "-":
                result = latestValue - Double.parseDouble(screen);
                break;
            case "x":
                result = latestValue * Double.parseDouble(screen);
                break;
            case "/":
                result = latestValue / Double.parseDouble(screen);
                break;
            default:
                throw new IllegalArgumentException();
        }
        screen = Double.toString(result);
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
    }
}