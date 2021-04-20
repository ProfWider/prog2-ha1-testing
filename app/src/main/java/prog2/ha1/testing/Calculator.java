package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

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
    latestOperation =operation;
    /*
        if(!latestOperation.isEmpty()){
            latestOperation = operation;
            pressEqualsKey();
        }else{
            latestOperation = operation;
        } */

    }


    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x
        var result = switch(operation) {

            case "1/x" -> divideByX();
            case "%" -> percentage();
            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
    }


    public double divideByX(){
        var x = Double.parseDouble(screen);
        var a = 1/x;
        return a;
    }
    public double percentage(){
        var x = Double.parseDouble(screen);
        var a = x/100;
        return a;
    }

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if(!screen.endsWith(".")) screen = screen + ".";
    }

    public void pressNegativeKey() { // die +/- Taste

        if(screen.startsWith("-")){
            screen = "-".substring(1) + screen;
        }else{
            screen = "-" + screen;
        }
    }

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