package com.example.gyleodhis.pikachapchap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
    private Button submit_btn;

    private String spinnerOneValue;
    private String spinnerTwoValue;
    private String spinnerThreeValue;
    private String spinnerFourValue;
    private String spinnerfiveValue;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        submit_btn = (Button)findViewById(R.id.button_submit);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner4.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner5.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // append all values from spinners and submit
                progressDialog.show();

                spinnerOneValue = spinner1.getSelectedItem().toString();
                spinnerTwoValue = spinner2.getSelectedItem().toString();
                spinnerThreeValue = spinner3.getSelectedItem().toString();
                spinnerfiveValue = spinner5.getSelectedItem().toString();
                spinnerFourValue = spinner4.getSelectedItem().toString();

                String dataString = getString(R.string.dataset);
                try {
                    JSONArray jsonArray = new JSONArray(dataString);
                    List<Model> modelList = new ArrayList<Model>(jsonArray.length());
                    Model model;
                    //Toast.makeText(getApplicationContext(), jsonArray.length()+" items found", Toast.LENGTH_LONG).show();
                    for(int i = 0; i < jsonArray.length(); i++){
                        model = new Gson().fromJson(jsonArray.get(i).toString(), Model.class);
                        modelList.add(model);

                        Log.d("SEARCHING", i+"");

                        if(model.getBeansVariery().equals(spinnerOneValue) &&
                                model.getSoaked().equals(spinnerTwoValue) &&
                                model.getTemperature().equals(spinnerThreeValue) &&
                                model.getHumidy().equals(spinnerFourValue) &&
                                model.getStorageMonths().equals(spinnerfiveValue)){


                            Toast.makeText(getApplicationContext(), String.valueOf(model.getCookingMinutes()) + " minutes to cook!", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }

                        if(i == (jsonArray.length() - 1)){
                            progressDialog.dismiss();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener{

        String beanType = String.valueOf(spinner1.getSelectedItem());
        String soaking = String.valueOf(spinner2.getSelectedItem());
        String temp = String.valueOf(spinner3.getSelectedItem());
        String humidity = String.valueOf(spinner4.getSelectedItem());
        String storage = String.valueOf(spinner1.getSelectedItem());

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            switch(adapterView.getId()){
                case R.id.spinner1:

                    break;
                case R.id.spinner2:

                    break;
                case R.id.spinner3:

                    break;
                case R.id.spinner4:
                    break;
                case R.id.spinner5:
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
