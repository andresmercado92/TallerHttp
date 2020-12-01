package co.edu.unimagdalena.apmoviles.tallerhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button conectar, listar;
    TextView dato;
    String url = "https://www.datos.gov.co/resource/jj37-fvz6.json";
    ArrayList<SitiosTuristicos> st = new ArrayList<SitiosTuristicos>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conectar = findViewById(R.id.btnconectar);
        listar = findViewById(R.id.btnlistado);
        dato = findViewById(R.id.txtdato);

        conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestDatos();
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListadoSitios.class);
                i.putParcelableArrayListExtra("sitios", st);
                startActivity(i);
            }
        });
    }

    public void requestDatos(){
        RequestQueue cola = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dato.setText(response.toString());
                        parserJson(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error en la conexion", Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override

            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                // headers.put("Content-Type", "application/json");
                headers.put("X-Auth-Token", "bL2xTC3hxD9bJJrE7eezHoHmf");
                return headers;
            }
        };
        cola.add(jsonObjectRequest);
    }


    public void parserJson(JSONObject response){
        try {
            String cadena = "";
            JSONArray sitiosTuristicos = response.getJSONArray("");
            for (int i = 0 ; i<sitiosTuristicos.length(); i++) {
                JSONObject com = sitiosTuristicos.getJSONObject(i);
                String nombresitio = com.getString("nombresitio");
                String tipo = com.getString("tipo");
                String descrip = com.getString("descripcion");
                String nommun = com.getString("nombremunicipio");
                String dir = com.getString("direccion");
                String tel = com.getString("tel");
                cadena = cadena + nombresitio + "," + tipo + "," + descrip + "," + nommun + ","+ dir+ ","+ tel +"\n";
                SitiosTuristicos sit = new SitiosTuristicos(nombresitio,tipo,descrip,nommun,dir,tel);
                st.add(sit);
            }
            //Toast.makeText(getApplicationContext(),"Id = "+ cs.get(1).getId(), Toast.LENGTH_LONG).show();
            dato.setText(cadena);
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}