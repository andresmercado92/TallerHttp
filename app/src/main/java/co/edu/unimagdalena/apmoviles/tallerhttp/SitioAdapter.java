package co.edu.unimagdalena.apmoviles.tallerhttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class SitioAdapter extends ArrayAdapter<SitiosTuristicos> {
    public SitioAdapter(@NonNull Context context, @NonNull ArrayList<SitiosTuristicos> sitiosT) {
        super(context, 0, sitiosT);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SitiosTuristicos sitt = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_sitios, parent, false);
        }
        // Lookup view for data population
        TextView nombresitio = (TextView) convertView.findViewById(R.id.txtnombre);
        TextView tipo = (TextView) convertView.findViewById(R.id.txttipo);
        TextView descripcion = (TextView) convertView.findViewById(R.id.txtdesc);
        TextView nombremunicipio = (TextView) convertView.findViewById(R.id.txtnmun);
        TextView direccion = (TextView) convertView.findViewById(R.id.txtdirec);
        TextView telefono = (TextView) convertView.findViewById(R.id.txttel);

        // Populate the data into the template view using the data object
        nombresitio.setText(sitt.getNombresitio());
        tipo.setText(sitt.getTipo());
        descripcion.setText(sitt.getDescripcion());
        nombremunicipio.setText(sitt.getNombremunicipio());
        direccion.setText(sitt.getDireccion());
        telefono.setText(sitt.getTelefono());
        // Return the completed view to render on screen
        return convertView;

    }
}