package prog2.ha1.testing;


import java.util.Objects;

import static java.lang.Double.NaN;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double firstValue;
    private double secondValue;

    private String latestOperation = "";

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

    public void pressDigitKey(int digit) { // also die Tasten 0-9
        if(digit > 9 || digit < 0) throw new IllegalArgumentException();

        if(screen.equals("0")) screen = "";

        if(latestOperation.isEmpty()) {
            screen = screen + digit;
        } else {
            firstValue = Double.parseDouble(screen);
            screen = Integer.toString(digit);
        }
    }

    public void pressClearKey() { // die Taste CE
        screen = "0";
        latestOperation = "";
        firstValue = 0.0;
    }

    private boolean error(Double val) {
        return Double.isNaN(val) || Double.isInfinite(val);
    }

    public void pressBinaryOperationKey(String operation)  { // also die Tasten /,x,-,+
        latestOperation = operation;
    }

    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x
        double number = Double.parseDouble(screen);
        Double result = switch(operation) {
            case "1/x" -> dividieren(1, number);
            case "%" -> number / 100;
            case "√" -> Math.sqrt(number);
            default -> throw new IllegalArgumentException();
        };
        updateScreen(result);
    }

    private void updateScreen(Double result) {
        if (error(result)) screen = "Error";
        else screen = Double.toString(result);
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
    }

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if(!screen.endsWith(".")) screen = screen + ".";
    }

    public void pressNegativeKey() { // die +/- Taste
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    public void pressEqualsKey() { // die Taste =
        secondValue = Double.parseDouble(screen);
        Double result = switch(latestOperation) {
            case "+" -> firstValue + Double.parseDouble(screen);
            case "-" -> firstValue - Double.parseDouble(screen);
            case "x" -> firstValue * Double.parseDouble(screen);
            case "/" -> dividieren(firstValue);
            default -> throw new IllegalArgumentException();
        };
        updateScreen(result);
    }

    private Double dividieren(double dividend) {
        double divisor = Double.parseDouble(screen);
        return dividend / divisor;
    }

    private Double dividieren(double dividend, double divisor) {
        return dividend / divisor;
    }

}