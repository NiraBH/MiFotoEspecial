package val.femxa.cam.edu.myfoto;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedPreferences = getSharedPreferences("misGustos", Context.MODE_PRIVATE);
        boolean primeraposicion = true;
        TextView textView = (TextView) findViewById(R.id.gustos);
        String opiniones = textView.getText().toString();

        for(int i = 1;i<=3;i++)
        {
            if(sharedPreferences.getBoolean("Veredicto"+i,false))
            {
                if(primeraposicion)
                {
                    opiniones = "Si le ha gustado la foto nº"+i;
                }
                else
                {
                    opiniones = opiniones + ", la foto nº" + i;
                }

                primeraposicion = false;
            }
        }

        if(primeraposicion)
        {
            opiniones = "No me gustan las fotos";
        }

        textView.setText(opiniones);


    }
}
