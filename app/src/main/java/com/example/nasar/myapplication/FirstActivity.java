package com.example.nasar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.nasar.myapplication.R.id.parent;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    ListView IvCountries;
    EditText et;
    Button button5;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrCountries = new ArrayList<String>();
    String Country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        button5 = (Button) findViewById(R.id.button5);
        et = (EditText) findViewById(R.id.et);

        arrCountries.add("France");
        arrCountries.add("Spain");
        arrCountries.add("Italy");
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrCountries);
        button5.setOnClickListener(this);

        IvCountries = (ListView) findViewById(R.id.IvCounties);
        IvCountries.setAdapter(adapter);
        IvCountries.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) this);
    }

    @Override
    public void onClick(View v) {
        Country = et.getText().toString();
        if (Country.isEmpty()) {
            //   Context context = getApplicationContext();
            CharSequence text = "empty";
            //   int duration = Toast.LENGTH_SHORT;
            Toast.makeText(this, "Empty", 1000).show();
            // toast.show();
        } else {
            arrCountries.add(Country);
            adapter.notifyDataSetChanged();
        }
    }

        @Override
        public boolean onLongClick (View v){
            arrCountries.remove(Country);
            adapter.notifyDataSetChanged();
            return false;
        }
    }


