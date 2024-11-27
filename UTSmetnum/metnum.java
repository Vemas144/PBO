package UTSmetnum;
import java.lang.Math;

public class metnum {
    ;
    // Fungsi pertama: f(x) = 7x^2 - 21x + Math.exp(x)
    public static double f1(double x) {
        return 7 * Math.pow(x, 2) - 21 * x + Math.exp(x);
    }

    // Turunan dari f(x) untuk metode Newton-Raphson pada f1
    public static double f1Prime(double x) {
        return 14 * x - 21 + Math.exp(x);
    }

    // Fungsi g(x) untuk Iterasi Titik Tetap pada f1
    public static double g1(double x) {
        return Math.sqrt((21 * x - Math.exp(x)) / 7);
    }

    // Fungsi kedua: f(x) = 3x^3 - 2x - Math.exp(x)
    public static double f2(double x) {
        return 3 * Math.pow(x, 3) - 2 * x - Math.exp(x);
    }

    // Turunan dari f(x) untuk metode Newton-Raphson pada f2
    public static double f2Prime(double x) {
        return 9 * Math.pow(x, 2) - 2 - Math.exp(x);
    }

    // Fungsi g(x) untuk Iterasi Titik Tetap pada f2
    public static double g2(double x) {
        return Math.cbrt((2 * x + Math.exp(x)) / 3);
    }

    // Metode Iterasi Titik Tetap
    public static void fixedPointIteration(double x0, int maxIter, double tol, int equation) {
        double x = x0;
        for (int i = 0; i < maxIter; i++) {
            double xNew = (equation == 1) ? g1(x) : g2(x);
            if (Math.abs(xNew - x) < tol) {
                System.out.println("Iterasi Titik Tetap Akar ditemukan: " + xNew);
                return;
            }
            x = xNew;
        }
        System.out.println("Iterasi Titik Tetap Gagal mencapai toleransi.");
    }

    // Metode Newton-Raphson
    public static void newtonRaphson(double x0, int maxIter, double tol, int equation) {
        double x = x0;
        for (int i = 0; i < maxIter; i++) {
            double fx = (equation == 1) ? f1(x) : f2(x);
            double fxPrime = (equation == 1) ? f1Prime(x) : f2Prime(x);
            if (Math.abs(fxPrime) < tol) {
                System.out.println("Metode Newton-Raphson Gagal: turunan mendekati nol.");
                return;
            }
            double xNew = x - fx / fxPrime;
            if (Math.abs(xNew - x) < tol) {
                System.out.println("Newton-Raphson Akar ditemukan: " + xNew);
                return;
            }
            x = xNew;
        }
        System.out.println("Newton-Raphson Gagal mencapai toleransi.");
    }

    // Metode Secant
    public static void secant(double x0, double x1, int maxIter, double tol, int equation) {
        double xPrev = x0;
        double x = x1;
        for (int i = 0; i < maxIter; i++) {
            double fx = (equation == 1) ? f1(x) : f2(x);
            double fxPrev = (equation == 1) ? f1(xPrev) : f2(xPrev);
            if (Math.abs(fx - fxPrev) < tol) {
                System.out.println("Metode Secant Gagal: perbedaan f(x) mendekati nol.");
                return;
            }
            double xNew = x - fx * (x - xPrev) / (fx - fxPrev);
            if (Math.abs(xNew - x) < tol) {
                System.out.println("Secant Akar ditemukan: " + xNew);
                return;
            }
            xPrev = x;
            x = xNew;
        }
        System.out.println("Secant Gagal mencapai toleransi.");
    }

    public static void main(String[] args) {
        double x0_1 = 0.3, x1_1 = 0.5;
        double x0_2 = 0.1, x1_2 = 0.7;
        int maxIter = 100;
        double tol = 1e-6;

        System.out.println("=== Persamaan 1: f(x) = 7x^2 - 21x + e^x ===");
        fixedPointIteration(x0_1, maxIter, tol, 1);
        newtonRaphson(x0_1, maxIter, tol, 1);
        secant(x0_1, x1_1, maxIter, tol, 1);

        System.out.println("\n=== Persamaan 2: f(x) = 3x^3 - 2x - e^x ===");
        fixedPointIteration(x0_2, maxIter, tol, 2);
        newtonRaphson(x0_2, maxIter, tol, 2);
        secant(x0_2, x1_2, maxIter, tol, 2);
    }
}

   
