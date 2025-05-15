import java.util.Scanner;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Biseccion {
    public static void main(String[] args) {
        System.out.println("\nEVIDENCIA 3 - METODOS NUMERICOS \nMétodo de Bisección en Java");
        resolverBiseccion();
    }

    // Método que resuelve la bisección
    public static void resolverBiseccion() {
        Scanner scanner = new Scanner(System.in);

        // Entrada de la función
        System.out.print("Ingresa la función (usa 'x' como variable y en caso de tener problemas al usar ^2 multiplica para usar las potencias, por ejemplo: x^3 - x - 2 → x*x*x - x - 2): "); // En ejecución no me permitía permite el simbolo para las potencias 
        String funcion = scanner.nextLine();

        // Crear expresión
        Expression expresion = new ExpressionBuilder(funcion)
            .variable("x")
            .build();

        // Entrada de límites y parámetros
        System.out.print("Ingrese el límite inferior a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese la tolerancia (por ejemplo 0.0001): ");
        double tolerancia = scanner.nextDouble();

        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = scanner.nextInt();

        scanner.close();

        double fa = evaluarFuncion(expresion, a);
        double fb = evaluarFuncion(expresion, b);

        // Validar que f(a) y f(b) tengan signos opuestos
        if (fa * fb >= 0) {
            System.out.println("Error: f(a) y f(b) deben tener signos opuestos.");
            return;
        }

        System.out.println("\nIteración\t a\t\t b\t\t m\t\t f(m)");

        int iter = 0;
        double m = a;

        while ((b - a) >= tolerancia && iter < maxIter) {
            m = (a + b) / 2;
            double f_m = evaluarFuncion(expresion, m);

            System.out.printf("%d\t\t %.6f\t %.6f\t %.6f\t %.6f\n", iter + 1, a, b, m, f_m);

            if (fa * f_m < 0) {
                b = m;
                fb = f_m;
            } else {
                a = m;
                fa = f_m;
            }

            iter++;
        }

        System.out.println("\nResultado:");
        System.out.printf("Raíz aproximada: %.6f\n", m);
        System.out.println("Iteraciones realizadas: " + iter);
        System.out.println("Fin del programa :)");
    }

    // Evaluador de función con la librería exp4j
    public static double evaluarFuncion(Expression expr, double x) {
        return expr.setVariable("x", x).evaluate();
    }
}
