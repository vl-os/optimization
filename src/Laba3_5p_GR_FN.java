import java.util.Scanner;

public class Laba3_5p_GR_FN {

    private static Scanner scanner = new Scanner(System.in);
    private static double k5, k4, k3, k2, k1, accuracy;
    private static double[] xValues, yValues = new double[5];
    private static double[] xValuesGR, yValuesGR = new double[4];
    private static double leftCorner, rightCorner;

    public static void main(String[] args) {

        System.out.println("Choose method of optimization for finding min of function: " +
                "\n\t1 - Five Points" +
                "\n\t2 - Golden Ratio" +
                "\n\t3 - Fibonacci");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1:
                getFivePoints();
                break;
            case 2:
                getGoldenRatio();
                break;
            case 3:
                System.out.println("work in progress");
                break;
        }
    }

    private static void getFibonacci() {

        int[] fibonacciNumbers = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584};














    }

    private static void getGoldenRatio() {

        System.out.println("\n\tk1*x^2 + k2*x\nEnter k1: ");
        k1 = scanner.nextDouble();
        System.out.println("Enter k2: ");
        k2 = scanner.nextDouble();
        System.out.println("Enter accuracy: ");
        accuracy = scanner.nextDouble();
        System.out.println("Enter left corner: ");
        leftCorner = scanner.nextDouble();
        System.out.println("Enter right corner: ");
        rightCorner = scanner.nextDouble();
        int iteration = 1;
        double condition;

        do {

            double[] xValuesGR = new double[] {
                    leftCorner,
                    leftCorner + (Math.abs(leftCorner) + Math.abs(rightCorner)) * 0.38,
                    rightCorner - (Math.abs(leftCorner) + Math.abs(rightCorner)) * 0.38,
                    rightCorner
            };

            System.out.println("= = = = = = = = = = = = = \n\nIteration : " + iteration + "\n");

            // calculate X and Y values
            for (int i = 0; i < 4; i++) {
                int j = i + 1;
                // main function
                yValuesGR[i] = k1 * Math.pow(xValuesGR[i], 2) + k2 * xValuesGR[i];
                System.out.println("x" + j + " = " + xValuesGR[i] + " \t" + "\ty" + j + " = " + yValuesGR[i]);
            }

            // find min Y value
            double min = yValuesGR[0];
            for (int i = 1; i < 4; i++) {
                if(yValuesGR[i] < min) {
                    min = yValuesGR[i];
                }
            }

            // get new left, mid and right x values;
            for (int i = 1; i < 3; i++) {
                if (min == yValuesGR[i]) {
                    leftCorner = xValuesGR[i - 1];
                    rightCorner = xValuesGR[i + 1];
                }
                if (min == yValuesGR[0]) {
                    leftCorner = xValuesGR[0];
                    rightCorner = xValuesGR[1];
                }
                if (min == yValuesGR[3]) {
                    leftCorner = xValuesGR[2];
                    rightCorner = xValuesGR[3];
                }
            }



            condition = (rightCorner - leftCorner)/4;
            iteration++;

        } while (condition >= accuracy);

    }

    private static void getFivePoints() {

        System.out.println("\n\tk1*x^2 + k2*x\nEnter k1: ");
        k1 = scanner.nextDouble();
        System.out.println("Enter k2: ");
        k2 = scanner.nextDouble();
        System.out.println("Enter accuracy: ");
        accuracy = scanner.nextDouble();
        System.out.println("Enter left corner: ");
        leftCorner = scanner.nextDouble();
        System.out.println("Enter right corner: ");
        rightCorner = scanner.nextDouble();


        // Init first iteration
        double middleRange = (leftCorner + rightCorner) / 2;
        //xValues = getXValues(leftCorner, middleRange, rightCorner);
        int iteration = 1;
        double condition;

        do {

            xValues = getXValues(leftCorner, middleRange, rightCorner);

            System.out.println("= = = = = = = = = = = = = \n\nIteration : " + iteration + "\n");

            // calculate X and Y values
            for (int i = 0; i < 5; i++) {
                int j = i + 1;
                // main function
                yValues[i] = k1 * Math.pow(xValues[i], 2) + k2 * xValues[i] - 5;
                System.out.println("x" + j + " = " + xValues[i] + " \t" + "\ty" + j + " = " + yValues[i]);
            }

            // find min Y value
            double min = yValues[0];
            for (int i = 1; i < 5; i++) {
                if(yValues[i] < min) {
                    min = yValues[i];
                }
            }

            // get new left, mid and right x values;
            for (int i = 1; i < 4; i++) {
                if (min == yValues[i]) {
                    leftCorner = xValues[i - 1];
                    middleRange = xValues[i];
                    rightCorner = xValues[i + 1];
                }
                if (min == yValues[0]) {
                    leftCorner = xValues[0] - xValues[1];
                    middleRange = xValues[0];
                    rightCorner = xValues[1];
                }
                if (min == yValues[4]) {
                    leftCorner = xValues[3];
                    middleRange = xValues[4];
                    rightCorner = xValues[4] + xValues[3];
                }
            }



            condition = (rightCorner - leftCorner)/4;
            iteration++;
        } while (condition >= accuracy);
    }

    private static double[] getXValues(double left, double middle, double right) {
       double[] xValues = new double[]{ left,
                (left + middle) / 2,
                middle,
                (right + middle) / 2,
                right};
        return xValues;
    }

}
