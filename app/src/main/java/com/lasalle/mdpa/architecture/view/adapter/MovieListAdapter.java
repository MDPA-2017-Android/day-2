package com.lasalle.mdpa.architecture.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Movie;

import java.util.List;

public class MovieListAdapter extends ArrayAdapter<Movie> {

    private final Context context;
    private final List<Movie> values;

    public MovieListAdapter(Context context, List<Movie> values) {
        super(context, -1, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.movie_layout, parent, false);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView extraInfoText = (TextView) rowView.findViewById(R.id.extra_info);

        Movie movie = values.get(position);
        titleText.setText(movie.getTitle());

        extraInfoText.setText(movie.getDirector() + " - " + Integer.toString(movie.getReleaseYear()));

        return rowView;
    }

}
