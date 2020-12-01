package co.edu.unimagdalena.apmoviles.tallerhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoSitios extends AppCompatActivity {
    ArrayList<SitiosTuristicos> sit = new ArrayList<SitiosTuristicos>();
    ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_sitios);
        listado = findViewById(R.id.listado);
        Intent i = getIntent();
        sit = i.getParcelableArrayListExtra("sitios");

        if (sit!=null && sit.size()>0){
            SitioAdapter adapter = new SitioAdapter(this, sit);
            listado.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        else{
            Toast.makeText(this,"No hay datos" , Toast.LENGTH_LONG).show();
        }
    }
}