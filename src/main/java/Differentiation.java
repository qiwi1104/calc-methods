public class Differentiation {
    public static void run() {
        double h = 0.1;
        double yn = 13d / 2 + 451;

        System.out.println("n\txn\tyn\tk1\tk2\tk3\tk4");

        for (int i = 0; i <= 10; i++) {
            double xi = 1 + i * h;

            double k1 = fxy(xi, yn);

            double k2 = fxy(xi + h / 2, yn + h / 2 * k1);
            double k3 = fxy(xi + h / 2, yn + h / 2 * k2);
            double k4 = fxy(xi + h, yn + h * k3);

            double kn = 1d / 6 * (k1 + 2 * k2 + 2 * k3 + k4);
            yn += (h * kn);

            System.out.println(i + "\t" + xi + "\t" + yn + "\t" +
                    k1 + "\t" + k2 + "\t" +
                    k3 + "\t" + k4 + "\t" + kn);
        }
    }

    private static double fxy(double x, double y) {
        return (13d * x - y) / x;
    }
}