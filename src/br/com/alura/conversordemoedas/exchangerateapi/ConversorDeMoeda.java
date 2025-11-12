package br.com.alura.conversordemoedas.exchangerateapi;

import br.com.alura.conversordemoedas.calculos.TaxaDeCambio;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoeda {
    private String apiKey = "SUA API KEY AQUI !";
    private String baseUrl = "https://v6.exchangerate-api.com/v6/";

    public TaxaDeCambio buscartaxas(String moedaBase){
        URI urlString = URI.create(baseUrl + apiKey + "/latest/"  + moedaBase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlString)
                .build();
        try{
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request,HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),TaxaDeCambio.class);
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar taxas de câmbio: verifique a URL ou a conexão", e);

        }
    }
}
