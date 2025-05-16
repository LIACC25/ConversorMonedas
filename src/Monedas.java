public class Monedas {
    private String TipoMoneda;
    private double valor;

    public Monedas(String tipoMoneda, double valor) {
        TipoMoneda = tipoMoneda;
        this.valor = valor;
    }

    public String getTipoMoneda() {
        return TipoMoneda;
    }

    public double getValor() {
        return valor;
    }

    public double convertirDesde(double total){
        return  total /  valor;
    }

    public double convertirHacia(double total){
        return total * valor;
    }

    @Override
    public String toString() {
        return String.format("Moneda: %s | Valor: %.2f", TipoMoneda, valor);
    }

}
