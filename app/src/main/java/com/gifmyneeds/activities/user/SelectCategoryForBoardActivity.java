package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import com.gifmyneeds.R;
import com.gifmyneeds.models.ChildGifs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SelectCategoryForBoardActivity extends AppCompatActivity {

    private Spinner category_spinner;
    private ImageButton add_btn;
    private SharedPreferences table_childes_gif;
    private String child_id;
    private ArrayList<String> category_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_category_for_board_activity_layout);

        category_spinner = (Spinner) findViewById(R.id.categorySpinner);
        add_btn = (ImageButton) findViewById(R.id.imageButton);
        table_childes_gif = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        category_list = new ArrayList<String>();
//
//        String[] array = {"bla1", "bla2", "bla3"};
//
//        ArrayList<String> lst = new ArrayList<String>(Arrays.asList(array));
//
//        child_id = "1234";
//
//        List<ChildGifs> testList= new ArrayList<ChildGifs>();
//
//        ChildGifs obj = new ChildGifs(child_id, "אוכל", lst);
//        ChildGifs obj1 = new ChildGifs(child_id, "תחביבים", lst);
//
//        testList.add(obj);
//        testList.add(obj1);
//
//        Gson gson = new Gson();
//        String json = gson.toJson(testList);
//
//        SharedPreferences.Editor editor = table_childes_gif.edit();
//
//        editor.clear();
//
//        editor.putString(child_id, json);
//
//        editor.commit();


        // get child id from previous activity
        Intent intent= getIntent();
        Bundle bundle  = intent.getExtras();

        if(bundle != null){
            child_id = bundle.getString("id");
        }

        showSpinnerOfCategories();

        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });
    }

    public void showSpinnerOfCategories(){
        // if child exists in shared preference
        if(table_childes_gif.contains(child_id)){

            // take out all child gifs into a json
            Gson gson = new Gson();
            String json = table_childes_gif.getString(child_id, "");

            // convert json to list
            Type type = new TypeToken<List<ChildGifs>>(){}.getType();
            List<ChildGifs> list_of_gif = gson.fromJson(json, type);

            // take out all categories of child
            for (ChildGifs child_gifs : list_of_gif){
                category_list.add(child_gifs.getCategory());
            }

            // show all categories with spinner
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, category_list);
            category_spinner.setAdapter(adapter);
        }

    }

//    public void addNewChildToPreferences(String child_id){
//        int score = SharedConstants.scoreMap.get(answer);
//        SharedPreferences.Editor score_editor = table_score_prefs.edit();
//
//        //score_editor.clear();
//
//        score_editor.putInt("question1", score);
//
//        score_editor.commit();
//    }


}
