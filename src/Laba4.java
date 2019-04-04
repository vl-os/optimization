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
                "\n\t2 - Scanning Method" +
                "\n\t3 - Gauss");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1:
                getSimplex();
                break;
            case 2:
                getScan();
                break;
            case 3:
                getG();
                break;
        }
    }

    static class Point {
        public double x;
        public double y;
    }

    static private void getScan() {
        double radius = 5.0d;
        double step, min;
        int z;

        double[] xValue = new double[11];
        double[] yValue = new double[11];
        double[] zValue = new double[yValue.length * xValue.length];

        zValue[0] = 4 * Math.pow((3 * xValue[0] - 1), 2) + Math.pow((3 * yValue[0] - 5), 2);
        min = zValue[0];


        // init center point
        Point center = new Point();
        center.x = 0;
        center.y = 0;

        do {
            z = 0;

            xValue[0] = center.x - radius;
            yValue[0] = center.y + radius;
            step = (radius * 2) / 10;

            for (int i = 1; i < 11; i++) {
                xValue[i] = center.x - radius + step * i;
                yValue[i] = center.y + radius - step * i;
            }

            for (int i = 0; i < 11; i++) {
                System.out.println(xValue[i] + "\t" + yValue[i]);
            }
            System.out.println();

            for (int i = 0; i < yValue.length; i++) {
                for (int j = 0; j < xValue.length; j++) {

                    zValue[z] = 4 * Math.pow((3 * xValue[j] - 1), 2) + Math.pow((3 * yValue[i] - 5), 2);

                    if (zValue[z] < min) {
                        min = zValue[z];
                        center.x = xValue[j];
                        center.y = yValue[i];
                        radius = step;
                    }
                    z++;
                }
            }

            for (int i = 0; i < zValue.length; i++) {
                System.out.print(zValue[i] + "\t | \t");
                if (i > 0 && (i % 5d) == 0) {
                    System.out.println();
                }
            }

            System.out.println("\n\n" + iteration +":\tmin = " + min
                                + "\tx = " + center.x + "\ty = " + center.y + "\tradius = " + radius + "\n");

            iteration++;
        } while (radius >= 0.01);

    }

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

    static private void getG() {

        iteration = 0;
        double zValue, min, previousValue, step = 0.1;
        double[] zValues = new double[4];

        double X = 0,
               Y = 0;

        zValue = 4 * Math.pow((3 * X - 1), 2) + Math.pow((3 * Y - 5), 2);
        min = zValue;

        do {
            previousValue = min;

            double[] points = {X, Y},
                    toUp = {points[0], points[1] + step},
                    toDown = {points[0], points[1] - step},
                    toLeft = {points[0] - step, points[1]},
                    toRight = {points[0] + step, points[1]};

            zValues[0] = 4 * Math.pow((3 * toUp[0] - 1), 2) + Math.pow((3 * toUp[1] - 5), 2);
            zValues[1] = 4 * Math.pow((3 * toDown[0] - 1), 2) + Math.pow((3 * toDown[1] - 5), 2);
            zValues[2] = 4 * Math.pow((3 * toLeft[0] - 1), 2) + Math.pow((3 * toLeft[1] - 5), 2);
            zValues[3] = 4 * Math.pow((3 * toRight[0] - 1), 2) + Math.pow((3 * toRight[1] - 5), 2);

            for (int i = 0; i < zValues.length; i++) {

                if (zValues[i] < min) {
                    min = zValues[i];

                    if(i == 0) {
                        X = toUp[0];
                        Y = toUp[1];
                    }
                    if(i == 1) {
                        X = toDown[0];
                        Y = toDown[1];
                    }
                    if(i == 2) {
                        X = toLeft[0];
                        Y = toLeft[1];
                    }
                    if(i == 3) {
                        X = toRight[0];
                        Y = toRight[1];
                    }
                }
            }
            System.out.println("min" + iteration + " = " + min);
            iteration++;
        } while ((previousValue - min) > 0.001);

    }
}
