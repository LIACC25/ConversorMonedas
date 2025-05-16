import java.util.Map;

public class CambioTipo{
    public String base_code;                // El código de la moneda base (por ejemplo, USD)
    public Map<String, Double> conversion_rates;  // Mapa que contiene las monedas y su tasa de conversión

    public CambioTipo(String base_code, Map<String, Double> conversion_rates) {
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}