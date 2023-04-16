package es.ieslavereda.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView display;
    private Button buttonPlus;
    private Button buttonEquals;
    private Button buttonClear;
    private Operacion operacion;
    private Double operando;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonClear = findViewById(R.id.buttonClear);

        buttonClear.setOnClickListener(view -> display.setText("0"));

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operando = Double.parseDouble(display.getText().toString());
                operacion = Operacion.SUMA;
                display.setText("0");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion==Operacion.SUMA) {
                    Double resultado = operando + Double.parseDouble(display.getText().toString());
                    display.setText(resultado.toString());
                }
            }
        });


    }


    @Override
    public void onClick(View view){
        if(display.getText().equals("0"))
            display.setText(((Button)view).getText());
        else
            display.setText(display.getText().toString() + ((Button)view).getText());
    }

}