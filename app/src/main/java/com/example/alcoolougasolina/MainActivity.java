package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
            //Recuperar Valores Digitados.
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validação dos Campos Digitados.
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados){

            //Converter Strings para numeros.
            Double valorAlcool      = Double.parseDouble(precoAlcool);
            Double valorGasolina    = Double.parseDouble(precoGasolina);

            /*Fazer cálculo de menor preço
              Se (valorAlcool / valorGasolina >= 0.7 é melhor utilizar a gasolina
              senão é melhor utilizar o alcool.
             */
            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7){
                textResultado.setText(R.string.txt_resultado_gasolina);
            }else {
                textResultado.setText(R.string.txt_resultado_alcool);
            }
        }else {
            textResultado.setText(R.string.txt_preencha_campos);
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}