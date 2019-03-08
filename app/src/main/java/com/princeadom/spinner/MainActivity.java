package com.princeadom.spinner;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Spinner afr_ctrs_spinner,
                    spinner2;
    public Button btnSubmit;
    String itemSelected1,
            itemSelected2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //public methods to be called when the application starts
        addItemsOnSpinner2();
        addListenerOnButtonClick();
        addListenerOnSpinnerItemSelection();
    }

    //this method automatically adds items to the spinner2 view instead of us creating inside the Strings.xml resource file
    public void addItemsOnSpinner2() {
        //connect the spinner2 object with the sSpinner view ID
        spinner2 = findViewById(R.id.spinner2);

        //declare a List object from the generic class List of parameter type <String>
        //this List object stores a list of items to add to the spinner
        //we call the ArrayList<>() constructor method to enable us perform list operations on the List interface
        List<String> listOfItems = new ArrayList<String>();
        listOfItems.add("Greater Accra Region");
        listOfItems.add("Volta Region");
        listOfItems.add("Northern Region");
        listOfItems.add("Ashanti Region");

        //Next, we create an ArrayAdapter object top fetch data from the ArrayList class
        //they also help convert array elements into views using some type of layout in the setDropDownViewResource()
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listOfItems);

        //set the layout resource to create the drop-down views with
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //provide the data - list - which populates the spinner object
        spinner2.setAdapter(dataAdapter);

    }



        public void addListenerOnSpinnerItemSelection(){
            afr_ctrs_spinner = findViewById(R.id.list_of_african_countries);
            afr_ctrs_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        }


        //this method obtains the selected item from the spinner list
        public void addListenerOnButtonClick(){
        spinner2 = findViewById(R.id.spinner2);
        afr_ctrs_spinner = findViewById(R.id.list_of_african_countries);
        btnSubmit = findViewById(R.id.submit_btn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelected1 = afr_ctrs_spinner.getSelectedItem().toString();
                itemSelected2 = spinner2.getSelectedItem().toString();

                TextView displaySelected1 = findViewById(R.id.textView2);
                TextView displaySelected2 = findViewById(R.id.textView3);

                displaySelected1.setBackgroundColor(Color.parseColor("#f9a825"));
                displaySelected2.setBackgroundColor(Color.parseColor("#f9a825"));
                displaySelected1.setTextColor(Color.parseColor("#263238"));
                displaySelected2.setTextColor(Color.parseColor("#263238"));
                displaySelected1.setText(itemSelected1);
                displaySelected2.setText(itemSelected2);
            }
        });


        }


    }

