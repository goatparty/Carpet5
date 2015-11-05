import java.util.*;
import java.io.Console;
import java.io.*;

public class Carpet {

    Console con = null;
    Scanner keyboard = new Scanner(System.in);
    private double price = 8.00;
    private double xDim, yDim;
    private final char[] PASSWORD= {'H','u','n','t','e','r','1','2','3'};

    public Carpet() {
        xDim = yDim = 0;
    }

    public Carpet(double xDim) {
        this.xDim = xDim;
        this.yDim = yDim;
    }

    public double getPrice() {
        return price;
    }

    public double getXDim() {
        return xDim;
    }

    public double getYDim() {
        return yDim;
    }

    public void setXDim(double xDim) {
        this.xDim = xDim;
    }

    public void setYDim(double yDim) {
        this.yDim = yDim;
    }

    public double getSquareFootage() {
        return yDim * xDim;
    }

    public double getTotalPrice() {
        return getSquareFootage() * price;
    }

    public boolean setPrice() {
        con = System.console();
        System.out.print("Please Enter Password: ");
        char[] password = null;
        try {
            try {
                password = con.readPassword();
                boolean bin = false;
                for (int x =0; x < 9; x++) {
                    if (password[x] == PASSWORD[x]) {
                        bin = true;
                    }
                }
                if (bin) {
                    do {
                        System.out.print("Password Correct, enter price: ");
                        price = keyboard.nextDouble();
                        if (price <= 0) {
                            System.out.println("Invalid Input: Please Try Again\nExpected Input: >0\nActual Input: " + price);
                        }
                    } while (price <= 0);
                    return true;
                }
                else {
                    //System.out.println("Incorrect Password - Going Back To Menu");
                    return false;
                }
            }
            catch (NullPointerException n) {
                if (password == null) {
                    System.out.println("You are most likely using an IDE, please try again in a console");
                }
                return  false;
            }
        }
        catch (ArrayIndexOutOfBoundsException f) {
            System.out.println("Incorrect Password - Going Back");
            return false;
        }

    }

    public void reset() {
        xDim = yDim = 0;
    }

}

