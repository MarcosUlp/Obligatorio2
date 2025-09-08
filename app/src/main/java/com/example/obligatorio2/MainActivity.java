package com.example.obligatorio2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.obligatorio2.databinding.ActivityMainBinding;

import ViewModel.SearchViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SearchViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(SearchViewModel.class);

        binding.btnBuscar.setOnClickListener(v ->
                vm.onSearchClicked(binding.etBusqueda.getText().toString())
        );

        vm.getMessage().observe(this, msg -> {
            if (msg != null) {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        vm.getResult().observe(this, book -> {
            if (book != null) {
                Intent i = new Intent(this, DetailActivity.class);
                i.putExtra(DetailActivity.EXTRA_BOOK, book);
                startActivity(i);
            }
        });
    }
}
