package br.com.alura.conversordemoedas;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConversorDeMoeda {
    private String apiKey;
    private String baseUrl;

    public ConversorDeMoeda(){
        Properties prop = new Properties();
        try(FileInputStream input = new FileInputStream("api_config.properties")){
            prop.load(input);
            this.apiKey = prop.getProperty("API_KEY");
            this.baseUrl = prop.getProperty("BASE_URL");
            if (this.apiKey==null || this.apiKey.isEmpty()){
                System.out.println("Erro a Api Key nao foi encontrada ou esta vazia no arquivo ");
            }
        }catch (IOException ex) {
            System.out.println("ERRO FATAL: O arquivo 'api_config.properties' não foi encontrado na raiz do projeto.");
            this.apiKey = null;
            this.baseUrl = null;

        }

    }

    public String getApiKey() {
        return apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public TaxaDeCambio buscartaxas(String moedaBase){
        URI urlString = URI.create(baseUrl + apiKey + "/test/" + moedaBase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlString)
                .build();
        try{
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request,HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),TaxaDeCambio.class);
        }catch (Exception e){
            throw new RuntimeException(" ");

        }
    }
}
