package br.com.alura.conversordemoedas;

import java.util.Map;

public class TaxaDeCambio {
    private Map<String, Double> conversion_rates;
    private String codeBase;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public String getCodeBase() {
        return codeBase;
    }
}
