package app.roque.com.moneyhelper.repository;

import app.roque.com.moneyhelper.model.Ahorro;

public class AhorroRepository {

    private String totalAhorro;
    private Double contadorAhorro = 0.0 ;
    private Double totalA = 0.0;

    private static AhorroRepository _INSTANCE = null;

    private AhorroRepository(){}

    public static AhorroRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new AhorroRepository();
        return _INSTANCE;
    }

    public String getTotalAhorro() {
        return "S/. " + totalAhorro;
    }

    public void setTotalAhorro(String totalAhorro) {
        this.totalAhorro = totalAhorro;
    }

    public void Operacion(double operador){
        contadorAhorro = contadorAhorro + (operador);
        setTotalAhorro(contadorAhorro.toString());
    }

    public void IngresarMonto(Ahorro ahorro){
        totalA = ahorro.getMontoAhorro();
        Operacion(totalA);
    }

    public void EgresarMonto(Ahorro ahorro){
        totalA = (ahorro.getMontoAhorro()*-1);
        Operacion(totalA);
    }
}
