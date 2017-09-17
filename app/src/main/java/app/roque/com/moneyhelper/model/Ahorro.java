package app.roque.com.moneyhelper.model;

public class Ahorro {

    private Double montoAhorro;

    public Ahorro(Double montoAhorro) {
        this.montoAhorro = montoAhorro;
    }

    public Double getMontoAhorro() {
        return montoAhorro;
    }

    public void setMontoAhorro(Double montoAhorro) {
        this.montoAhorro = montoAhorro;
    }

    @Override
    public String toString() {
        return "Ahorro{" +
                "montoAhorro=" + montoAhorro +
                '}';
    }
}
