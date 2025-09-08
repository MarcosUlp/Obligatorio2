package ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Data.BookList;
import Model.Book;

public class SearchViewModel extends AndroidViewModel {

    private final BookList repo;
    private final MutableLiveData<Book> result = new MutableLiveData<>();
    private final MutableLiveData<String> message = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application app) {
        super(app);
        repo = BookList.getInstance(app);
    }

    public LiveData<Book> getResult() { return result; }
    public LiveData<String> getMessage() { return message; }

    // Evento disparado por el botón de búsqueda
    public void onSearchClicked(String query) {
        if (query == null || query.trim().isEmpty()) {
            message.setValue("Escribí un título.");
            result.setValue(null);
            return;
        }

        Book book = repo.findByTitle(query);
        if (book == null) {
            message.setValue("No se encontró el libro.");
        } else {
            message.setValue(null);
            result.setValue(book);
        }
    }
}
