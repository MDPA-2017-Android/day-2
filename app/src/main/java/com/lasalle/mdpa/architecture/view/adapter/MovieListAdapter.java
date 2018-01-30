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

    static class ViewHolder {
        TextView title;
        TextView extraInfo;
    }

    public MovieListAdapter(Context context, List<Movie> values) {
        super(context, -1, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.movie_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) rowView.findViewById(R.id.title);
            viewHolder.extraInfo = (TextView) rowView.findViewById(R.id.extra_info);

            rowView.setTag(viewHolder);
        }


        ViewHolder holder = (ViewHolder) rowView.getTag();

        Movie movie = values.get(position);
        holder.title.setText(movie.getTitle());

        holder.extraInfo.setText(movie.getDirector() + " - " + Integer.toString(movie.getReleaseYear()));

        return rowView;
    }

}
