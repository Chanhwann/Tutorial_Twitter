package com.chanhwan.tutorial_twitter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chanhwan.tutorial_twitter.models.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetListActivity extends ListActivity {

    private ArrayAdapter tweetItemArrayAdapter;

    //private String[] stringArray;     Testing ListView with simple_list_item_1
    //private ListView tweetListView;   Testing ListView without using extends ListActivity

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        /*  Testing ListView with simple_list_item_1

        stringArray = new String[10];
        for(int i=0; i<stringArray.length; i++) {
            stringArray[i] = "String " + i;
        }

        tweetItemArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray);
        -> tweetItemArrayAdapter = new TweetAdapter(this, stringArray);
        ->
        */

        tweetItemArrayAdapter = new TweetAdapter(this, new String[20]);

        /*  Testing ListView without using extends ListActivity

        tweetListView = (ListView)findViewById(R.id.tweetList);
        tweetListView.setAdapter(tweetItemArrayAdapter);
        ->
        */

        setListAdapter(tweetItemArrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView I, View v, int position, long id) {
        /* testing onListItemClick

        TextView t = (TextView)v.findViewById(R.id.tweetTitle);
        t.setText("Tweet Clicked");
        */

        Intent intent = new Intent(this, TweetDetailActivity.class);
        startActivity(intent);
    }
}
