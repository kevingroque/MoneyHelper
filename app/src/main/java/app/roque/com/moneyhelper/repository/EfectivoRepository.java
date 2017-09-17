package app.roque.com.moneyhelper.repository;

import app.roque.com.moneyhelper.model.Efectivo;

public class EfectivoRepository {
    private String totalEfectivo;
    private Double contadorEfectivo = 0.0 ;
    private Double totalE = 0.0;

    private static EfectivoRepository _INSTANCE = null;

    private EfectivoRepository(){}

    public static EfectivoRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new EfectivoRepository();
        return _INSTANCE;
    }

    public String getTotalEfectivo() {
        return "S/. " + totalEfectivo;
    }

    public void setTotalEfectivo(String totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public void Operacion(double operador){
        contadorEfectivo = contadorEfectivo + (operador);
        setTotalEfectivo(contadorEfectivo.toString());
    }

    public void IngresarMonto(Efectivo efectivo){
        totalE = efectivo.getMontoEfectivo();
        Operacion(totalE);
    }

    public void EgresarMonto(Efectivo efectivo){
        totalE = (efectivo.getMontoEfectivo()*-1);
        Operacion(totalE);
    }
}
