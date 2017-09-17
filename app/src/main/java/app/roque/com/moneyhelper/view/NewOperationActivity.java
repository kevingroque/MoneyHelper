package app.roque.com.moneyhelper.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import app.roque.com.moneyhelper.R;
import app.roque.com.moneyhelper.model.Ahorro;
import app.roque.com.moneyhelper.model.Credito;
import app.roque.com.moneyhelper.model.Efectivo;
import app.roque.com.moneyhelper.repository.AhorroRepository;
import app.roque.com.moneyhelper.repository.CreditoRepository;
import app.roque.com.moneyhelper.repository.EfectivoRepository;

public class NewOperationActivity extends AppCompatActivity {

    private EditText monto;
    private Spinner tipo_cuenta;
    private RadioGroup tipo_operacion;
    private RadioButton rbEgresar, rbIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        monto = (EditText)findViewById(R.id.txtMonto);
        tipo_cuenta = (Spinner)findViewById(R.id.spinnerTipoCuenta);
        tipo_operacion = (RadioGroup)findViewById(R.id.radioGroup);
        rbIngresar = (RadioButton)findViewById(R.id.rBtnIngreso);
        rbEgresar = (RadioButton)findViewById(R.id.rBtnEgreso);

    }

    public void registrar(View view){
        radioButtonClicked(view);
    }

    public void radioButtonClicked(View view){
       if(rbIngresar.isChecked() == true){
           Ingresar();
       }else if(rbEgresar.isChecked() == true){
           Egresar();
       }
    }

    public void Ingresar(){
        String mon = monto.getText().toString();
        if(mon.isEmpty()){
            monto.setError("Es obligatorio rellenar este campo");
        }else{
            String selected = tipo_cuenta.getSelectedItem().toString();
            switch (selected){
                case "Ahorro":
                    Ahorro ahorro = new Ahorro(Double.parseDouble(mon));
                    AhorroRepository ahorroRepository = AhorroRepository.getInstance();
                    ahorroRepository.IngresarMonto(ahorro);
                    finish();
                    break;
                case "Efectivo":
                    Efectivo efectivo = new Efectivo(Double.parseDouble(mon));
                    EfectivoRepository efectivoRepository = EfectivoRepository.getInstance();
                    efectivoRepository.IngresarMonto(efectivo);
                    finish();
                    break;
                case "Tarjeta de Crédito":
                    Credito credito = new Credito(Double.parseDouble(mon));
                    CreditoRepository creditoRepository = CreditoRepository.getInstance();
                    creditoRepository.IngresarMonto(credito);
                    finish();
                    break;
            }
        }
    }

    public void Egresar(){
        String mon = monto.getText().toString();
        if(mon.isEmpty()){
            monto.setError("Es obligatorio rellenar este campo");
        }else{
            String selected = tipo_cuenta.getSelectedItem().toString();
            switch (selected){
                case "Ahorro":
                    Ahorro ahorro = new Ahorro(Double.parseDouble(mon));
                    AhorroRepository ahorroRepository = AhorroRepository.getInstance();
                    ahorroRepository.EgresarMonto(ahorro);
                    finish();
                    break;
                case "Efectivo":
                    Efectivo efectivo = new Efectivo(Double.parseDouble(mon));
                    EfectivoRepository efectivoRepository = EfectivoRepository.getInstance();
                    efectivoRepository.EgresarMonto(efectivo);
                    finish();
                    break;
                case "Tarjeta de Crédito":
                    Credito credito = new Credito(Double.parseDouble(mon));
                    CreditoRepository creditoRepository = CreditoRepository.getInstance();
                    creditoRepository.EgresarMonto(credito);
                    finish();
                    break;

            }
        }


    }
}
