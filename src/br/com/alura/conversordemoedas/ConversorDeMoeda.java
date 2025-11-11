package br.com.alura.conversordemoedas;

import java.io.FileInputStream;
import java.io.IOException;
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

}
