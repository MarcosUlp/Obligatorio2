package ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import Model.Book;

public class DetailViewModel extends ViewModel {

    private final MutableLiveData<String> tags = new MutableLiveData<>();

    public LiveData<String> getTags() {
        return tags;
    }

    public void setBook(Book book) {
        if (book != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < book.getGenero().size(); i++) {
                if (i > 0) sb.append(" • ");
                sb.append(book.getGenero().get(i));
            }
            tags.setValue(sb.toString());
        }
    }
}
