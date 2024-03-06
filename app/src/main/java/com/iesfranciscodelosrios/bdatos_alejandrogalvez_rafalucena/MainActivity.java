   package com.iesfranciscodelosrios.bdatos_alejandrogalvez_rafalucena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

   public class MainActivity extends AppCompatActivity {
       private ArtistaDAO artistaDAO;
       private EditText idEditText, nameEditText, genreEditText, ageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistaDAO = new ArtistaDAO(this);
        idEditText = findViewById(R.id.idEditText);
        nameEditText = findViewById(R.id.nameEditText);
        genreEditText = findViewById(R.id.genreEditText);
        ageEditText = findViewById(R.id.ageEditText);


        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String genre = genreEditText.getText().toString();
                double age = Double.parseDouble(ageEditText.getText().toString());

                Artist newArtist = new Artist(id, name, genre, age);
                artistaDAO.addArtist(newArtist);
                Toast.makeText(MainActivity.this, "Artista agregado", Toast.LENGTH_SHORT).show();
            }
        });


        Button updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String genre = genreEditText.getText().toString();
                double age = Double.parseDouble(ageEditText.getText().toString());

                Artist artistToUpdate = new Artist(id, name, genre, age);
                artistaDAO.updateArtist(artistToUpdate);
                Toast.makeText(MainActivity.this, "Artista actualizado", Toast.LENGTH_SHORT).show();
            }
        });

        Button listButton = findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Artist> allArtists = artistaDAO.getAllArtists();
                StringBuilder stringBuilder = new StringBuilder();
                for (Artist artist : allArtists) {
                    stringBuilder.append("ID: ").append(artist.getId()).append(", Nombre: ").append(artist.getName()).append(", Género: ").append(artist.getGenre()).append(", Edad: ").append(artist.getAge()).append("\n");
                }
                Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                artistaDAO.deleteArtist(id);
                Toast.makeText(MainActivity.this, "Artista eliminado", Toast.LENGTH_SHORT).show();
            }
        });

    }
}