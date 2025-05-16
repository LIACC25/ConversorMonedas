
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

    public class API {

        public static Monedas obtenerMoneda(String base, String cambio) {
            //mi link + api key lleva base al ultimo porque ahi va el tipo de moneda que me piden en metodo monedas
            String direccion = "https://v6.exchangerate-api.com/v6/5d624f5146c681554ff86c2d/latest/" + base;

            try {
                HttpClient client = HttpClient.newHttpClient();//crear el cliente HTTP
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();//Hacer solcitud para llamar a API
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString()); //Enviar y recibir respuesta en String

                String json = response.body();//obtener respuesta JSON
                Gson gson = new Gson(); //instancias  de objeto gson para formatear a JSON
                CambioTipo respuesta = gson.fromJson(json, CambioTipo.class);
                // Verificar que la respuesta tiene tasas de cambio
                if (respuesta == null || respuesta.conversion_rates == null) {
                    System.out.println("Datos inválidos recibidos de la API.");
                    return null;
                }

                // Obtener el valor de la tasa de cambio para la moneda destino
                Double valor = respuesta.conversion_rates.get(cambio);

                if (valor == null) {
                    System.out.println("No se encontró tasa de cambio para " + cambio);
                    return null;
                }

                // Crear y devolver el objeto Monedas con el valor obtenido
                return new Monedas(cambio, valor);

            } catch (Exception e) {
                System.out.println("Error al consultar API: " + e.getMessage());
                return null;
            }
        }
    }

