package happyapps.ejercicio133_almacenamientosharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv2;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv2=(TextView)findViewById(R.id.tv2);
        et1=(EditText)findViewById(R.id.et1);
        SharedPreferences prefe = getSharedPreferences("puntaje", Context.MODE_PRIVATE);
        tv2.setText(String.valueOf(prefe.getInt("puntos",0)));
    }

    public void verificar(View view){
        int num=(int)(Math.random()*11);
        String valorIngresado = et1.getText().toString();
        int valor = Integer.parseInt(valorIngresado);
        SharedPreferences preferencias=getSharedPreferences("puntaje",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();

        if (valor == num){
            Toast notification= Toast.makeText(this,"Es correcto el numero",Toast.LENGTH_SHORT);
            notification.show();
            int puntaje=Integer.parseInt(tv2.getText().toString());
            editor.putInt("puntos",puntaje+1);
            editor.apply();
            finish();


        }else if(valor > num){
            Toast notification= Toast.makeText(this,"El numero que ingresaste es mayor",Toast.LENGTH_SHORT);
            notification.show();
        }else if(valor < num){
            Toast notification= Toast.makeText(this,"El numero que ingresaste es menor",Toast.LENGTH_SHORT);
            notification.show();
        }


    }
}
