package com.lasalle.mdpa.architecture.view.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.res.Resources;

import com.lasalle.mdpa.architecture.manager.LibraryManager;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class LibraryViewModel extends ViewModel {

    private LibraryManager libraryManager = new LibraryManager();

    private MutableLiveData<List<String>> movieTitleList;
    private MutableLiveData<List<String>> tvShowTitleList;

    public void setResources(Resources resources)
    {
        libraryManager.setResources(resources);
    }

    public LiveData<List<String>> getMovieTitleList() {
        if(movieTitleList == null) {
            movieTitleList = new MutableLiveData<>();
            populateMovieList();
        }

        return movieTitleList;
    }

    public LiveData<List<String>> getTvShowTitleList() {
        if(tvShowTitleList == null) {
            tvShowTitleList = new MutableLiveData<>();
            populateTvShowList();
        }

        return tvShowTitleList;
    }

    private void populateMovieList() {
        List<Movie> movieList = libraryManager.getMovieList();

        List<String> titleList = new ArrayList<>();
        for (Movie m : movieList) {
            titleList.add(m.getTitle());
        }

        movieTitleList.setValue(titleList);
    }

    private void populateTvShowList() {
        List<TvShow> tvShowList = libraryManager.getTvShowList();

        List<String> titleList = new ArrayList<>();
        for (TvShow s : tvShowList) {
            titleList.add(s.getTitle());
        }

        tvShowTitleList.setValue(titleList);
    }
}
