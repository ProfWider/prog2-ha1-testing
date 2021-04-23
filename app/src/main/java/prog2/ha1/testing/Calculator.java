package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private double value;

    private String latestOperation = "";

    private int count = 0;

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

    public void pressDigitKey(int digit) { // also die Tasten 0-9

        if (digit > 9 || digit < 0) throw new IllegalArgumentException();

        if (screen.equals("0")) screen = "";

        if (latestOperation.isEmpty()) {
            screen = screen + digit;
            latestValue = Double.parseDouble(screen);
        } else if (count == 0) {
            screen = Integer.toString(digit);
            count++;
        } else {
            screen = screen + digit;
        }
        value = Double.parseDouble(screen);
    }

    public void pressClearKey() { // die Taste CE
        screen = "0";
        latestOperation = "";
        latestValue = 0.0;
    }

    public void pressBinaryOperationKey(String operation) { // also die Tasten /,x,-,+
        latestOperation = operation;
    }

    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel(√), %, 1/x
        var result = switch (operation) {
            case "√" -> Math.sqrt(Double.parseDouble(screen));
            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);
        if (screen.endsWith(".0")) screen = screen.substring(0, screen.length() - 2);
    }

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if (!screen.endsWith(".")) screen = screen + ".";
    }

    public void pressNegativeKey() { // die +/- Taste
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    public void pressEqualsKey() { // die Taste =
        var result = switch (latestOperation) {
            case "+" -> latestValue + value;
            case "-" -> latestValue - value;
            case "x" -> latestValue * value;
            case "/" -> latestValue / value;
            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);
        if (screen.endsWith(".0")) screen = screen.substring(0, screen.length() - 2);
    }
}