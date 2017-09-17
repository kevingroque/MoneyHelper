package app.roque.com.moneyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import app.roque.com.moneyhelper.repository.AhorroRepository;
import app.roque.com.moneyhelper.repository.CreditoRepository;
import app.roque.com.moneyhelper.repository.EfectivoRepository;
import app.roque.com.moneyhelper.view.NewOperationActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private TextView montoA,montoC,montoE;
    private ProgressBar progressbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        montoA = (TextView) findViewById(R.id.montoAhorro);
        montoC = (TextView) findViewById(R.id.montoCredito);
        montoE = (TextView) findViewById(R.id.montoEfectivo);
        progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
        progressbar1.setProgress(30);

    }




    public void addItem(View view){
        startActivityForResult(new Intent(this, NewOperationActivity.class), REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        AhorroRepository ahorroRepository = AhorroRepository.getInstance();
        CreditoRepository creditoRepository = CreditoRepository.getInstance();
        EfectivoRepository efectivoRepository = EfectivoRepository.getInstance();

        montoA.setText(""+ahorroRepository.getTotalAhorro());
        montoC.setText(""+creditoRepository.getTotalCredito());
        montoE.setText(""+efectivoRepository.getTotalEfectivo());

    }
}
