import java.util.Scanner;

public class Laba4 {

    private static Scanner scanner = new Scanner(System.in);
    private static double k5, k4, k3, k2, k1, accuracy;
    static int iteration = 1;
    static double[] zValues = new double[3];
    static boolean condition = true;

    public static void main(String[] args) {

        System.out.println("\n\t4(3x - 1)^2 + (3y - 5)^2\n");
        System.out.println("Choose method of optimization for finding min of function: " +
                "\n\t1 - Simplex Method" +
                "\n\t2 - ))))" +
                "\n\t3 - ((((");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1:
                getSimplex();
                break;
            case 2:
                System.out.println("work in progress");
                break;
            case 3:
                System.out.println("work in progress");
                break;
        }
    }

    static private void getBBFUEDKJL() {}

    static private void getSimplex() {
        double[] pmax = {0, 0},
                 p1 = {0, 0},
                 p2 = {0.259d, 0.965d},
                 p3 = {0.965d, 0.259d},
                 p4s = {0, 0},
                 p5n = {p4s[0] - pmax[0], p4s[1] - pmax[1]};

        double[] zArr = new double[3];


        do {
            System.out.println("\n\tIteration - " + iteration + "\n");

            double[][] points = new double[][] {p1, p2, p3};


            // Calculate y values
            for (int i = 0; i < 3; i++) {
                // User function
                zValues[i] = 4 * Math.pow((3 * points[i][0] - 1), 2) + Math.pow((3 * points[i][1] - 5), 2);
                System.out.println("z = " + zValues[i] + "\t   x = " + points[i][0] + "\t  y = " + points[i][1]);
            }

            // Finding max y value and corresponding point
            double max = zValues[0];
            pmax = points[0];
            for (int i = 1; i < zValues.length; i++) {
                if(zValues[i] > max) {
                    max = zValues[i];
                    pmax = points[i];
                }
            }

            // and creating next new p1 (p5n)
            if (pmax == points[0]) {
                p4s = new double[] { (points[1][0] + points[2][0]) / 2, (points[1][1] + points[2][1])/2 };
                p5n = new double[] {p4s[0] * 2 - pmax[0], p4s[1] * 2 - pmax[1]};
                p1 = p5n;
                //p2 = p3;
                //p3 = p2;
            }
            if (pmax == points[1]) {
                p4s = new double[] { (points[0][0] + points[2][0]) / 2, (points[0][1] + points[2][1])/2 };
                p5n = new double[] {p4s[0] * 2 - pmax[0], p4s[1] * 2 - pmax[1]};
                p2 = p5n;

            }
            if (pmax == points[2]) {
                p4s = new double[] { (points[0][0] + points[1][0]) / 2, (points[0][1] + points[1][1])/2 };
                p5n = new double[] {p4s[0] * 2 - pmax[0], p4s[1] * 2 - pmax[1]};
                p3 = p5n;
            }

            //if (po)

            System.out.println("\n -----> z = " + max + "\tp1 = [" + p5n[0] + ", " + p5n[1] + "]");

            System.out.println("\np1 = [" + p1[0] + ", " + p1[1] + "] " +
                    "p2 = [" + p2[0] + ", " + p2[1] + "] " +
                    "p3 = [" + p3[0] + ", " + p3[1] + "] ");

            System.out.println("\n\t= = = = = = = = = = = = = = = = = = =\n");


             if (iteration == 1) {
                 zArr[0] = max;
             }
             if (iteration == 2) {
                 zArr[1] = max;
             }
             if (iteration == 3) {
                 zArr[2] = max;
             } else if(iteration > 3){
                 zArr[0] = zArr[1];
                 zArr[1] = zArr[2];
                 zArr[2] = max;
             }

             if (iteration >= 3) {
                 if (zArr[2] == zArr[0]) {
                     p1[0] = p1[0] / 2;
                     p1[1] = p1[1] / 2;

                     p2[0] = p2[0] / 2;
                     p2[1] = p2[1] / 2;

                     p3[0] = p3[0] / 2;
                     p3[1] = p3[1] / 2;
                 }

                 if (zArr[2] - zArr[0] != 0 && Math.abs(zArr[2] - zArr[0]) <= 0.001) {
                     System.out.println();
                     condition = false;
                 }
             }
            iteration++;
        } while (condition);
    }
}
