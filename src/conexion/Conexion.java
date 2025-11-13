package conexion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {
    public void conectar(String monedaInicial, String monedaFinal){
        HttpClient cliente = HttpClient.newHttpClient();
        String key = "6c2021114ebff13dd40e018c";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+ key +"/pair/EUR/GBP"))
                .build();

        try {
            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
