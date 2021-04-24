package prog2.ha1.testing;

// behaviour inspired by https://www.online-calculator.com/
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private String latestOperation = "";
    private boolean latestValueSaved = false;

    public String readScreen() { // was steht jetzt auf dem Bildschirm
        return screen;
    }

    public void pressDigitKey(int digit) { // also die Tasten 0-9
        if(digit > 9 || digit < 0) throw new IllegalArgumentException();

        if(screen.equals("0")) screen = ""; // nicht Verständlich
        // Fall 1: latestOperation.isEmpty() == true || latestValueSaved == true -> screen = screen + digit
        // true || false -> true ; false || true -> true ; true || true -> true ; false || false -> false
        // Fall 2: latestOperation.isEmpty() == false -> ...
        // Fall 3: latestValueSaved == true -> screen = screen + digit
        // Fall 4: latestValueSaved == false -> Fall 1 o. Fall 2
        if(latestOperation.isEmpty() || latestValueSaved) { // isEmpty() prüft ob den Wert leer ist, dann ergebt true
            screen = screen + digit;
        } else {
            latestValue = Double.parseDouble(screen); // parseDouble wird den Wert von screen von String in Double umwandeln
            screen = Integer.toString(digit);
            latestValueSaved = true;
        }
    }

    public void pressClearKey() { // die Taste CE
        screen = "0";
        latestOperation = "";
        latestValue = 0.0;
        latestValueSaved = false;
    }

    public void pressBinaryOperationKey(String operation)  { // also die Tasten /,x,-,+
        latestOperation = operation;
    }

    public void pressUnaryOperationKey(String operation) { // also die Tasten Wurzel, %, 1/x
        var result = switch(operation) {
            case "%" -> Double.parseDouble(screen) / 100;
            default -> throw new IllegalArgumentException();
        };
        screen = Double.toString(result);
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
    }

    public void pressDotKey() { // die Komma- bzw. Punkt-Taste
        if(!screen.endsWith(".")) screen = screen + ".";
    }

    public void pressNegativeKey() { // die +/- Taste
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    public void pressEqualsKey() { // die Taste =
        var result = switch(latestOperation) {
            case "+" -> latestValue + Double.parseDouble(screen);
            case "-" -> latestValue - Double.parseDouble(screen);
            case "x" -> latestValue * Double.parseDouble(screen);
            case "/" -> latestValue / Double.parseDouble(screen);
            default -> throw new IllegalArgumentException();
        };
        latestValueSaved = false;
        screen = Double.toString(result);
        if(screen.endsWith(".0")) screen = screen.substring(0,screen.length()-2);
        // Ternaerer Operator: boolean (true/false) ? wird zurueckgegeben wenn true : wird zurueckgegeben wenn false;
    }
}