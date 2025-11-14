import clases.Conexion;
import clases.TasaDeCambio;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Conexion conexion = new Conexion();
        TasaDeCambio conversion;
        int eleccion;
        double monto;


        while (true) {
            TasaDeCambio.menu();
            eleccion = TasaDeCambio.eleccion();
            if(eleccion == 7){
                break;
            }
            try {
                switch (eleccion) {
                    case (1):
                        conversion = conexion.conectar("COP", "USD");
                        break;
                    case (2):
                        conversion = conexion.conectar("USD", "COP");
                        break;
                    case (3):
                        conversion = conexion.conectar("MXN", "COP");
                        break;
                    case (4):
                        conversion = conexion.conectar("COP", "MXN");
                        break;
                    case (5):
                        conversion = conexion.conectar("COP", "BRL");
                        break;
                    case (6):
                        conversion = conexion.conectar("BRL", "COP");
                        break;
                    default:
                        throw new IllegalArgumentException("Error debe ser un numero del 1 al 7");
                }

                System.out.print("""
                        *******************************
                        Escribe el monto a convertir:
                        *******************************
                        """);
                monto = entrada.nextDouble();

                System.out.println("""
                        **********************************************************************************************************
                        La conversion de  %.2f %s a %s es igual a: %.2f %s
                        **********************************************************************************************************
                        """.formatted(monto, conversion.getMonedaInicial(),conversion.getMonedaFinal(),conversion.convertir(monto), conversion.getMonedaFinal()));
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch(InputMismatchException e){
                System.out.println("Debe ser un monto valido de dinero.");
            }
        }

        System.out.println("Programa finalizado");

    }
}
