package com.example.imc_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_calcular, btn_teste;
    TextView res, desc;
    EditText peso, altura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final float[] IMC = new float[1];

        peso = findViewById(R.id.Edit_Peso);
        altura = findViewById(R.id.Edit_Altura);
        res = findViewById(R.id.txt_Resultado);
        desc = findViewById(R.id.txt_desc);
        btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if (peso.getText().toString().isEmpty() && altura.getText().toString().isEmpty() || peso.getText().toString().isEmpty() || altura.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por Favor Preencha os Campos", Toast.LENGTH_SHORT).show();

                }
                else {

                    try {
                        float alt = Float.parseFloat(altura.getText().toString());

                        int peso_n = Integer.parseInt(peso.getText().toString());

                        IMC[0] = peso_n / (alt * alt);

                        if (IMC[0] <= 18.5 && IMC[0] >= 17) {
                            res.setText(IMC[0] + "");
                            desc.setText("Baixo Peso");
                        } else if (IMC[0] < 25) {
                            res.setText(IMC[0] + "");
                            desc.setText("SobrePeso");
                        } else if (IMC[0] < 30) {
                            res.setText(IMC[0] + "");
                            desc.setText("Obesidade Grau I");
                        } else {
                            res.setText(IMC[0] + "");
                            desc.setText("Obeso");
                        }

                        peso.setText("");
                        altura.setText("");
                    }catch(Exception k){
                        Toast.makeText(MainActivity.this, "Não Use Letras", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



    }


    public void calcular(View view){
        EditText txt_peso = findViewById(R.id.Edit_Peso);
        EditText txt_altura = findViewById(R.id.Edit_Altura);
        TextView txt_res = findViewById(R.id.txt_Resultado);



        int val1 = Integer.parseInt(txt_peso.getText().toString());
        int val2 = Integer.parseInt(txt_altura.getText().toString());

       txt_res.setText(Integer.toString(val1*val2));
    }

}
