import java.util.Scanner;

public class Biseccion {
    public static void main(String[] args) {
        System.out.println("Método de Bisección en Java");
    }

    // Definimos la función f(x) = x^3 - x - 2
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    // Método que resuelve la bisección
    public static void resolverBiseccion() {
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese el límite inferior a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese la tolerancia (por ejemplo 0.0001): ");
        double tolerancia = scanner.nextDouble();

        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = scanner.nextInt();

        scanner.close();

        // Validar que f(a) y f(b) tengan signos opuestos
        if (f(a) * f(b) >= 0) {
            System.out.println("Error: f(a) y f(b) deben tener signos opuestos.");
            return;
        }

        System.out.println("\nIteración\t a\t\t b\t\t m\t\t f(m)");

        int iter = 0;
        double m = a;

        while ((b - a) >= tolerancia && iter < maxIter) {
            m = (a + b) / 2;
            double f_m = f(m);

            System.out.printf("%d\t\t %.6f\t %.6f\t %.6f\t %.6f\n", iter + 1, a, b, m, f_m);

            if (f(a) * f_m < 0) {
                b = m;
            } else {
                a = m;
            }

            iter++;
        }

        System.out.println("\nResultado:");
        System.out.printf("Raíz aproximada: %.6f\n", m);
        System.out.println("Iteraciones realizadas: " + iter);
    }
}
