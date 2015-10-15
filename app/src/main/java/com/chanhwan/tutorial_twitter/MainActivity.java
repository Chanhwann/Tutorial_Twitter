package com.chanhwan.tutorial_twitter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    EditText username;
    EditText pwd;
    String usernameValue;
    String pwdValue;
    Button _loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefs = getSharedPreferences("Tutorial_twitter", MODE_PRIVATE);

        String savedUsername = prefs.getString("key_for_username", "");
        String savedPwd = prefs.getString("key_for_username", "");

        //check if the current Activity needs to be skipped
        if (savedUsername != "" && savedPwd != "") {

            Log.d("Tutorial", "username caught - " + usernameValue + " & pwd caught - " + pwdValue +
                  " / savedUsername caught - " + savedUsername + " & savedPwd caught - " + savedPwd);

            Intent intent = new Intent(this, TweetListActivity.class);
            startActivity(intent);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.fld_username);
        pwd = (EditText)findViewById(R.id.fld_pwd);

        _loginBtn = (Button)findViewById(R.id.btn_login);

        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameValue = username.getText().toString();
                pwdValue= pwd.getText().toString();

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("key_for_username", usernameValue);
                editor.putString("key_for_pwd", pwdValue);
                editor.commit();

                Log.d("Tutorial", "username caught - " + usernameValue + " & pwd caught - " + pwdValue);

                Intent intent = new Intent(MainActivity.this, TweetListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
