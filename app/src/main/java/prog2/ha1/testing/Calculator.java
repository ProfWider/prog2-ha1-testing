package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private String latestOperation = "";

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

//############################################

    /**
     * it specifies the entered numbers (input) in the calculator
     *
     * @param digit represent the entered number (input)
     */
    public void pressDigitKey(int digit) { // also die Tasten (-9 - 9)
        if (digit > 9 || digit < -9) throw new IllegalArgumentException();

        if (screen.equals("0")) screen = ""; //if nothing no number added console stays empty

        if (latestOperation.isEmpty()) {     // if the second number not added console shows just the first number
            screen = screen + digit;

        } else {                            //convert to string
            latestValue = Double.parseDouble(screen);
            screen = Integer.toString(digit);
        }
    }
//######################################################


    /**
     * reset the calculator
     */
    public void pressClearKey() { // die Taste CE
        screen = "0";
        latestOperation = "";
        latestValue = 0.0;
    }


//#####################################################

    /**
     * defines the the operations to a variable
     *
     * @param operation represent the operation symbols
     */
    public void pressBinaryOperationKey(String operation) { // also die Tasten /,x,-,+
        latestOperation = operation;
    }
//#####################################################

    /**
     * makes the unary operations possibole after pressing one of them
     *
     * @param operation the value of the variable
     */
    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x
        latestOperation = operation;
        latestValue = Double.parseDouble(screen);
        var result = switch (latestOperation) {

            case "%" -> latestValue / 100;
            case "Wurzel" -> Math.sqrt(latestValue);
            case "1/x" -> 1 / latestValue;

            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);
        if (screen.endsWith(".0")) screen = screen.substring(0, screen.length());


    }
//########################################################

    /**
     *adds a catastrophe to the console when pressed
     */

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if (!screen.endsWith(".")) screen = screen + ".";
    }

//#######################################################

    /**
     *Switchs the number from positive to negative when pressing the following operation
     * @param operation  represent the operation symbols
     */
    public void pressNegativeKey(String operation) { // die +/- Taste
        latestOperation = operation;
        if (screen.startsWith("-")) screen = screen.substring(1, screen.length());
        else screen = "-" + screen ;
        if (screen.endsWith(".0")) screen = screen.substring(0, screen.length() - 2);

    }

//######################################################

        /**
         * defines the calculation process
         */
        public void pressEqualsKey () { // die Taste =
            var result = switch (latestOperation) {
                case "+" -> latestValue + Double.parseDouble(screen);
                case "-" -> latestValue - Double.parseDouble(screen);
                case "x" -> latestValue * Double.parseDouble(screen);
                case "/" -> latestValue / Double.parseDouble(screen);
                default -> throw new IllegalArgumentException();
            };
            screen = Double.toString(result);
            if (screen.endsWith(".0")) screen = screen.substring(0, screen.length() - 2);
        }


    }
//#########################################################
//#######################################################
//#####################################################
//###################################################
//###############################################
//###########################################
//#######################################
//####################################
//################################
//#############################
//##########################