package br.com.alura.conversordemoedas.calculos;

import java.util.Map;

public class TaxaDeCambio {
    private Map<String, Double> conversion_rates;
    private String base_code;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public String getbase_code() {
        return base_code;
    }
}
