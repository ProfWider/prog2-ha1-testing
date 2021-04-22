package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private String latestOperation = "";

    public int multipleOperations = 0;

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

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
        multipleOperations = 0;
    }

    public void pressBinaryOperationKey(String operation)  { // also die Tasten /,x,-,+
        if(multipleOperations > 0){
            calculate();
        }
        latestOperation = operation;
        multipleOperations++;
    }

    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x
        if(multipleOperations > 0){
            calculate();
        }
        latestOperation = operation;
        multipleOperations++;
    }

    public void calculate(){
        var result = switch(latestOperation) {
            case "+" -> latestValue + Double.parseDouble(screen);
            case "-" -> latestValue - Double.parseDouble(screen);
            case "x" -> latestValue * Double.parseDouble(screen);
            case "/" -> latestValue / Double.parseDouble(screen);
            case "√" -> Math.pow(Double.parseDouble(screen), 0.5);
            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);

    }

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if(!screen.endsWith(".")) screen = screen + ".";
    }

    public void pressNegativeKey() { // die +/- Taste
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    public void pressEqualsKey() { // die Taste =
        calculate();
        multipleOperations = 0;
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
    }
}