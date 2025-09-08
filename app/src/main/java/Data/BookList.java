package Data;

import android.content.Context;

import com.example.obligatorio2.R;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import Model.Book;

public class BookList {
    private static BookList INSTANCE;
    private final List<Book> books;

    private BookList(Context context){
        books = Arrays.asList(
                new Book(
                        "1",
                        "El Hobbit",
                        "J.R.R. Tolkien",
                        300,
                        1937,
                        Arrays.asList("Fantasía", "Aventura"),
                        "Bilbo Bolsón, un hobbit tranquilo, es arrastrado a una aventura por el" +
                                " mago Gandalf y un grupo de enanos para recuperar un tesoro custodiado por el dragón Smaug." +
                                " Durante el viaje, Bilbo demuestra valentía, ingenio y bondad, enfrentándose a trolls," +
                                " goblins y arañas gigantes. Encuentra el anillo único que más tarde será central en “El Señor de los Anillos”." +
                                " La historia mezcla aventura, fantasía y crecimiento personal, mostrando cómo un hobbit común" +
                                " puede convertirse en héroe.",
                        R.drawable.hobbit
                ),
                new Book(
                        "2",
                        "Cien años de soledad",
                        "Gabriel García Márquez",
                        471,
                        1967,
                        Arrays.asList("Realismo mágico"),
                        "La novela narra la historia de la familia Buendía a lo" +
                                " largo de varias generaciones en el pueblo ficticio de Macondo." +
                                " Comienza con José Arcadio Buendía y su esposa Úrsula Iguarán," +
                                " y sigue a sus descendientes, quienes repiten patrones de amor," +
                                " locura, ambición y soledad. La obra mezcla realismo mágico con" +
                                " hechos fantásticos y aborda temas como la soledad, el destino, " +
                                "la memoria y la historia de América Latina. A medida que avanzan " +
                                "las generaciones, el linaje Buendía se enfrenta a tragedias inevitables hasta su desaparición final.",
                        R.drawable.cien_anios
                ),
                new Book(
                        "4",
                        "La llamada de Cthulhu",
                        "H.P. Lovecraft",
                        128, // cantidad de páginas aproximada
                        1928,
                        Arrays.asList("Horror", "Fantasía Oscura", "Misterio"),
                        "La historia narra cómo el investigador descubre evidencias de una antigua y poderosa entidad cósmica," +
                                " Cthulhu, cuya influencia puede afectar la mente de los humanos. A través de diarios, relatos y sueños," +
                                " se desvela un mundo oculto de cultos secretos y horrores indescriptibles, mostrando la insignificancia" +
                                " del ser humano frente a fuerzas cósmicas incomprensibles.",
                        R.drawable.cthulhu // pon una imagen en res/drawable/cthulhu.png
                ),
                new Book(
                        "5",
                        "Crónica de una muerte anunciada",
                        "Gabriel García Márquez",
                        120, // cantidad de páginas aproximada
                        1981,
                        Arrays.asList("Realismo", "Novela Criminal", "Literatura Latinoamericana"),
                        "La novela narra los eventos que llevan al asesinato de Santiago Nasar en un pequeño pueblo," +
                                " desde la perspectiva de varios habitantes, explorando cómo todos conocían el hecho antes de que ocurriera." +
                                " La historia aborda el destino inevitable, la fatalidad y las complicaciones de la vida en comunidad," +
                                " mostrando la tensión entre el honor, la tradición y la justicia.",
                        R.drawable.cronica // pon una imagen en res/drawable/cronica.png
                )
        );
    }

    public static synchronized BookList getInstance(Context ctx) {
        if (INSTANCE == null) INSTANCE = new BookList(ctx.getApplicationContext());
        return INSTANCE;
    }

    public Book findByTitle(String query) {
        if (query == null) return null;
        String q = query.trim().toLowerCase(Locale.ROOT);
        for (Book b : books) {
            if (b.getTitulo().toLowerCase(Locale.ROOT).contains(q)) return b;
        }
        return null;
    }
}
