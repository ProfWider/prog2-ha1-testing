package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private String latestOperation = "";

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

    public  boolean n;


    public void pressDigitKey(int digit) { // also die Tasten 0-9
        if(digit > 9 || digit < 0) throw new IllegalArgumentException();

        if(screen.equals("0")) screen = "";

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

    public void pressBinaryOperationKey(String operation) { // also die Tasten /,x,-,+

        latestOperation = operation;
        if (n) {
            latestOperation = "-";
            n=true;

        }
    }

    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x

        latestOperation = operation;
        pressEqualsKey();
    }

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste

        if(!screen.endsWith(".")) screen = screen + ".";

    }

    public void pressNegativeKey(int digit) { // die +/- Taste

        if(digit > 9 || digit < 0) throw new IllegalArgumentException();
        if(screen.equals("0")) screen = "";

        if(screen.equals("0")) screen = "";


        if(!n) {
            screen = "-" + digit;
            n = true;
        } else {
            latestValue = Double.parseDouble(screen);
            screen = latestOperation + digit;
            screen = Integer.toString(digit);
            n = false;
        }


    }

    public void pressEqualsKey() { // die Taste =
        var result = switch(latestOperation) {
            case "+" -> latestValue + Double.parseDouble(screen);
            case "-" -> latestValue - Double.parseDouble(screen);
            case "x" -> latestValue * Double.parseDouble(screen);
            case "/" -> latestValue / Double.parseDouble(screen);
            case "Wurzel" -> Math.sqrt(Double.parseDouble(screen));
            case "" -> Double.parseDouble(screen);
            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
    }
}