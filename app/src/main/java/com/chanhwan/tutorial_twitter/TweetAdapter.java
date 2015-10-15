package com.chanhwan.tutorial_twitter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.chanhwan.tutorial_twitter.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chanhwan on 2015-10-05.
 */
public class TweetAdapter extends ArrayAdapter {

    private List<Tweet> tweets = new ArrayList<Tweet>();      //Array of Tweets initialization
    private LayoutInflater inflater;

    public TweetAdapter(Activity activity, String[] items) {
        super(activity, R.layout.row_tweet, items);
        inflater = activity.getWindow().getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        for( int i = 0; i < 20; i++ ) {
            Tweet tweet = new Tweet();
            tweet.setTitle("Tweet Header # " +i);
            tweet.setBody("Tweet Body # " +i);
            tweets.add(tweet);
        }

        return inflater.inflate(R.layout.row_tweet, parent, false);
    }
}
