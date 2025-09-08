package Model;

import android.os.Parcelable;
import android.os.Parcel;
import java.util.List;
import java.util.ArrayList;

public class Book implements Parcelable {
    private final String id;
    private final String titulo;
    private final String autor;
    private final int paginas;
    private final int año;
    private final List<String> genero;
    private final String descripcion;
    private final int foto;

    public Book(String id, String titulo, String autor, int paginas, int año, List<String> genero, String descripcion, int foto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.año = año;
        this.genero = genero;
        this.descripcion = descripcion;
        this.foto = foto;
    }
    protected Book(Parcel in) {
        id = in.readString();
        titulo = in.readString();
        autor = in.readString();
        paginas = in.readInt();
        año = in.readInt();
        genero = new ArrayList<>();
        in.readStringList(genero);
        descripcion = in.readString();
        foto = in.readInt();
    }
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        public Book createFromParcel(Parcel in) { return new Book(in); }
        public Book[] newArray(int size) { return new Book[size]; }
    };

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getPaginas() { return paginas; }
    public int getAño() { return año; }
    public List<String> getGenero() { return genero; }
    public String getDescripcion() { return descripcion; }
    public int getfoto() { return foto; }

    public int describeContents() { return 0; }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(titulo);
        dest.writeString(autor);
        dest.writeInt(paginas);
        dest.writeInt(año);
        dest.writeStringList(genero);
        dest.writeString(descripcion);
        dest.writeInt(foto);
    }
}

