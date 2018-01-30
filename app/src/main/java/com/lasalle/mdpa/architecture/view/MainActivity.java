package com.lasalle.mdpa.architecture.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.view.model.LibraryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LibraryViewModel libraryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        libraryViewModel = ViewModelProviders.of(this).get(LibraryViewModel.class);

        libraryViewModel.setResources(getResources());

        libraryViewModel.getMovieTitleList().observe(this, movieTitleList -> {
            ListView movieListView = (ListView) findViewById(R.id.movie_list);
            populateListView(movieListView, movieTitleList);
        });

        libraryViewModel.getTvShowTitleList().observe(this, tvShowList -> {
            ListView tvShowListView = (ListView) findViewById(R.id.shows_list);
            populateListView(tvShowListView, tvShowList);
        });
    }

    private void populateListView(ListView listView, List<String> items) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items );

        listView.setAdapter(arrayAdapter);
    }

}
