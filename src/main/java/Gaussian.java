import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gaussian {
    public static void run() {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        List<List<Double>> a = new ArrayList<>();
        List<Double> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());

            for (int j = 0; j < m; j++) {
                a.get(i).add(s.nextDouble());
            }

            b.add(s.nextDouble());
        }

        for (int p = 0; p < n; p++) {
            int max = p;

            for (int i = p + 1; i < n; i++) {
                if (Math.abs(a.get(i).get(p)) > Math.abs(a.get(max).get(p))) {
                    max = i;
                }
            }

            List<Double> temp = a.get(p);
            a.set(p, a.get(max));
            a.set(max, temp);
            double t = b.get(p);
            b.set(p, b.get(max));
            b.set(max, t);

            if (Math.abs(a.get(p).get(p)) <= 1e-10) {
                System.out.println("NO");
                return;
            }

            for (int i = p + 1; i < n; i++) {
                double alpha = a.get(i).get(p) / a.get(p).get(p);
                b.set(i, b.get(i) - alpha * b.get(p));

                for (int j = p; j < n; j++) {
                    a.get(i).set(j, a.get(i).get(j) - alpha * a.get(p).get(j));
                }

            }
        }

        List<Double> x = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            x.add(0.0);
        }

        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;

            for (int j = i + 1; j < n; j++) {
                sum += a.get(i).get(j) * x.get(j);
            }

            x.set(i, (b.get(i) - sum) / a.get(i).get(i));
        }

        if (n < m) {
            System.out.print("INF");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(x.get(i) + " ");
            }
        }
    }
}