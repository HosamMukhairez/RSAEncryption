
import java.io.*;
import java.math.*;

public class ConversionProgram {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        double x = 0;
        double ft = 0;
        double in = 0, cm = 0;
        double conv;
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(" JAVA CONVERSION PROGRAM\n");
            System.out.print("0 - Quit\n");
            System.out.print("1 - Convert feet and inches to centimeters\n");
            System.out.print("2 - Convert centimeters to feet and inches\n");
            System.out.print("\nEnter choice: ");
            try {
                x = Integer.parseInt(cin.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }

            while (x == 1 || x == 2 || x == 0) {
                if (x == 1) {
                    System.out.print("\nEnter feet and inches:");
                    try {
                        ft = Double.parseDouble(cin.readLine());
                        in = Double.parseDouble(cin.readLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (ft > 0 && in > 0) {
                        conv = ((ft * 12) + in) * 2.54;
                        cm = conv;
                        System.out.print(ft + " feet " + in + " inches equals " + cm + " centimeters.\n\n");
                    } else {
                        System.out.println("ERROR: Negative numbers not allowed!\n");
                        break;
                    }
                }

                if (x == 2) {
                    System.out.print("\nEnter centimeters:");
                    try {
                        cm = Double.parseDouble(cin.readLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (cm > 0) {
                        ft = ((cm * .3937008) / 12) / 1;
                        in = (ft % 1) * 12;
                        BigDecimal bd = new BigDecimal(ft);
                        bd = bd.setScale(0, BigDecimal.ROUND_DOWN);
                        ft = bd.doubleValue();

                        System.out.print(cm + " centimeters equals " + ft + "  feet and " + in + " inches.\n\n");
                    } else {
                        System.out.println("ERROR: Negative numbers not allowed!\n");
                        break;
                    }
                }

                if (x == 0) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
            }
            System.out.println("\nERROR: Invalid menu choice!\n");            
        } while (x != 0);
    }
}
