package app.roque.com.moneyhelper.model;

public class Efectivo {

    private Double montoEfectivo;

    public Efectivo(Double monroEfectivo) {
        this.montoEfectivo = monroEfectivo;
    }

    public Double getMontoEfectivo() {
        return montoEfectivo;
    }

    public void setMontoEfectivo(Double monroEfectivo) {
        this.montoEfectivo = monroEfectivo;
    }

    @Override
    public String toString() {
        return "Efectivo{" +
                "monroEfectivo=" + montoEfectivo +
                '}';
    }
}
