package com.example.obligatorio2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.obligatorio2.databinding.ActivityDetailBinding;

import Model.Book;
import ViewModel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_BOOK = "extra_book";
    private ActivityDetailBinding binding;
    private DetailViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(DetailViewModel.class);

        Book book = getIntent().getParcelableExtra(EXTRA_BOOK);
        if (book == null) { finish(); return; }

        binding.tvBookTitle.setText(book.getTitulo());
        binding.tvAuthor.setText(book.getAutor());
        binding.tvMeta.setText(book.getPaginas() + " p · " + book.getAño());
        binding.ivCover.setImageResource(book.getfoto());
        binding.tvDescription.setText(book.getDescripcion());

        vm.getTags().observe(this, binding.tvTags::setText);
        vm.setBook(book);

        binding.btnBack.setOnClickListener(v -> onBackPressed());
    }
}
