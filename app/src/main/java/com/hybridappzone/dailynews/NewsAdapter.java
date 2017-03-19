package com.hybridappzone.dailynews;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import static android.R.attr.author;

/**
 * Created by Vasanth on 17-03-2017.
 */

public class NewsAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<NewsData> DataList;
    ImageLoader imageLoader = NewsController.getPermission().getImageLoader();

    public NewsAdapter (Activity activity, List<NewsData> billionairesItems) {
        this.activity = activity;
        this.DataList = billionairesItems;
    }

    @Override
    public int getCount() {
        return DataList.size();
    }

    @Override
    public Object getItem(int location) {
        return DataList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.news_list, null);

        if (imageLoader == null)
            imageLoader = NewsController.getPermission().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.thumbImage);
        //TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.desc);
       // TextView published = (TextView) convertView.findViewById(R.id.publishedAt);



        //TextView year = (TextView) convertView.findViewById(R.id.inYear);
        NewsData m = DataList.get(position);
        thumbNail.setImageUrl(m.getUrlToImage(), imageLoader);
      //  author.setText(m.getAuthor());
        title.setText(m.getTitle());
      //  published.setText(m.getPublishedAt());

        // title.setText("News: " + String.valueOf(m.getTitle()));
        description.setText(String.valueOf(m.getDescription()));
        //year.setText(String.valueOf(m.getYear()));

        return convertView;
    }

}
