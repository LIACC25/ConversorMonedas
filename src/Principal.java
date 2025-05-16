import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner consola=new Scanner(System.in);
        Monedas dolarA = API.obtenerMoneda("USD", "ARS");
        Monedas dolarB = API.obtenerMoneda("USD", "BRL");
        Monedas dolarC = API.obtenerMoneda("USD", "COP");


        var opcion=0;
        while(opcion!=7) {
            System.out.println("=======Valor del dólar=======");
            System.out.printf("Costo dólar -> $%.2f pesos argentinos \n"+
                            "Costo dólar -> $%.2f real brasileño \n" +
                            "Costo dólar -> $%.2f pesos colombianos \n"
                    ,dolarA.getValor(),dolarB.getValor(),dolarC.getValor());
            System.out.println("================================");
            System.out.println("*******************Conversión de Monedas***************");
            System.out.println("1 - Dólar a peso Argentino");
            System.out.println("2 - Peso Argentino a Dólar");
            System.out.println("3 - Dólar a Real brasileño");
            System.out.println("4 - Real brasileño a Dólar");
            System.out.println("5 - Dólar a peso Colombiano");
            System.out.println("6 - Peso colombiano a Dólar");
            System.out.println("7 - Dólar a peso Chileno");
            System.out.println("8 - Peso Chileno a Dólar");
            System.out.println("9 - Salir");
            System.out.println("Ingrese una opción:");

            if (consola.hasNextInt()) {
                opcion = consola.nextInt();
                if (opcion < 1 || opcion > 9) {
                    System.out.println("Opción inválida. Debe estar entre 1 y 9 :D");
                    continue;
                }

                switch (opcion) {
                    case 1 :
                        System.out.println("Convertir de Dólar a peso Argentino");
                        convertirMoneda("USD","ARS",consola,true);

                        break;
                    case 2:
                        System.out.println("Convertir de Peso Argentino a Dólar");
                        convertirMoneda("ARS","USD",consola,true);
                        break;
                    case 3:
                        System.out.println("Convertir de Dólar a Real brasileño");
                        convertirMoneda("USD","BRL",consola,true);
                        break;
                    case 4:
                        System.out.println("Convertir de Real brasileño a Dólar");
                        convertirMoneda("BRL","USD",consola,true);
                        break;
                    case 5:
                        System.out.println("Convertir de Dólar a peso Colombiano");
                        convertirMoneda("USD","COP",consola,true);
                        break;
                    case 6:
                        System.out.println("Convertir de Peso colombiano a Dólar");
                        convertirMoneda("COP","USD",consola,true);
                        break;
                    case 7:
                        System.out.println("Convertir de Dólar a Peso Chileno");
                        convertirMoneda("USD","CLP",consola,true);
                        break;
                    case 8:
                        System.out.println("Convertir Peso Chileno a Dólar");
                        convertirMoneda("CLP","USD",consola,true);
                        break;
                    case 9:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("No existe opcion");
                        break;
                }

            }else {
                System.out.println("Por favor ingresa un número");
                consola.next();
            }
        }

       consola.close();

    }
    // funcion para la conversión usando la API y Monedas
    public static void convertirMoneda(String base, String destino, Scanner consola, boolean haciaDolar) {
        System.out.print("Digita el monto en " + base + " a convertir: ");
        if (consola.hasNextDouble()) {
            double monto = consola.nextDouble();

            Monedas moneda = API.obtenerMoneda(base, destino);
            if (moneda != null) {
                double resultado;
                if (haciaDolar) {
                    resultado = moneda.convertirHacia(monto);
                    Gson json1 = new GsonBuilder()
                            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                            .setPrettyPrinting()
                            .create();
                    System.out.println(" JSON: " + json1);

                } else {
                    resultado = moneda.convertirDesde(monto);
                    Gson json2 = new GsonBuilder()
                            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                            .setPrettyPrinting()
                            .create();
                    System.out.println("JSON: " + json2);
                }
                System.out.printf(" Resultado: %.2f %s%n", resultado, destino);
            } else {
                System.out.println("No se pudo obtener el tipo de cambio desde la API.");
            }
        } else {
            System.out.println("Intente nuevamente.");
            consola.next(); // limpiar entrada inválida
        }
    }
}
