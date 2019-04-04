package com.gifmyneeds.activities.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.gifmyneeds.R;
import com.gifmyneeds.models.ChildGifs;
import com.gifmyneeds.utilities.SharedConstants;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddNewCategoryActivity extends AppCompatActivity {
    private static final String TAG = "AddNewCategoryActivity";
    private String child_id;
    private ArrayList<String> exists_category_list;
    private ArrayList<String> category_list_to_add;
    private String[] array;
    private SharedPreferences table_childes_gif;
    private ListView list_view;
    private Spinner category_spinner;
    private Button add_btn;
    private Button prev_btn;
    private String selected_category;
    private ArrayList<String> copy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_category_layout);

        table_childes_gif = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        list_view = (ListView) findViewById(R.id.listView);
        category_spinner = (Spinner) findViewById(R.id.categorySpinner1);
        add_btn = (Button) findViewById(R.id.add_category);
        prev_btn = (Button) findViewById(R.id.prev);
        exists_category_list = new ArrayList<String>();
        array = getResources().getStringArray(R.array.categories);
        category_list_to_add = new ArrayList<String>(Arrays.asList(array));


        //get child id from previous activity
        Intent intent= getIntent();
        Bundle bundle  = intent.getExtras();

        if(bundle != null){
            child_id = bundle.getString("child_id");
        }

        showListViewOfExistsCategories();
        showSpinnerOfCategoriesToAdd();
        addListenerOnButtonPrev();

    }

    public void showListViewOfExistsCategories(){

        //TODO check why function isExists not working
        Log.d(TAG, "showListViewOfExistsCategories: enter the function");
        // if child exists in shared preference
        if(table_childes_gif.contains(child_id)){
            Log.d(TAG, "showListViewOfExistsCategories: enter to if");
            List<ChildGifs> list_of_gif = SharedConstants.getChildGifsListFromSharedPreference(child_id, table_childes_gif);
            Log.d(TAG, "showListViewOfExistsCategories: after shared preference");
            // take out all categories of child
            for (ChildGifs child_gifs : list_of_gif){
                exists_category_list.add(child_gifs.getCategory());
            }

            copy = new ArrayList<String>(exists_category_list);

            if(exists_category_list.isEmpty())
                Log.d(TAG, "showListViewOfExistsCategories: EMPTY!!!!!!!!!!!!!!!1");

            // show all categories with spinner
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, exists_category_list);
            list_view.setAdapter(adapter);

            if(exists_category_list.isEmpty())
                Log.d(TAG, "showListViewOfExistsCategories: EMPTY!!!!!!!!!!!!!!!2");
        }

    }

    public void showSpinnerOfCategoriesToAdd(){

        String totest1;

//        for (String category : category_list_to_add){
//            totest1 = category.toString();
//            if (isExists(totest1)){
//                category_list_to_add.remove(totest1);
//                Log.d(TAG, "showSpinnerOfCategoriesToAdd: In if");
//            }
//
//        }
        //category_list_to_add.retainAll(exists_category_list);
        // show all categories with spinner
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, category_list_to_add);
        category_spinner.setAdapter(adapter);

        addListenerOnSpinner();
        }


    public void addListenerOnSpinner(){

        category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int flag = 1;
                selected_category = (String) parent.getItemAtPosition(position);
//
//                for(int i = 0; i < exists_category_list.size(); i++)
//                    if (selected_category.equals(exists_category_list.get(i))){
//                        flag = 0;
//                        Toast.makeText(getApplicationContext(), selected_category, Toast.LENGTH_SHORT).show();
//                    }
//
//                if (flag == 1)
                addListenerOnButton();
//                else
//                    Toast.makeText(getApplicationContext(), "קטגוריה כבר קיימת", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

//    public boolean isExists(String to_add_category){
//        String totest2;
//        if (exists_category_list.isEmpty())
//            Log.d(TAG, "isExists: NOT EXISTS!!!!!!!!!!!!!");
//        if (copy.isEmpty())
//            Log.d(TAG, "isExists: COPY NOT EXISTS!!!!!!!!!!!!!");
//        for(String exits_category : exists_category_list){
//            if(to_add_category.equals(exits_category))
//                return true;
//            }
//        Log.d(TAG, "isExists2:" + to_add_category.toString());
//        return false;
//        }

    public void addCategoryToChild(String category){
        ArrayList<String> lst = new ArrayList<String>();
        ChildGifs obj = new ChildGifs(child_id, category,lst);
        List<ChildGifs> list_of_gif = SharedConstants.getChildGifsListFromSharedPreference(child_id, table_childes_gif);

        list_of_gif.add(obj);

        Gson gson = new Gson();
        String jsonGifs = gson.toJson(list_of_gif);

        SharedPreferences.Editor prefsEditor = table_childes_gif.edit();

        prefsEditor.putString(child_id, jsonGifs);
        prefsEditor.commit();
    }

    public void addListenerOnButton(){

        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clickeddddddddddddddd");
                addCategoryToChild(selected_category);
                exists_category_list = new ArrayList<String>();
                showListViewOfExistsCategories();
            }
        });
    }

    public void addListenerOnButtonPrev(){

        prev_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewCategoryActivity.this, SelectCategoryForBoardActivity.class);
                intent.putExtra("child_id", child_id);
                startActivity(intent);
            }
        });
    }
}

