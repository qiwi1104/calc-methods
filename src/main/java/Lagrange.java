import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lagrange {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n = ");
        int n = Integer.parseInt(scanner.nextLine());

        List<Double> arrayOfX = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] = ");
            arrayOfX.add(scanner.nextDouble());
        }

        List<Double> arrayOfY = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            System.out.print("f[" + i + "] = ");
            arrayOfY.add(scanner.nextDouble());
        }

        List<Double> interpolationPoints = new ArrayList<>();
        interpolationPoints.add(0.5);
        interpolationPoints.add(1.5);
        interpolationPoints.add(2.5);

        for (Double interpolationPoint : interpolationPoints) {
            System.out.print(interpolationPoint + " " + li(interpolationPoint, arrayOfX, arrayOfY) + "\n");
        }
    }

    private static double fi(double x, List<Double> arrOfX, double f, double xi) {
        List<Double> l = new ArrayList<>(arrOfX);

        l.remove(xi);

        double numerator = x - l.get(0);

        for (int i = 1; i < l.size(); i++) {
            numerator *= (x - l.get(i));
        }

        double denominator = xi - l.get(0);

        for (int i = 1; i < l.size(); i++) {
            denominator *= (xi - l.get(i));
        }

        return f * numerator / denominator;
    }

    private static double li(double x, List<Double> arrOfX, List<Double> arrOfF) {
        double sum = 0;

        for (int i = 0; i < arrOfX.size(); i++) {
            sum += fi(x, arrOfX, arrOfF.get(i), arrOfX.get(i));
        }

        return sum;
    }
}
