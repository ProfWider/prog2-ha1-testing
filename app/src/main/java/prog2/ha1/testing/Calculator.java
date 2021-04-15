package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private String latestOperation = "";

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }


    /**
     * it specifies the entered numbers (input) in the calculator
     * @param digit  represent the entered number (input)
     */
    public void pressDigitKey(int digit) { // also die Tasten 0-9
        if(digit > 9 || digit < 0) throw new IllegalArgumentException();

        if(screen.equals("0")) screen = ""; //if nothing no number added console stays empty

        if(latestOperation.isEmpty()) {     // if the second number not added console shows just the first number
            screen = screen + digit;

        } else {                            //convert to string
            latestValue = Double.parseDouble(screen);
            screen = Integer.toString(digit);
        }
    }
    //*********************************************************************************

    /**
     * reset the calculator
     */
    public void pressClearKey() { // die Taste CE
        screen = "0";
        latestOperation = "";
        latestValue = 0.0;
    }

    /**
     * defines the the operations
     * @param operation represent the operation symbols
     */
    public void pressBinaryOperationKey(String operation)  { // also die Tasten /,x,-,+
        latestOperation = operation;
    }


// my fix
public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x
    latestOperation = operation;
    latestValue = Double.parseDouble(screen);
    var result = switch(latestOperation) {

        case "%" -> latestValue /100;

        default -> throw new IllegalArgumentException();
    };
    screen = Double.toString(result);
    if(screen.endsWith(".0")) screen = screen.substring(0,screen.length());

    }



    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if(!screen.endsWith(".")) screen = screen + ".";
    }

    public void pressNegativeKey() { // die +/- Taste
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    /**
     * defines the calculation process
     */
    public void pressEqualsKey() { // die Taste =
        var result = switch(latestOperation) {
            case "+" -> latestValue + Double.parseDouble(screen);
            case "-" -> latestValue - Double.parseDouble(screen);
            case "x" -> latestValue * Double.parseDouble(screen);
            case "/" -> latestValue / Double.parseDouble(screen);
            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
    }


}