import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        String nombre = "Tony Stark";
        String tipoDeCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;

        Scanner teclado = new Scanner(System.in);

        imprimirDatos(nombre, tipoDeCuenta, saldo);

        while (opcion != 9) {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    consultarSaldo(saldo);
                    break;
                case 2:
                    System.out.println("¿Cuanto desea retirar?");
                    double valorRetirado = teclado.nextDouble();
                    if (valorRetirado > saldo) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        saldo = retirarSaldo(saldo, valorRetirado);
                        consultarSaldo(saldo);
                    }
                    break;
                case 3:
                    System.out.println("¿Cuanto desea depositar?");
                    double valorDeposito = teclado.nextDouble();
                    saldo = depositarSaldo(saldo, valorDeposito);
                    consultarSaldo(saldo);
                    break;
                case 4:
                    imprimirDatos(nombre, tipoDeCuenta, saldo);
                    break;
                case 9:
                    System.out.println("Saliendo del programa, Gracias por usar nuestros Servicios!");
                    break;
                default:
                    System.out.println("Opcion no válida!");
                    break;
            }

        }


    }

    public static void imprimirDatos(String nombre, String tipoDeCuenta, double saldoDisponible) {

        System.out.println("""
                *************************************
                -------  DATOS DEL CLIENTE   --------
                Nombre del Cliente: %s
                Tipo de Cuenta: %s
                Saldo Disponible: $%.2f
                
                *************************************
                """.formatted(nombre, tipoDeCuenta, saldoDisponible));
    }

    public static void mostrarMenu() {
        System.out.println("""
                ** Escriba el número de la opción deseada **
                1 - Consultar Saldo
                2 - Retirar
                3 - Depositar
                4 - Mostrar datos del cliente
                9 - Salir
                """);
    }

    public static void consultarSaldo(double saldoActual) {
        System.out.println("El saldo actual es : $" + saldoActual);
    }

    private static double depositarSaldo(double saldoDisponible, double saldoDepositado) {
        return saldoDisponible + saldoDepositado;
    }

    private static double retirarSaldo(double saldoDisponible, double saldoRetirado) {
        return saldoDisponible - saldoRetirado;
    }

}
