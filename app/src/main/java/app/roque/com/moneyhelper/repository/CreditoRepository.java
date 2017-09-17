package app.roque.com.moneyhelper.repository;

import app.roque.com.moneyhelper.model.Credito;

public class CreditoRepository {

    private String totalCredito;
    private Double contadorCredito = 0.0 ;
    private Double totalC = 0.0;

    private static CreditoRepository _INSTANCE = null;

    private CreditoRepository(){}

    public static CreditoRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new CreditoRepository();
        return _INSTANCE;
    }

    public String getTotalCredito() {
        return "S/. " + totalCredito;
    }

    public void setTotalCredito(String totalCredito) {
        this.totalCredito = totalCredito;
    }

    public void Operacion(double operador){
        contadorCredito = contadorCredito + (operador);
        setTotalCredito(contadorCredito.toString());
    }

    public void IngresarMonto(Credito credito){
        totalC = credito.getMontoCredito();
        Operacion(totalC);
    }

    public void EgresarMonto(Credito credito){
        totalC = (credito.getMontoCredito()*-1);
        Operacion(totalC);
    }
}
