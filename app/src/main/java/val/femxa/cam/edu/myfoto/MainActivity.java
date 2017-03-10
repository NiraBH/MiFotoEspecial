package val.femxa.cam.edu.myfoto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    private int[] array_pics = {R.drawable.ic_canadasdelteide, R.drawable.ic_surtenerife,R.drawable.ic_tenerife_rea};
    private int fotoActual = 0;
    private int longitudarray = 0;

    @Override
    protected void onCreate(Bundle bundle) {

        if (bundle== null)
        {
            Log.d("MiMensaje", "Bundle Vacio");
        }else
        {
            Log.d("MiMensaje", "Bundle Lleno");
            fotoActual = bundle.getInt("fotoActual");
        }




        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        Log.d("MiMensaje", "Setear imagen");

        View v = findViewById(R.id.botonno);
        Button boton = (Button) v;

        View v2 = findViewById(R.id.botonsi);
        Button boton2 = (Button) v2;


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensajenegativo = getResources().getString(R.string.mensajenegativo);
                Toast toast = Toast.makeText(MainActivity.this, mensajenegativo, Toast.LENGTH_SHORT);
                SharedPreferences eleccionFoto = getSharedPreferences("misGustos", Context.MODE_PRIVATE);

                ImageView imagen1 = (ImageView) findViewById(R.id.image);
                longitudarray = array_pics.length;

                imagen1.setImageResource(array_pics[fotoActual]);

                fotoActual++;

                if (longitudarray == fotoActual)
                {
                 //fotoActual = 0;
                    Intent intent =new Intent (MainActivity.this,Main2Activity.class);
                    startActivity(intent);

                }

                SharedPreferences.Editor editor= eleccionFoto.edit();
                editor.putBoolean("Veredicto"+ fotoActual, false);


                Log.d("Mimensaje", String.valueOf(eleccionFoto.getBoolean("Opinion"+fotoActual,false)));

                editor.commit();


                toast.show();

                Log.d("MIMENSAJE","BOTON NO");
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {

                String mensaje = getResources().getString(R.string.mensajepositivo);
                Toast toast = Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT);
                SharedPreferences eleccionFotopositivo = getSharedPreferences("misGustos", Context.MODE_PRIVATE);

                ImageView imagen2 = (ImageView) findViewById(R.id.image);
                longitudarray = array_pics.length;

                imagen2.setImageResource(array_pics [fotoActual]);

                fotoActual++;

                if (longitudarray == fotoActual)
                {
                    //fotoActual = 0;
                    Intent intent =new Intent (MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }

                SharedPreferences.Editor editor= eleccionFotopositivo.edit();
                editor.putBoolean("Veredicto" +fotoActual, true);

                Log.d("Mimensaje", String.valueOf(eleccionFotopositivo.getBoolean("Opinion"+fotoActual,true)));

                editor.commit();

                toast.show();

                Log.d("MIMENSAJE","BOTON SI");


            }
        });


    }

    @Override
    protected void onStart() {
        Log.d("MiMensaje", "Entro en onStart");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("MiMensaje", "Entro en onResume");
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {

        bundle.putInt("fotoActual", fotoActual);

        super.onSaveInstanceState(bundle);
    }
}
