public class trash {

    double x = 0;
    double leftEdgeOfRange = -10;
    double rightEdgeOfRange = 10;
    double e = 0.1;

    public double[] getNewRange(double leftEdge, double rightEdge) {
        double middle = (leftEdge + rightEdge)/2;
        double[] newRange = {leftEdge, (leftEdge + middle)/2, middle, (middle + rightEdge)/2, rightEdge};
        return newRange;
    }

    public double yValueMin(double[] yValues) {
        double min = yValues[0];
        for (int i = 0; i < yValues.length; i++) {
            if(yValues[i] < min) {
                min = yValues[i];
            }
        }
        return min;
    }

    public void calcFivePoints(double leftEdgeOfRange, double rightEdgeOfRange) {

        int index = 0;
        int i = 0;
        double yValue = 0;
        double[] yValues = new double[5];

        do {
            for (double xValue : getNewRange(leftEdgeOfRange, rightEdgeOfRange)) {
                // user function
                yValue = Math.pow(xValue, 2) - xValue;
                yValues[i] = yValue;
                i++;
                System.out.println(" " + index + ": X = " + xValue + "\t Y = " + yValue);
            }

            System.out.println("                    =============");

            yValueMin(yValues);

            leftEdgeOfRange =

                    index++;
        } while (e < (Math.abs(leftEdgeOfRange) + Math.abs(leftEdgeOfRange)) / 4);

    }


}
