package prog2.ha1.testing;

import java.math.*;
// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private String latestOperation = "";

    private String em = "Error";

    private String latestScreen = "";

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

    //Eigene Operation
    public double readlv(){return latestValue; }
    public String readlO(){return latestOperation; }


    public void errorManager()
    {
        if(screen.equals(em))
        {
            screen = latestScreen;
        }
    }

    public void pressDigitKey(int digit)
    {
        // also die Tasten 0-9

        if(digit > 9 || digit < 0) throw new IllegalArgumentException();
        errorManager();
        if(screen.equals("0")) screen = ""
;
        if(latestOperation.isEmpty())
        {
            screen = screen + digit;
        }
        else
        {
            latestValue = Double.parseDouble(screen);
            screen = Integer.toString(digit);
        }
    }

    public void pressClearKey()
    {
        // die Taste CE
        screen = "0";
        latestOperation = "";
        latestValue = 0.0;
    }

    public void pressBinaryOperationKey(String operation)  { // also die Tasten /,x,-,+
        latestOperation = operation;
    }

    public void pressUnaryOperationKey(String operation)
    { // also die Tasten Wurzel, %, 1/x
        //k1 = Wurzel, k2 = %, k3 = 1/x
        errorManager();
        switch(operation)
        {
            case "k1": //Wurzelberechnung
            {
                if(Double.parseDouble(screen) < 0)
                {
                    latestScreen = screen;
                    screen = em;
                }
                else
                {
                    screen = Double.toString(Math.pow(Double.parseDouble(screen),0.5));
                }

                break;
            }
            case "k2": //Prozentzahlen
            {
                screen = Double.toString(Double.parseDouble(screen)/100);
                break;
            }
            case "k3": //1/x
            {
                if(Double.parseDouble(screen) == 0)
                {
                    latestScreen = screen;
                    screen = em;
                }
                else
                {
                    screen = Double.toString(1 / Double.parseDouble(screen));
                }
                break;
            }
            default:
        }




    }

    public void pressDotKey()
    { // die Komma- bzw. Punkt-Taste
        //if(!screen.endsWith(".")) screen = screen + ".";
        errorManager();
        if(!screen.contains(".")) screen = screen + "."; //es prueft generell ob ein Punkt enthalten ist und wenn dem so ist koennen keine weiteren hinzugefuegt werden, anstatt einfach nur auf das Ende zu pruefen
    } //Wenn Screen bereits einen Punkt am Ende hat, dann darf kein weiterer Punkt gesetzt werden



    public void pressNegativeKey() { // die +/- Taste
        errorManager();
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    public void pressEqualsKey() { // die Taste =
        errorManager();
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