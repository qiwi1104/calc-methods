public class Integral {
    public static void run() {
        rectangles(Math.PI / 4, Math.PI / 2, 10);
        System.out.println(simpsonIntegral(Math.PI / 4, Math.PI / 2, 10));
        System.out.println(trapezoidalIntegral(Math.PI / 4, Math.PI / 2, 10));
    }

    private static double trapezoidalIntegral(double a, double b, int n) {
        double width = (b - a) / n;

        double trapezoidal = 0;
        for (int step = 0; step < n; step++) {
            double x1 = a + step * width;
            double x2 = a + (step + 1) * width;

            trapezoidal += 0.5 * (x2 - x1) * (fx(x1) + fx(x2));
        }

        return trapezoidal;
    }

    private static double simpsonIntegral(double a, double b, int n) {
        double width = (b - a) / n;

        double simpsonIntegral = fx(a) + fx(b);
        double xi = a;

        for (int step = 1; step < n; step++) {
            xi += width;

            if (step % 2 == 0) {
                simpsonIntegral += (fx(xi) * 2);
            } else {
                simpsonIntegral += (fx(xi) * 4);
            }
        }

        return simpsonIntegral * width / 3;
    }

    private static void rectangles(double a, double b, int n) {
        double h = (b - a) / n;

        double rightRectangle = 0;
        double leftRectangle = h * fx(a);
        double centerRectangle = h * fx(a + h / 2);

        for (int i = 1; i <= n - 1; i++) {
            double xi = a + i * h;

            rightRectangle += h * fx(xi);
            leftRectangle += h * fx(xi);
            centerRectangle += h * fx(xi + h / 2);
        }

        rightRectangle += h * fx(a + h * n);

        System.out.println("r: " + rightRectangle);
        System.out.println("l: " + leftRectangle);
        System.out.println("c: " + centerRectangle);
    }

    private static double fx(double x) {
        return 1 / Math.pow(Math.sin(x), 2);
    }
}
