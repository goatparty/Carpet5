import java.util.Scanner;

/**
 * Created by Eemil on 11/4/2015.
 */
public class Main {
    private static Carpet carpet = new Carpet();
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        boolean control = true;
        do {
           control = processMenu(menu());
        } while (control);
    }

    private static int menu() {
        clearScreen();
        int choice = 0;
        boolean isValid = false;
        String boldGrayLine = "\033[1mCARPET COST CALCULATOR - BY EEMIL MILLER\033[0m";
        System.out.println(boldGrayLine);
        System.out.printf("Current Price/SF $%,.2f\n",carpet.getPrice());
        System.out.println("Please Enter Selection:");
        System.out.println("(1) - Enter X Dimension");
        System.out.println("(2) - Enter Y Dimension");
        System.out.println("(3) - Calculate Total Price");
        System.out.println("(4) - Change Price(REQUIRES PASSWORD)");
        System.out.println("(5) - Reset Carpet Object");
        System.out.println("(0) - Exit Program");

        do {
            System.out.print("Enter Choice: ");
            choice = keyboard.nextInt();
            if (choice >= 0 || choice <= 5) {
                isValid = true;
            }
            else {
                System.out.println("Invalid Input: Please Try Again\nExpected Input: 0-5\nActual Input: " + choice);
                isValid = false;
            }
        } while(!isValid);

        return choice;
    }

    private static boolean processMenu(int status) {
        if (status == 0) {
            return false;
        }
        else if (status == 1 || status == 2) {
            if (status == 1) {
                getDimensions(dimensions.X_DIMENSION);
            }
            else  {
                getDimensions(dimensions.Y_DIMENSION);
            }
        }
        else if (status == 3) {
            getTotalPrice();
        }
        else if (status == 4) {
            setPrice();
        }
        else if (status == 5) {
            resetCarpet();
        }
        return true;
    }

    private static void resetCarpet() {
        if (checkReset()) {
            carpet.reset();
        }
    }

    private static boolean checkReset() {

        System.out.print("Enter 0 to reset or anything else to continue");
        if (keyboard.nextLine().charAt(0) != '0')
            return true;
        else return false;
    }

    private static void setPrice() {
        cleanupSetPassword(carpet.setPrice());
    }

    private static void cleanupSetPassword(boolean success) {
        if (success) {
            System.out.println("Price Successfully Changed");
        }
        else {
            System.out.println("Price Was Not Changed");
        }
    }

    private static void getTotalPrice() {
        System.out.printf("Total Price: $%,.2f\n\nPrice Per Square Foot: $%,.2f\nWidth: %f Feet\nHeight %f Feet",carpet.getTotalPrice(),carpet.getPrice(),carpet.getXDim(),carpet.getYDim());
    }

    private static void getDimensions(dimensions d) {
        boolean isValid = false;
        double xDimension = 0,yDimension = 0,input = 0;;

        if (d == dimensions.X_DIMENSION) {
            do {
                System.out.print("Please Enter X Dimension: ");
                input = keyboard.nextDouble();
                if (input > 0) {
                    isValid = true;
                    xDimension = input;
                }
                else {
                    isValid = false;
                    System.out.println("Invalid Input: Please Try Again\nExpected Input: >0\nActual Input: " + input );
                }
            } while(!isValid);
        } else if (d == dimensions.Y_DIMENSION) {
            do {
                System.out.print("Please Enter Y Dimension: ");
                input = keyboard.nextDouble();
                if (input > 0) {
                    isValid = true;
                    yDimension = input;
                }
                else {
                    isValid = false;
                    System.out.println("Invalid Input: Please Try Again\nExpected Input: >0\nActual Input: " + input );
                }
            } while(!isValid);
        }
        else {
            System.out.println("enum Error: Something went wrong");
            System.exit(388);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public enum dimensions {X_DIMENSION, Y_DIMENSION}
}

