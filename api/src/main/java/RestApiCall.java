import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static java.net.http.HttpClient.newHttpClient;

public class RestApiCall {

    // los valores de las api keys se pasan como argumentos al programa
    public static void main(String[] args) throws Exception{

        // libreria de google para convertir json a objetos java y viceversa
        Gson gson = new Gson();

        /*
            -- GET request --
            Para implementar la peticion GET utilizo el api de API-FOOTBALL, que ofrece una cantidad de solicitudes
            gratuitas por dia.
            enlace: https://www.api-football.com/
        */

        final String APIFOOTBALL_API_KEY = args[0];


        // Una request se representa en java con la clase HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://v3.football.api-sports.io/teams?id=1176")) // define la url de la api
                .header("x-apisports-key", APIFOOTBALL_API_KEY) // agregamos la autorizacion con nuestar API KEY
                // en este caso, para hacer una peticion a la api de api-football necesitamos el header x-apisports-key con la API KEY como valor
                .GET()
                .build();

        // HttpClient es la clase que nos permite hacer peticiones http
        HttpClient httpClient = newHttpClient();

        // guardamos la respuesta en una variable de tipo HttpResponse de String
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        // body de la respuesta
        String responseBody = response.body();

        // imprimir el body de la respuesta
        System.out.println("Respuesta de -> GET https://v3.football.api-sports.io/teams?id=1176:");
        System.out.println(responseBody);

        // para impimir el JSON en formato legible
        Gson printJson = new Gson().newBuilder().setPrettyPrinting().create();
        String formattedBody = printJson.toJson(JsonParser.parseString(responseBody));
        System.out.println("\n Respuesta formateada a JSON: \n" + formattedBody);



        /*
            -- POST request --
            Para implementar la peticion POST utilizo el api de AssemblyAI, que ofrece una cantidad de solicitudes
            gratuitas de prueba en su plan gratis.
            enlace: https://assemblyai.com/
        */

        final String ASSEMBLYAI_API_KEY = args[1];

        // crear representacion del body de la request como objeto
        RequestBody requestBody = new RequestBody();
        requestBody.setAudio_url("https://github.com/Josiaszx/Hello-Java/raw/refs/heads/main/api/audio.mp3");

        // crear JSON a partir del objeto
        String jsonBody = gson.toJson(requestBody);

        // crear la request para transcribir el audio
        HttpRequest postRequest = HttpRequest.newBuilder()
                .POST(BodyPublishers.ofString(jsonBody))
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", ASSEMBLYAI_API_KEY)
                .build();

        // obtener y mostrar la respuesta
        HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
        System.out.println("\nRespuesta de -> POST https://api.assemblyai.com/v2/transcript:");
        System.out.println(postResponse.body() + "\n");

        // deserializar el JSON a un objeto para obtener el id de la transcripcion
        RequestBody PostResponseBody = gson.fromJson(postResponse.body(), RequestBody.class);

        // crear una GET request para obtener la transcripcion
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + PostResponseBody.getId()))
                .header("Authorization", ASSEMBLYAI_API_KEY)
                .build();

        // eviar GET request hasta obtener la transcripcion
        System.out.println("Consultando https://api.assemblyai.com/v2/transcript/" + PostResponseBody.getId() +":");
        while (true) {
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            RequestBody getResponseBody = gson.fromJson(getResponse.body(), RequestBody.class);

            System.out.println("Status: " + getResponseBody.getStatus());

            if (getResponseBody.getStatus().equals("completed")) {
                System.out.println("Transcripcion completada");
                System.out.println("Texto transcrito: \n" + getResponseBody.getText());
                break;
            } else if (getResponseBody.getStatus().equals("error")) {
                System.out.println("Error al transcribir el audio");
                break;
            }

            Thread.sleep(2000);
        }
    }

}
