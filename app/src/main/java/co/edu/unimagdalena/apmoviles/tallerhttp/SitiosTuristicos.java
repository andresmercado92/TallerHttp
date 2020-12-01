package co.edu.unimagdalena.apmoviles.tallerhttp;

import android.os.Parcel;
import android.os.Parcelable;

public class SitiosTuristicos implements Parcelable {
    private String nombresitio;
    private String tipo;
    private String descripcion;
    private String nombremunicipio;
    private String direccion;
    private String telefono;

    public SitiosTuristicos(String nombresitio, String tipo, String descripcion, String nombremunicipio, String direccion, String telefono) {
        this.nombresitio = nombresitio;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nombremunicipio = nombremunicipio;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    protected SitiosTuristicos(Parcel in) {
        nombresitio = in.readString();
        tipo = in.readString();
        descripcion = in.readString();
        nombremunicipio = in.readString();
        direccion = in.readString();
        telefono = in.readString();
    }

    public static final Creator<SitiosTuristicos> CREATOR = new Creator<SitiosTuristicos>() {
        @Override
        public SitiosTuristicos createFromParcel(Parcel in) {
            return new SitiosTuristicos(in);
        }

        @Override
        public SitiosTuristicos[] newArray(int size) {
            return new SitiosTuristicos[size];
        }
    };

    @Override
    public String toString() {
        return "SitiosTuristicos{" +
                "nombresitio='" + nombresitio + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nombremunicipio='" + nombremunicipio + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String getNombresitio() {
        return nombresitio;
    }

    public void setNombresitio(String nombresitio) {
        this.nombresitio = nombresitio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombresitio);
        dest.writeString(tipo);
        dest.writeString(descripcion);
        dest.writeString(nombremunicipio);
        dest.writeString(direccion);
        dest.writeString(telefono);
    }
}
