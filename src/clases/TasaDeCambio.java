package clases;

import java.util.Scanner;

public class TasaDeCambio {
    private String monedaInicial;
    private String monedaFinal;
    private double tasa;

    public TasaDeCambio(TasaDeCambioApi tasa){
        this.monedaInicial = tasa.base_code();
        this.monedaFinal = tasa.target_code();
        this.tasa = tasa.conversion_rate();
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public double getTasa() {
        return tasa;
    }

    public double convertir(double monto){

        double conversion = monto*this.tasa;

        return conversion;

    }

    public static void menu(){
        System.out.println("""
                *********************************************************
                Bienvenido/a al conversor de moneda:
                
                Elija una opcion valida:
                1- Pesos colombiados (COP) >>>> Dolares (USD)
                2- Dolares (USD) >>>> Pesos Colombianos (COP)
                3- Peso Mexicano (MXN) >>>> Pesos Colombianos (COP)
                4- Pesos Colombianos (COP) >>>> Pesos Mexicanos (MXN)
                5- Pesos Colombianos (COP) >>>> Real brasileño (BRL)
                6- Real Brasileño (BRL) >>>> Pesos Colombianos (COP)
                7- Salir
                *********************************************************
                """);
    }

    public static int eleccion(){
        Scanner escaner = new Scanner(System.in);
        int eleccion = escaner.nextInt();
        return eleccion;
    }
}
