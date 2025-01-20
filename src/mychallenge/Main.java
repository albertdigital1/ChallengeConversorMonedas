package mychallenge;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion = 0 ;
        Double tipoDeCambio;
        System.out.println("******************************************");
        System.out.println("\nSea bienvenido al conversor de moneda:");


        String menu = """
                
                1 - Dólar ==> Peso Argentino
                2 - Peso Argentino ==> Dólar 
                3 - Dólar ==> Real Brasileño
                4 - Real Brasileño ==> Dólar
                5 - Dólar ==> Peso mexicano
                6 - Peso mexicano ==> Dólar 
                7 - Salir  
                """;

        Scanner teclado = new Scanner(System.in);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ba897d42150fb1cc8d0a31a1/latest/USD"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();
        Moneda exchange= gson.fromJson(json, Moneda.class);
        System.out.println(json);
        JsonObject conversionRates = exchange.getConversionRates();

        while (opcion != 9){

            System.out.println(menu);
            System.out.println("*** Elija una opción válida ***");
            System.out.println("\n*********************");

            opcion = teclado.nextInt();

            System.out.println("¿Cantidad a cambiar?");
            int valorAConvertir = teclado.nextInt();

            switch (opcion){
                case 1:

                    tipoDeCambio = conversionRates.get("ARS").getAsDouble();
                    //tipoDeCambio = exchange.getConversionRates().get("ARS");
                    System.out.println("Tipo de cambio: " + tipoDeCambio );
                    System.out.println("Total: " + valorAConvertir* tipoDeCambio );

                    break;
                case 2:


                    tipoDeCambio = conversionRates.get("ARS").getAsDouble();
                    System.out.println("Tipo de cambio: " + tipoDeCambio );
                    System.out.println("Total: " + valorAConvertir / tipoDeCambio );



                    break;
                case 3:

                    tipoDeCambio = conversionRates.get("BRL").getAsDouble();
                    System.out.println("Tipo de cambio: " + tipoDeCambio );
                    System.out.println("Total: " + valorAConvertir* tipoDeCambio );



                    break;
                case 4:


                    tipoDeCambio = conversionRates.get("BRL").getAsDouble();
                    System.out.println("Tipo de cambio: " + tipoDeCambio );
                    System.out.println("Total: " + valorAConvertir / tipoDeCambio );
                    break;
                case 5:


                    tipoDeCambio = conversionRates.get("MXN").getAsDouble();
                    System.out.println("Tipo de cambio: " + tipoDeCambio );
                    System.out.println("Total: " + valorAConvertir* tipoDeCambio );
                    break;
                case 6:


                    tipoDeCambio = conversionRates.get("MXN").getAsDouble();
                    System.out.println("Tipo de cambio: " + tipoDeCambio );
                    System.out.println("Total: " + valorAConvertir / tipoDeCambio );
                    break;
                case 7:
                    System.out.println("SGracias por utilizar nuestros servicios");
                    break;

                    default:
                    System.out.println("Opcion no valida");

            }
        }
    }
}