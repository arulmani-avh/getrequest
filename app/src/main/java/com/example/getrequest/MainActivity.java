package com.example.getrequest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://run.mocky.io/v3/1e57bce0-a743-45e9-8193-588174e41114";
    TextView textView;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        textView = findViewById(R.id.text);

        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, response -> {
            textView.setText(response);
            Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
        }, (Response.ErrorListener) error ->
                Log.d("error", error.toString()));

        queue.add(request);
    }
}