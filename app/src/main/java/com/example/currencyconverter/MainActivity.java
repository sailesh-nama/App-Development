package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner s1,s2;
    EditText et;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.txtamount);
        s1 = findViewById(R.id.spfrom);
        s2 = findViewById(R.id.spto);
        b = findViewById(R.id.btn1);

        String[] from = {"United States Dollar","Indian Rupee"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        s1.setAdapter(ad1);

        String[] to = {"United States Dollar","Indian Rupee"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        s2.setAdapter(ad2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double answer;
                Double amount = Double.parseDouble(et.getText().toString());

                if(s1.getSelectedItem().toString() == "United States Dollar" && s2.getSelectedItem().toString() == "United States Dollar")
                {
                    answer = amount;
                    Toast.makeText(getApplicationContext(),answer.toString(),Toast.LENGTH_LONG).show();
                }

                else if(s1.getSelectedItem().toString() == "United States Dollar" && s2.getSelectedItem().toString() == "Indian Rupee")
                {
                    answer = amount*76.60;
                    Toast.makeText(getApplicationContext(),answer.toString(),Toast.LENGTH_LONG).show();
                }

                else if(s1.getSelectedItem().toString() == "Indian Rupee" && s2.getSelectedItem().toString() == "Indian Rupee")
                {
                    answer = amount;
                    Toast.makeText(getApplicationContext(),answer.toString(),Toast.LENGTH_LONG).show();
                }

                else if(s1.getSelectedItem().toString() == "Indian Rupee" && s2.getSelectedItem().toString() == "United States Dollar")
                {
                    answer = amount/76.60;
                    Toast.makeText(getApplicationContext(),answer.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
