package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCategory;
    Spinner spnSubCategory;
    Button btnGo;
    ArrayList<String> alCategory = new ArrayList<String>();
    ArrayAdapter<String> aaCategory;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnCategory = (Spinner) findViewById(R.id.spinnerCategory);
        spnSubCategory = (Spinner) findViewById(R.id.spinnerSubCategory);
        btnGo = (Button) findViewById(R.id. buttonGo);

        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                alCategory.clear();
                switch(i){
                    case 0:
                        String[] strNumbers = getResources().getStringArray(R.array.sub_category_RP);
                        alCategory.addAll(Arrays.asList(strNumbers));
                        break;
                    case 1:
                        strNumbers = getResources().getStringArray(R.array.sub_category_SOI);
                        alCategory.addAll(Arrays.asList(strNumbers));
                        break;
                }
                aaCategory.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        aaCategory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);
        spnSubCategory.setAdapter(aaCategory);

       // spnSubCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         //   @Override
          //  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
           //     String selected = adapterView.getItemAtPosition(i).toString();
        //   if(selected.equals("Homepage")){
        //          url = "http://www.rp.edu.sg/";
        //      }
        //      else if(selected.equals("Code of Honour")){
        //          url ="http://www.rp.edu.sg/The_Republic_Code_of_Honour.aspx";
        //      }
        //      else if(selected.equals("DMSD")){
        //          url = "http://www.rp.edu.sg/Diploma_in_Mobile_Software_Development_(R47).aspx";
        //      }
        //      else if(selected.equals("DIT")){
        //          url ="http://www.rp.edu.sg/Diploma_in_Information_Technology_(R12).aspx";
        //      }
        //      aaCategory.notifyDataSetChanged();
        //  }

        //   @Override
        //  public void onNothingSelected(AdapterView<?> adapterView) {

        //  }
        //});


        btnGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String[][] sites = {
                        {
                                "http://www.rp.edu.sg/",
                                "http://www.rp.edu.sg/The_Republic_Code_of_Honour.aspx",
                        },
                        {
                                "http://www.rp.edu.sg/Diploma_in_Mobile_Software_Development_(R47).aspx",
                                "http://www.rp.edu.sg/Diploma_in_Information_Technology_(R12).aspx",
                        }
                };
                url = sites[spnCategory.getSelectedItemPosition()][spnSubCategory.getSelectedItemPosition()];
                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
}
