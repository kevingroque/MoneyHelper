package app.roque.com.moneyhelper.model;

public class Credito {

    private Double montoCredito;

    public Credito(Double montoCredito) {
        this.montoCredito = montoCredito;
    }

    public Double getMontoCredito() {
        return montoCredito;
    }

    public void setMontoCredito(Double montoCredito) {
        this.montoCredito = montoCredito;
    }

    @Override
    public String toString() {
        return "Credito{" +
                "montoCredito=" + montoCredito +
                '}';
    }
}
